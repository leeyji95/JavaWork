<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>subParam</title>  <!-- 역할 id, pw 받아서 뿌려줌 -->
</head>
<body>
<%! String id, pw; %>  <!--  요청받은 jsp 파일에서 넘어온 파라메타 담아줄 변수 선언-->
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
%>
<p> 현재 페이지는 subParam 입니다.. </p>
아이디 : <%= id %><br>
비밀번호 : <%= pw %><br>

<!-- 내부적으로 request 발생
  
  id, pw 받아서 뿌려줌-->
</body>
</html>
