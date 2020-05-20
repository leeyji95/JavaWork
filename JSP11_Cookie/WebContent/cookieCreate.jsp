<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieName1 = "num1";
	String cookieValue1 = "" + (int)(Math.random() * 10);
	Cookie cookie1 = new Cookie(cookieName1, cookieValue1); // 쿠키 객체 생성헀어요. 이름-값 으로 쿠키를 생성합니다
	cookie1.setMaxAge(2 * 30) ; // 쿠키 파기시간(expiry) 시간 설정(생성시점으로부터 2 * 30 초 후)
	response.addCookie(cookie1); // response 에 쿠키정보 추가. 생성된 쿠키는 response에 담겨서 클라이언트에 보내진다
	
	// 쿠키는 얼마든지 생성 가능
	String cookieName2 = "datetime";
	String cookieValue2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
	cookie2.setMaxAge(30);
	response.addCookie(cookie2); 
%>

<script>
alert("<%= cookieName1%> 쿠키생성");
location.href = "cookieList.jsp";
</script>