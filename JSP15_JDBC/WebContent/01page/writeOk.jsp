<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <!-- JDBC 관련 import -->

<%
	request.setCharacterEncoding("utf-8"); // 한글 인코딩 꼭! (post 방식에서!)
	// 입력한 값 받아오기
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// 유효성 체크, 
	// name 과 subject 는 비어있으면 안된다. NotNull 설정해주었으니까
	// null 이거나 빈 문자열이면 이전화면으로 돌아가기 해야한다. 
	if(name == null || subject == null || 
		name.trim().equals("") || subject.trim().equals("")){
%>
	<script>
	 alert("작성자 이름, 글제목은 필수입니다!");
	 history.back();  // 작성자가 작성하고 있던 페이지 그대로 돌아감.   history.go(-1);  이렇게 해도 된다.
	</script>	

<%
		return;  //  ★  더 이상 JSP 프로세싱 하지 않도록 종료 ! ★★
		/* 
		JSP에서 return 넣은 거 처음!   
		자, 여기서 검증실패하면 → JDBC 더이상 진행되면 안돼! 그러므로
		return; 때려서  history 하고 서버 종료됨.
		*/
	}	
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
	String userid = "scott0316";
	String userpw = "tiger0316";
%>

<%!  
	// 쿼리문 준비
	String sql_insert = "INSERT INTO test_write " + 
		"(wr_uid, wr_subject, wr_content, wr_name) " + 
		"VALUES(test_write_seq.nextval, ?, ?, ?)"
		;
%>


<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" + "<br>"); //  테스트 출력
		conn = DriverManager.getConnection(url, userid, userpw);
		out.println("conn 성공" + "<br>"); // 테스트 출력
		
		//트랜잭션 실행   : 트랜잭션이란, 데이터 조작 동작 단위이다. (여러개의 쿼리 수행될 수도 있음)
		pstmt = conn.prepareStatement(sql_insert);
		
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		cnt = pstmt.executeUpdate();   // 정상적으로 수행되면 1 리턴
		
	} catch(Exception e){
		e.printStackTrace();
		//throw e ;  // <-- 처리 시, 500페이지 볼 수 있음. 개발과정에서 에러 찾고 싶으면 이렇게 throw 로 던져라 
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


<% if(cnt == 0){ %>
	<script>
		alert("등록 실패!!!!!!");
		history.back(); // 브라우저가 기억하는 이전 페이지로
	</script>
<% } else { %>
	<script>
		alert("등록 성공. 리스트 출력합니다");
		location.href = "list.jsp"; // 리스트 페이지로 이동!
	</script>			
<% } %>







