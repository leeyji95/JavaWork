<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!int age;%>
<%
	String str = request.getParameter("age");
	age = Integer.parseInt(str);
	
	if(age >= 19){
		response.sendRedirect("adult.jsp?age=" + age);  
		// audlt jsp 페이지로 response 를 전달해줌.   
		// 페이지가  서버  내부적으로 재요청됨.
		// age 값까지  adult 페이지로 넘기고 싶다면 -> 쿼리 string 만들어 주어라 
		// 파라메타값으로 쿼리문이 url에 같이 보여짐 
		// 다른 url로 변경되어 재요청 들어감.
	}else{
		response.sendRedirect("underage.jsp?age=" + age);
	}
	
%>