<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>
<jsp:setProperty name="cnt" property="count"/>
<!--  cnt.serCount(Integer.parseInt(request.getParameter("count")))   :  내부적으로 이렇게 동작할 것이다.   -->

<h3>page1<br>cnt와 getCount 호출</h3>

<jsp:getProperty name="cnt" property="count"/><br>
<!-- cnt.getCount() 호출함 내부적으로. -->

<a href="scope1_page2.jsp">page2로 이동</a>
