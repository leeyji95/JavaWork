<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="session"/>

<h3>session2<b>  cnt 의 getCount 호출</b></h3>

<jsp:getProperty name="cnt" property="count"/><br>

<a href="scope3_session1.jsp">session1 으로... </a>
