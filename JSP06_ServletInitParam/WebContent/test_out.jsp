<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>out</title>
</head>
<body>
<%-- 
<% 
	int i = 0 ;
	while(true){
		i++;
		out.println("5 * " + i + " = " + 5 * i  + "<br>");  // out 은 내장 인스턴스 이다. 이미 많들어진 객체, out 스트림에 꽂아 넣어줌 -> html 문서에 보여진다 
		// html 에 바로 쓰기 위해 out 객체 사용한다. 
%>
 -------<br> <!--  이렇게  순환문, 조건문 사이에 html 문법 삽입 가능하다... --> 

<%
		if(i >= 9) break;
	}
%>
 --%>
 <%!
 	// 선언부 태그 : 변수 선언, 메소드 정의
 	int i = 100;
 	String str = "test";
 	
 	public int hap(int a, int b ){
 		return a + b;
 	}
 %>
 
 <% // 스크립트릿 : 자바코드
 	out.println("i = " + i + "<br>");
 	out.println("str = " + str + "<br>");
 	out.println("hap = " + hap(2, 10));
 	
 %>

<hr>
<!-- 익스프레션으로 표현 -->
i = <%= i  %><br>
str = <%= str %><br>
hap = <%= hap(2,10) %><br>

</body>
</html>