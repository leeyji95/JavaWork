<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.lec.beans.*"%> 여기선 필요 없음--%> 


<%

int uid = Integer.parseInt(request.getParameter("uid"));
// 이단계에서 parameter 검증 필요
%>

<%
	// DAO 사용한 트랜잭션
	int cnt = (int)request.getAttribute("updateOk");
%>



<% if(cnt == 0){ %>
<script>
alert("수정실패... ㅠㅠ");
history.back();
</script>
<% } else { %>

<script>
alert("수정성공!");
location.href="view.do?uid=<%= uid %>";
</script>

<% }  %>




