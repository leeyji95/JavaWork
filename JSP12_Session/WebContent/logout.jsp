<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 여기에 세션 삭제 -->
    
    
       <%
    String sessionName = "userid";
    
    // 세션삭제
    session.removeAttribute(sessionName);
    %>
   <script>
alert("로그 아웃 되었습니다");
location.href = "login.jsp"
</script>