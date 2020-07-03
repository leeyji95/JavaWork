<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="com.lec.beans.*"%> --%> <!-- JSTL 버젼으로 바뀌니, import 의 번잡함도 사라지며 , JAVA 변수 선언도 사라진다.  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%--
날려버리쟈 
	// Controller 로부터 결과 데이터 받음. 
	//dao 사용한 트랜잭션
	WriteDTO arr[] = (WriteDTO[]) request.getAttribute("list"); // <--- list 라는 이름으로 담은 request 결과들을 배열타입으로 형변환하여 받아온다.
--%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table { width: 100%;}
table, th, td {
	border: 1px solid orange;
	border-collapse: collapse;
	text-align: center;
}
th{
	background-color: lightpink;
}
a{
	text-decoration: none;
	color: black;
}
a:hover{
	color: olive;
}
</style>
</head>
<body>

	<button onclick="location.href='write.do'">신규등록</button>
	<br>	<br>

	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<%--
			if (arr != null) {
				for (int i = 0; i < arr.length; i++) {
		--%>
		
		
		<c:choose>
			<c:when test="${empty list || fn:length(list) == 0}">  list 라는 이름으로 요청 받은 결과들의 배열이 있는가, 혹은 fn 사용해서, length 값으로 없으면
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.uid}</td>
					<td><a href="view.do?uid=${dto.uid}">${dto.subject}</a></td>
					<td>${dto.name}</td>
					<td>${dto.viewCnt}</td>
					<td>${dto.regDate}</td>
				</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		
		
		<%--
			} // end for
		} // end if
		--%>

	</table>
</body>
</html>















