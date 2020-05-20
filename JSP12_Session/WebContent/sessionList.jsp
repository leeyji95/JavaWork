<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Session List</title>
</head>
<body>
	<%
		if (request.isRequestedSessionIdValid()) {
			out.println("유효한 세션이 있어요 O <hr>");
		} else {
			out.println("유효한 세션이 없어요 X");
		}
		String sessionName, sessionValue;

		// 현재 세셔느이 모든 name 들 가져오기 
		Enumeration<String> enumeration = session.getAttributeNames(); //  Enumeration<String> 리턴

		int i = 0;
		while (enumeration.hasMoreElements()) {

			sessionName = enumeration.nextElement();
			// session.getAttribute(sessionName) <--  특정 name 의 세션값 추출, name 없으면 null 리턴!
			sessionValue = session.getAttribute(sessionName).toString();
			out.println((i + 1) + "] " + sessionName + " : " + sessionValue + "<br>");

			i++;
		} // end while

		// while 문을 다 돌고 나왔다는 건 ->  세션 테이블은 존재하나, 그 안에 어떠한 네임 도 없다는 뜻이다! 
		if (i == 0) {
			out.println("세션에 name-value 가 없네요..<br>");
		}
	%>
	<hr>
	<form action="sessionCreate.jsp">
		<input type="submit" value="세션생성">
	</form>

	<br>

	<form action="sessionDelete.jsp">
		<input type="submit" value="세션삭제">
	</form>

	<hr>
	<%
		String sessionId = session.getId(); // 세션의 고유 아이디값 확인
		int sessionInterval = session.getMaxInactiveInterval(); // 세션의 유효시간 확인 

		out.println("세션 ID: " + sessionId + "<br>");
		out.println("세션 유효시간: " + sessionInterval + "<br>");
	%>


<%

// 특별한 경우만  사용함!
out.println("---------session.invalidate() 후--------<br>");
// 세션 무효화 invalidate
// 기존 세션테이블 삭제(session id 무효화)
//  - 그 안의 모든 attribute(이름) 도 삭제됨.
// 새로운 세션 테이블 생성

// session.invalidate();  

sessionId = session.getId(); // 기존의 것을 지우고 다시 생성하는 것이므로 Id 있어유!
sessionInterval = session.getMaxInactiveInterval();

out.println("세션 ID: " + sessionId + "<br>");
out.println("세션 유효시간: " + sessionInterval + "<br>");	
// '새로고침 하면서'  어떻게 바뀌는지 보자


%>
</body>
</html>