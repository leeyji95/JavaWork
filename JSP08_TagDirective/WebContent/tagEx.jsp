<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

<%
	int sum = 0;
	for(int cnt = 1; cnt <= 100; cnt++){
		sum += cnt;
	}	
%>
1부터 100 까지의 합은 : <%= sum %> 

<hr>
<h3>오늘의 식단</h3>
	-비빔밥<br>
	-개구리밥<br>
	-스폰지밥<br>
	<%@ include file = "test.jsp" %>
	<!-- 이 내용 그대로가 들어간다. 현재 페이지에  -->
</body>
</html>