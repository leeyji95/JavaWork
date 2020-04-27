package com.lec.java.db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 0. 라이브러리 추가
 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/
public class Prac {
	
	public static final String DRIVER = 
				"oracle.jdbc.driver.OracleDriver";
	public static final String URL =
				"jdbc:oracle:thin@localhost:1521:XE";
	
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";

	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		// 멤버변수 선언 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(DRIVER); // 드라이버 클래스를 메모리에 로드 시킴
			System.out.println("'드라이버 클래스 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 연결!");
			
			stmt = conn.createStatement(); //Connection 으로부터 Statement 인스턴스 만들어짐.
			System.out.println("Statement 생성 성공");
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		
		

	} // end main()

} // end class
