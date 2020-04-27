package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.java.db.Query;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements Query {

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
					
			pstmt = conn.prepareStatement(SQL_INSERT);   // 프리페어 일때는 매개변수가 들어가야 함.     Statement 일때는 매개변수 없었음.
			//"INSERT INTO " + TBL_NAME + " VALUES(?, ?, ?)"  
			pstmt.setInt(1, 10);  // 첫번째 물음표에 10을 넣겠다.   첫번쨰 ? 는 1부터 시작!     // 숫자 넣어야 하는데, 문자열 넣으면? java.sql.SQLSyntaxErrorException: ORA-01722: invalid number
			pstmt.setString(2, "헐크");
			pstmt.setString(3, "2000-10-10");    // 물음표 하나 누락되면  java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 3
			int cnt  = pstmt.executeUpdate();  // DML 명령어 --> int 리턴
			System.out.println(cnt + "개 행(row) INSERT 성공");  
			
			
			System.out.println();
			System.out.println("UPDATE");
			pstmt.close();  // close  한 다음에  사용해야 함.
			pstmt = conn.prepareStatement(SQL_UPDATE_BIRTHDATE);
			// 여러개의 쿼리문 작동해야 한다고 할때, 예를 들어, Update, delelte, insert 해야한다면 -> 초반에 pre인스턴스 3개 만들어 놓고 하는게 좋음(실무에서)
			// "UPDATE test_member SET mb_birthdate = ? WHERE mb_no = ?"
			pstmt.setString(1,  "2020-01-01");
			pstmt.setInt(2, 10);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");  
		
				
			System.out.println();
			System.out.println("SELECT");
			pstmt.close();
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + " | " +  name + " | "  + birthdate);
			}
			
			
			
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} // end main()

} // end class DB03Main






















