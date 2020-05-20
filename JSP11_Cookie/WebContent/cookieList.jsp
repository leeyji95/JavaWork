<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>cookie 리스트</title>
</head>
<body>
<%
	// 사용자 컴퓨터 안의 쿠기 정보는 request 시에 서버로 전달된다. 
	// request 객체의 getCookies() 로 받아온다.  -> Cookie의 [] 배열을 리턴한다는 사실에 주목!
	Cookie[] cookies = request.getCookies(); // Cookie[] 배열 리턴  
	
	if(cookies != null){ // 만약 쿠키가 하나도 없다면 null리턴
		for(int i = 0; i < cookies.length; i++){
			String cookieName = cookies[i].getName(); // 쿠키 '이름'
			String cookieValue = cookies[i].getValue(); // 쿠키 '값'
			out.println((i+1) +"] " + cookieName + " : "  + cookieValue + "<br>");
		}
	}else{
		out.println("쿠키가 없습니다<br>");
	}
%>
<hr>
<form action="cookieCreate.jsp">
	<input type="submit" value="쿠키생성&갱신">
</form>
<br>
<form action="cookieDelete.jsp">
	<input type="submit" value="쿠키 삭제">
</form>
</body>
</html>