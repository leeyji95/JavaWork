<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>include</title>
</head>
<body>
<!-- Action Tag -->
	<h3>지금의 페이지는 include 페이지 입니다. </h3>
	<jsp:include page="sub.jsp"/>  
	<p>위 라인의 내용은 sub 페이지의 내용입니다. </p>   <!-- response 한 내용자체가 그대로 들어감 -->
	
<hr>
<!-- Directive  -->	
	<h3>지금의 페이지는 include 페이지 입니다. </h3>  <!-- 컴파일 되기 전에 합쳐지므로 -->
	<%@ include file = "sub.jsp" %>  <!-- 단독태그로 이렇게 들어가도 똑같이 보인다. -->
	<p>위 라인의 내용은 sub 페이지의 내용입니다. </p>
	
<hr>
<%!
	// 변수 선언
	String name = "홍길동";
	int age = 33;
%>
<%@ include file="sub2.jsp" %>

<!-- 아래와 같이 액션태그 이용해서  파라미터를  건내줄 수 있다!! -->
<jsp:include page = "sub3.jsp">
	<jsp:param value='<%= URLEncoder.encode(name,"utf-8") %>' name="name"/> 
	<jsp:param value="<%= age %>" name="age"/>
</jsp:include>
<!-- encode 하여 sub3로 파라메타 넘겨주고 -->
</body>
</html>