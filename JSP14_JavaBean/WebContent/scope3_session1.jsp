<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="session"/>
<jsp:setProperty name="cnt" property="count"/>
<!--  cnt.serCount(Integer.parseInt(request.getParameter("count")))   :  내부적으로 이렇게 동작할 것이다.   -->

<h3>session1<br>cnt와 getCount 호출</h3>

<jsp:getProperty name="cnt" property="count"/><br>
<!-- cnt.getCount() 호출함 내부적으로. -->

<a href="scope3_session2.jsp">session2로 이동</a>

<%-- <jsp:forward page="scope3_session2.jsp"></jsp:forward> --%>
