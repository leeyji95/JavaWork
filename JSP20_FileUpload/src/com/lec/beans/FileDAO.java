package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.D;

// DAO : Data Access Object
//   DB 에 접속하여 트랜잭션을 수행하는 객체

// 다루는 데이터 소스의 종류에 따라 DAO는 여러개 정의 사용 가능

public class FileDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()

	// DAO 객체가 생성될때 Connection 도 생성된다.
	public FileDAO() {

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

	
	// ResultSet --> DTO 배열로 리턴
	public FileDTO[] createArray(ResultSet rs) throws SQLException	{
		
		FileDTO[] arr = null;
		List<FileDTO> list = new ArrayList<FileDTO>();
		
		while(rs.next()){
			int uid = rs.getInt("bf_uid");
			String source = rs.getString("bf_source");
			String file = rs.getString("bf_file");
			
			FileDTO dto = new FileDTO(uid, source, file);
			list.add(dto);
		} // end while
		
		arr = new FileDTO[list.size()];
		list.toArray(arr);
		return arr;
	} // end createArray()
	
	// 특정 글(wr_uid) 의  첨부파일(들) SELECT 
	public FileDTO[] selectFilesByWrUid(int wrUid) throws SQLException{
		FileDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT); // 특정 글의 첨부된 파일만 가져옴 
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();
			arr = createArray(rs); // 결과를 위에 만들어놓은 createArray 로 받겠다. 
		} finally {
			close();
		}
		return arr;
	} // end selectFilesByWrUid

	// 특정 파일(bf_uid) 의  첨부파일 하나 SELECT 
	public FileDTO[] selectByUid(int Uid) throws SQLException{
		FileDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT_BY_UID); // 특정 파일의 첨부된 파일 하나만  가져옴 
			pstmt.setInt(1, Uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs); // 결과를 위에 만들어놓은 createArray 로 받겠다. 
		} finally {
			close();
		}
		return arr;
	} // end selectFilesByWrUid
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} // end calss
