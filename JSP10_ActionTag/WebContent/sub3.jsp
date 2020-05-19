<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  /* parameter 파라메터 만들어줌  */
	String name = URLDecoder.decode(request.getParameter("name"), "utf-8");  // decode 로 받아야한다
	String age = request.getParameter("age");

%>
   
   이름: <%= name %> <br>
   나이: <%= age  %> <br>