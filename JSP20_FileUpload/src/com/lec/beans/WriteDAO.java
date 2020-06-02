package com.lec.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import common.D;

// DAO : Data Access Object
//   DB 에 접속하여 트랜잭션을 수행하는 객체

// 다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능

public class WriteDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()

	// DAO 객체가 생성될때 Connection 도 생성된다.
	public WriteDAO() {

		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}

	} // 생성자

	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	} // end close()

	// 새글 작성 <-- DTO
	public int insert(WriteDTO dto) throws SQLException {
		String subject = dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();

		int cnt = this.insert(subject, content, name);
		return cnt;
	}

	// 새글 작성 <-- 제목, 내용, 작성자
	public int insert(String subject, String content, String name) throws SQLException {
		int cnt = 0;

		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);

			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}

		return cnt;
	}

	// 메소드 오버로딩
	// 새글작성 <- 제목, 내용, 작성자 
	// 		 <- 첨부파일(들)
	public int insert(String subject, String content, String name, 
			List<String> originalFileNames, // 원본 파일명(들)
			List<String> fileSystemNames 	// 저장된 파일명(들)
			) throws SQLException {
		int cnt = 0;
		int uid = 0; // INSERT 된 글의 wr_uid 값
		
		try {
			// 자동생성된 컬럼의 이름(들)이 담긴 배열 준비(auto-generated keys)
			// 이거 왜함?  글작성하면 uid 생성되잖아. 그 uid 값 받아와야 그 uid 게시글에 파일첨부할 수 있으니까
			String[] generatedCols = {"wr_uid"};
			
			// Statement 나 PreparedStatement  생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌  
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT, generatedCols);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);

			cnt = pstmt.executeUpdate();
			// uid, 지금 rs 에 담겨 있음(쿼리 실행 결과는 Rs 에 담겨나오잖아)
			// 그거 꺼내와야함
			
			// auti-generated keys 값 뽑아오기
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				uid = rs.getInt(1); // 첫번째 컬럼 
			}
			
			pstmt.close(); // 또 쓸거기 떄문에 일단 close 해주기
			// 첨부파일(들) 정보 테이블에  INSERT 하기 
			pstmt = conn.prepareStatement(D.SQL_FILE_INSERT);
			// 해당 uid 에 대한 게시 글에 여러 첨부파일 저장될 수 있다 . -> 지금 그거 해보는거야 
			for(int i = 0; i < originalFileNames.size(); i++) {
				pstmt.setString(1,  originalFileNames.get(i));
				pstmt.setString(2,  fileSystemNames.get(i));
				pstmt.setInt(3,  uid);
				pstmt.execute();
			}
			
			
			
			
			
		} finally {
			close();
		}
		
		return cnt;
	}

	// ResultSet --> DTO 배열로 리턴
	public WriteDTO[] createArray(ResultSet rs) throws SQLException {
		WriteDTO[] arr = null; // DTO 배열

		ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();

		while (rs.next()) {
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			String content = rs.getString("wr_content");
			int viewCnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");

			String regDate = "";
			if (d != null) {
				regDate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}

			WriteDTO dto = new WriteDTO(uid, subject, content, name, viewCnt);
			dto.setRegDate(regDate);
			list.add(dto);

		} // end while

		int size = list.size();

		if (size == 0)
			return null;

		arr = new WriteDTO[size];
		list.toArray(arr); // List -> 배열
		return arr;
	}

	
	
	
	// 전체 SELECT (데이터 전체 조회)
	public WriteDTO[] select() throws SQLException {
		WriteDTO[] arr = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}

		return arr;
	} // end select()

	
	
	
	
	// 특정 uid 글 내용 읽기, 조회수 증가
	// viewCnt 도 1 증가 해야 하고, 읽어와야 한다. --> 트랜잭션 처리
	public WriteDTO[] readByUId(int uid) throws SQLException {

		int cnt = 0;
		WriteDTO arr[] = null;
		try {
			// 트랜잭션 처리
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();

			pstmt.close();
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();

			arr = createArray(rs);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback(); // 예외 발생하면 rollback 하고
			throw e; // 다시 예외를 throw
		} finally {
			close();
		} 
		return arr;
	} // end readByUId()

	
	// 특정 uid 의 글만 SELECT
	public WriteDTO[] selectByUid(int uid) throws SQLException {
		WriteDTO[] arr = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}

		return arr;
	}

	
	
	// 특정 uid 글 수정 ( 제목, 내용 )
	public int update(int uid, String subject, String content) throws SQLException {
		int cnt = 0;
		try {  
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);
			
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		} 
		return cnt;
	} // end update()
		
		
	// 특정 uid 글 삭제하기
	public int deleteByUid(int uid) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		return cnt;
	} // end deleteByUid()

} // end calss
