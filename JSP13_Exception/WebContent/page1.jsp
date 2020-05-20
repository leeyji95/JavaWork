<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- page 지시사 태그를 사용한 예외처리 -->
    <%@ page errorPage="error.jsp" %>  <!-- -> 404 페이지 뜸. 왜? error.jsp 페이지가 없거든 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

<%= request.getParameter("id").toUpperCase() %>


</body>
</html>