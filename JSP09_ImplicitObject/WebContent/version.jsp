<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>version</title>
</head>
<body>
<h3>버젼확인</h3>
<!--  JSP 에서 내가 만들지 않았는데 쓸 수 있는 애들은 내장객체라고 보면 된다.   -->
 - 서버 : <%=application.getServerInfo() %> <br>
 - 서블릿 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
 - JSP : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
</body>
</html>

