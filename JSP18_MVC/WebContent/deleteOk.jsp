<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
// 파라메타 받아오기 
int uid = Integer.parseInt(request.getParameter("uid"));
%>

<%
	// DAO 사용한 트랜잭션
	int cnt = (Integer)request.getAttribute("delete");
%>


<% if(cnt == 0){ %>
<script>
alert("삭제실패... ㅠㅠ");
history.back();
</script>
<% } else { %>

<script>
alert("삭제성공!");
location.href="list.do";
</script>

<% }  %>




