<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 여기에 세션 생성과 동시에 네임 밸류 부여 -->
<%! 
	// 아이디랑 비번이 이거이면 로그인 성공이라는 데이터 값.(아직DB에 대해 자세히 안배움)
	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
%>
<%
String userid = request.getParameter("userid");
String pw = request.getParameter("pw");


String sessionName1 = "userid";
String sessionValue1 =  userid;

//세션 생성

if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
	out.println("<script>");
	out.println("alert('로그인 성공');");
	out.println("</script>");
	
	
	session.setAttribute(sessionName1, sessionValue1);
	
}else{
	out.println("<script>");
	out.println("alert('로그인 실패');");
	out.println("</script>");
	
	
	// 쿠키 지우기(기존에 있었더라도 삭제하겠다)
	session.removeAttribute(sessionName1);
}
%>

<script>
	location.href = "login.jsp";
</script>