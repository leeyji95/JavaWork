<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>어른 타이틀</title>
</head>
<body>
<%! int age; %>  <!-- 요청받은 age 값 담아줄 변수 선언 -->
<% 
	String str = request.getParameter("age");
	age = Integer.parseInt(str);
%>

당신은 <%= age %>세 입니다.
사이트 이용이 가능합니다. <br>
<a  href="04_1_input_age.html">처음으로</a>

</body>
</html>