<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO" />
<!-- DAO bean 생성 -->


<% // Controller 로부터 결과 데이터 받음. 
	//dao 사용한 트랜잭션
	WriteDTO arr[] = (WriteDTO [])request.getAttribute("list");  // <--- list 라는 이름으로 담은 request 결과들을 배열타입으로 형변환하여 받아온다.
%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>


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
		<%
			if (arr != null) {
				for (int i = 0; i < arr.length; i++) {
		%>
		<tr>
			<td><%=arr[i].getUid()%></td>
			<td><a href="view.do?uid=<%=arr[i].getUid()%>"><%=arr[i].getSubject()%></a></td>
			<td><%=arr[i].getName()%></td>
			<td><%=arr[i].getViewCnt()%></td>
			<td><%=arr[i].getRegDate()%></td>
		</tr>
		<%
			} // end for
			} // end if
		%>

	</table>
	<br>
	<button onclick="location.href='write.do'">신규등록</button>
</body>
</html>















