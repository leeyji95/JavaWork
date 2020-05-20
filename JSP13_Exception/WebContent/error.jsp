<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %> <!-- 이 페이지는 에러 핸들링을 위한 페이지임을 명시해줌. !! -->
    <% response.setStatus(200); %>  <!-- 이 페이지의 response 코드를 200 으로 정상화 시킨다. 그래야 내가 만든 페이지가 나옴 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러 안내</title>
</head>
<body>
	에러가 발생했습니다... <br>
	예외 타입은 : <%= exception.getClass().getName() %><br>
	예외 메시지는 : <%= exception.getMessage() %>
</body>
</html>