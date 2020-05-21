<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <!-- JDBC 관련 import -->
<%@ page import ="java.text.*" %>



<%
	int curPage = 1;  // 현재 페이지(디폴트 1 page)
	
	// 현재 몇 페이지인지 parameter 받아오기
	String pageParam = request.getParameter("page");  //page 라는 이름의 파라미터 받아야함.
	if(pageParam != null && !pageParam.trim().equals("")){  // page 라는 이름이 있는지 없는지, 공백인지, 
		try{
			int p = Integer.parseInt(pageParam); // 정수 인지
			if(p > 0) curPage = p;  // 정수라면 0보다 큰지   // 모두모두 의 검증을 통과한 후 보여지는 ㄱpage 값 
		} catch(NumberFormatException e){
			// 이상한 값 들어오면 무조건  1 페이지 보여 주면 됨
		}
		
	}// end if
%>




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
// 	final String SQL_WRITE_SELECT =
// 		"SELECT * FROM test_write ORDER BY wr_uid DESC";

	// 페이징
	// 글 목록 전체 개수 가져오기 
	final String SQL_WRITE_COUNT_ALL = "SELECT count(*) FROM test_write";
	
	// 몇번째 글에서 몇 개의 글을 가져오는 가 -> 이게  fromRow 부터  pageRows 만큼 SELECT 하도록 (몇번쨰부터 몇개냐 의 의미)
	// (몇 번째) 부터 (몇 개)만큼 인가
	final String SQL_WRITE_FROM_ROW = "SELECT * FROM " + 
			"(SELECT ROWNUM AS RNUM, T.* FROM (SELECT * FROM test_write ORDER BY wr_uid DESC) T) " + 
			"WHERE RNUM >= ? AND RNUM < ?";
	

	// 페이징 관련 세팅 값들
	int writePages = 10;    // 한 [페이징] 에 몇개의 '페이지'를 표현할 것인가?
	int pageRows = 8;   // 한 '페이지'에 몇개의 글을 리스트 할것인가? 
	int totalPage = 0; //총 몇 '페이지' 분량인가? 



%>
<!-- while문으로 돌린 rs의 결과가 테이블 안에 들어올 수 있도록.. -> html 짜르자 -->

<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공<br>"); //  테스트 출력
		conn = DriverManager.getConnection(url, uid, upw);
		out.println("conn 성공" + "<br>"); // 테스트 출력
		
		//트랜잭션 실행   : 트랜잭션이란, 데이터 조작 동작 단위이다. (여러개의 쿼리 수행될 수도 있음)
		pstmt = conn.prepareStatement(SQL_WRITE_COUNT_ALL);
		rs = pstmt.executeQuery();  // 쿼리문 수행! 
		
		if(rs.next())
			cnt = rs.getInt(1);  // count(*) 값이다.  얘는 1개 밖에 없다. 
		
			rs.close();
			pstmt.close();
		
			totalPage = (int)Math.ceil(cnt / (double)pageRows); // 총 몇 페이지인지 계산 
			
			int fromRow = (curPage - 1) * pageRows + 1; // 몊 번째 row 부터? 
			
			pstmt = conn.prepareStatement(SQL_WRITE_FROM_ROW);
			pstmt.setInt(1, fromRow);    // 몇번째 row 부터
			pstmt.setInt(2, fromRow + pageRows);  // 몇번째 row 전까지?
			rs = pstmt.executeQuery();	

			
// 		out.println("excuteQuery() 성공적으로  수행되어 -> 쿼리 성공함! <br>");
%>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록 <%= curPage %> 페이지</title>
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

<!-- 페이징  -->
<link rel="stylesheet" type="text/css" href="CSS/common.css"/>
<script src="https://kit.fontawesome.com/bb29575d31.js"></script>


</head>
<body>
	<hr>
	<h2>리스트 <%= curPage %></h2>		
	<h4><%= cnt %>개</h4> <!-- 전체 글 개수 -->
	<table>
		<tr>
			<th>row</th> <!-- row(줄) 번호  -->
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
	
		
<%
 while(rs.next()){
	 out.println("<tr>");
	 
	 int rnum = rs.getInt("rnum");  // rownum 받아오기 
	 
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
	 
		out.println("<td>" + rnum + "</td>"); // rownum 찍어주기 
		out.println("<td>" + uid + "</td>");
		out.println("<td><a href='view.jsp?uid=" + uid + "&page=" +curPage + " '>" + subject + "</a></td>");
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

<%--페이징 --%><!--  -->
<jsp:include page="pagination.jsp">
	<jsp:param value="<%= writePages %>" name="writePages"/>
	<jsp:param value="<%= totalPage %>" name="totalPage"/>
	<jsp:param value="<%= curPage %>" name="curPage"/>
</jsp:include>





</body>
</html>