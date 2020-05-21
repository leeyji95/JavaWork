<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <!-- JDBC 관련 import -->

<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과
	int cnt = 0;  // DML 결과 executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>

<%!  
	// 쿼리문 준비
	// ex)
%>


<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>"); //  테스트 출력
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>"); // 테스트 출력
		
		//트랜잭션 실행   : 트랜잭션이란, 데이터 조작 동작 단위이다. (여러개의 쿼리 수행될 수도 있음)
		//
	} catch(Exception e){
		e.printStackTrace();
		// 예외처리
	} finally{
		//리소스 해제
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} 

%>









