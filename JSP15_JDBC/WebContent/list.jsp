<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <!-- JDBC 관련 import -->
<%@ page import ="java.text.*" %>
<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과
	int cnt = 0;  // DML 결과 executeUpdate()
	
	// Connection 에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott0316";
	String upw = "tiger0316";
%>
<%!  
	// 쿼리문 준비
	final String SQL_WRITE_SELECT =
		"SELECT * FROM test_write ORDER BY wr_uid DESC";
%>
<!-- while문으로 돌린 rs의 결과가 테이블 안에 들어올 수 있도록.. -> html 짜르자 -->
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style type="text/css">
table{width: 100%;}
table, th, td{
	border: 1px solid lightcoral;
	border-collapse: collapse;
	text-align: center;

}
a{
	text-decoration: none;
	color: black;
}
a:hover{
	color: lightblue;
}
</style>
</head>
<body>


<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" + "<br>"); //  테스트 출력
		conn = DriverManager.getConnection(url, uid, upw);
		out.println("conn 성공" + "<br>"); // 테스트 출력
		
		//트랜잭션 실행   : 트랜잭션이란, 데이터 조작 동작 단위이다. (여러개의 쿼리 수행될 수도 있음)
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT);
		
		rs = pstmt.executeQuery();  // 쿼리문 수행! 
		out.println("excuteQuery() 성공적으로  수행되어 -> 쿼리 성공함! <br>");
%>

	<hr>
	<h2>리스트</h2>		
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		
<%
 while(rs.next()){
	 out.println("<tr>");
	 int uid = rs.getInt("wr_uid");
	 String subject = rs.getNString("wr_subject");
	 String name = rs.getString("wr_name");
	 int viewcnt = rs.getInt("wr_viewcnt");
	 
	 Date d = rs.getDate("wr_regdate");
	 Time t = rs.getTime("wr_regdate");
	 
	 String regdate = "";
	 if(d != null){
		 regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
				 + new SimpleDateFormat("hh:mm:ss").format(t);
	 }
	 
		out.println("<td>" + uid + "</td>");
		out.println("<td><a href='view.jsp?uid=" + uid + " '>" + subject + "</a></td>");
		out.println("<td>" + name + "</td>");
		out.println("<td>" + viewcnt + "</td>");
		out.println("<td>" + regdate + "</td>");	
	 
	 
	 out.println("/<tr>");
 } // end while

%>		

		
	</table>
	<br>
	<button onclick="location.href='write.jsp'">신규 글 등록</button>	
		
		
<%
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


</body>
</html>