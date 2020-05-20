<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login 페이지</title>
</head>
<body>
<%
	int i = 0;
%>
	
<%
	Cookie[] cookies = request.getCookies();	// Cookie[] 배열
	String cookieName  = "userid";  // 로그인 성공하면 발급되는 쿠키 이름. (userid 라는 이름의 쿠키생성할 것 )
	
	// 일단 이 이름의 쿠키가 있는지 없는지 확인부터 해야함
	if(cookies != null){
		for(i = 0; i < cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){ // 쿠키 생성 이름이랑 이미 존재하는 쿠키 이름 같다면(이미 존재하는지 확인용도)
				break;
			} // end if
				
		} // end for
	} // end if
	
	
	/* 이 for문 다 돌았다면 -> 동일한 쿠키 이름 없다는 뜻힘 => 로그인 해야한다 */
%>
<!-- html 과하다 싶을 때 이러헤 끊어서 사용.  -->
<% if(cookies == null || i == cookies.length){ %>
		<h2>로그인 상태가 아닙니다.</h2>
		<form action="loginOk.jsp">
			id:<input type="text" name="userid"><br>
			pw:<input type="password" name="pw"><br>
	   <input type="submit" value="로그인"><br>
		</form>
<%	} else{ %>
		<h2>로그인 상태 입니다!!.</h2>
			<form action="logout.jsp">
			<input type="submit" value="로그아웃"><br>
		</form>
		
		
<%	} %>



</body>
</html>