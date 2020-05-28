package user.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import query.D;


public class DAO {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()

	public DAO() {
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
	
	

	// 정보 등록
	public int join(DTO dto) {


		
			try {
				pstmt = conn.prepareStatement(D.SQL_INSERT_TB_USER);
				pstmt.setString(1, dto.getUserID());
				pstmt.setString(2, dto.getUserPassword());
				pstmt.setString(3, dto.getUserEmail());
				pstmt.setString(4, dto.getUserEmailHash());
				
				System.out.println("회원가입 성공! (insert 완료)");
				return pstmt.executeUpdate();  // 
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			} 	
			System.out.println("회원가입 실패...");
			return -1;  // 회원가입 실패
	}

	
	// 사용자 아이디 이용해서 이메일 주소 알아낸다.  문자열형으로 return 
	public String getUserEmail(String userID) throws SQLException {

		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_USEREMAIL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}
		} finally {
			close();
		}
		return null; // 데이터 베이스 오류
	}
	
	// 사용자가 현재 이메일 인증 되었는지 확인.
	public String getUserEmailChecked(String userID) throws SQLException {
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_USEREMAILCHECKED);
			pstmt.setString(1,  userID);
			rs = pstmt.executeQuery()	;
			while(rs.next()) {
				return rs.getString(1); // 이메일 등록 여부 반환
			}
		}finally {
				close();
		}
		return null; // 데이터 베이스 오류 
	}
	
	
	
	// 특정한 사용자의 이메일 인증 
	public String setUserEmailChecked(String userID) throws SQLException {
		
		try {
			pstmt = conn.prepareStatement(D.SQL_UPDATE_USEREMAILCHECKED);
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			while(rs.next()) {
				return rs.getString(1); // 이메일 등록 설정 성공
			}
		}finally {
			close();
		}
		return null;  // 이메일 등록 설정 실패
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
