<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="ko">
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img alt="" src="<%= request.getContextPath() %>/myRes/img/apple.png"><br>
<!-- No mapping found for HTTP request with URI [/sts09_mvc/myRes/img/apple.png] in DispatcherServlet with name 'appServlet' -->
<!-- 이 경로 못찾았다는 에러. request 처리 하지 못한 것 -->
<!-- dispatcher 예외처리해주어야 함. 0-> servlet-context.xml 에 있다.  -->


<img alt="" src="/sts09_mvc/resources/img/apple.png"><br>
<img alt="" src="<%= request.getContextPath() %>/resources/img/apple.png"><br>
<img alt="" src="${pageContext.request.contextPath }/resources/img/apple.png"><br>
</body>
</html>
