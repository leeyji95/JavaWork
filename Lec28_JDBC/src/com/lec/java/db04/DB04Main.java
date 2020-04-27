package com.lec.java.db04;
/*
 * 첨부파일이 있는 경우,  
 * 특정 문서를 레퍼런싱해야하는데, 그 문서가 * 인서트 된 시점에서 그 키값을 알아내야한다? 
 * 인서트낸 직후에 바로 키값 알아내는 방법.. 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.lec.java.db.Query;

/*  auto-generated keys 값
 * 	SEQUENCE (ORACLE),  AUTO_INCREMENET (mysql),  IDENTITY (mssql) 등으로
 *  새로운 레코드 INSERT 시 자동 생성된 key 값 알아내기    
 */
public class DB04Main implements Query {

	public static void main(String[] args) {
		System.out.println("DB 4 - generated id값");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 자동생성되는 컬럼의 이름(들) 이 담긴 배열 준비 (auto-generated keys 배열)
		String [] generatedCols = {COL_LABEL_NO}; // 자동생성되는 컬럼들의 이름을 담음.  언제? 인서트 할 떄.        해당 컬럼에 자동 생성된 키값 ...  받아오는 거 배운거다. 
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			System.out.println();
			System.out.println("INSERT");
			// Statement 나 PreparedStatement 생성시 두번째 매개변수로 auto-generated keys 배열 넘겨줌
			 
			pstmt = conn.prepareStatement(SQL_INSERT_SEQ, generatedCols);  //  gera 에 있는 컬럼들의 값을 끄집어 냄. 
			pstmt.setString(1,  "그루트");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 INSERT 성공");
			
			// auto-generated keys 값 뽑아오기
			// insert 직후, 아직 pstm 클로즈 하지 말구
			rs = pstmt.getGeneratedKeys(); // rs으로 리턴함 그러면 하나씩 끄집어 내야 겠지
			if(rs.next()) {
				long genKey = rs.getLong(1);
				System.out.println("자동생성된 key 값 = " + genKey);
			}
			
			// 밑에서 또 사용해야 하므로 클로즈 해주기 
			
			rs.close();
			pstmt.close();
			// SELECT -> executeQuery()
			System.out.println();
			System.out.println("SELECT");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL + " ORDER BY " + COL_LABEL_NO + " DESC");
			
			
			// SQL 전송/실행
			rs = pstmt.executeQuery();
						
			while (rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + " | " + name + " | " + birthdate);
			} // end while
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// SQL 에러 메세지는 SQLException 에서 확인가능
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end try-catch

	} // end main()

} // end class DB03Main






















