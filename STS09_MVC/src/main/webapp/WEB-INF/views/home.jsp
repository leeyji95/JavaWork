<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img alt="picture" src="${pageContext.request.contextPath}/myRes/img/img_5terre.jpg">

<img alt="picture" src="${pageContext.request.contextPath}/resources/img/img_5terre.jpg">
<img alt="picture" src="<%= request.getContextPath() %>/resources/img/img_5terre.jpg">
</body>
</html>
