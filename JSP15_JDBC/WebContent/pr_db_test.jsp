<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!-- JDBC 관련한 import 해주기 -->

<%!Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int cnt = 0;

	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";%>

<%!// 쿼리문 작성해주세용%>

<%
try{
	Class.forName(DRIVER) ;
	conn = DriverManager.getConnection(URL, USERID, USERPW);
	
	// 트랜잭션 실행하기 위한 코드 작성
	
	
	
} catch(Exception e){
	e.printStackTrace()	;
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
