<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.lec.beans.WriteDTO" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL request</title>
</head>
<body>


<%
	request.setAttribute("myage", 30);
	request.setAttribute("mydto", new WriteDTO(100, "제목", "내용", "작성자", 3));
	pageContext.setAttribute("myage", "흥!!");
%>

${myage }<br>  <%-- 이와같이 스코프 명시 되어 있지 않은 경우, 우선순위 스코프에 의해 출력된다. --%>
${requestScope.myage }<br> <%-- 정확히 request 스코프에 대한 myage 를 뽑고 싶다면 이렇게 해라. --%>
<%--request 스코프에 유효한 값을 넣는다. --%>
${mydto }<br>  <!-- toString() 값이 나온다. WriteDTO 에 명시한 -->

${mydto.uid }<br> 
<%= ((WriteDTO)request.getAttribute("mydto")).getUid() %>
${mydto.subject }<br> 
${mydto.content }<br> 


</body>
</html>