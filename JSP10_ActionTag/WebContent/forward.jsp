<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>forward</title>
</head>
<body>
	<!-- Action Tag -->
	<h3>지금의 페이지는 forward 페이지 입니다. </h3>
	<jsp:forward page="sub.jsp"/> <!-- 서버쪽에서 처리되는 특별한 태그임. html에서 처리됨 -->
	<p>위 라인의 내용은 sub 페이지의 내용입니다. </p>
	<!-- 리다이는 url이 완전히 새로운 걸
	컨테이너ㅓ 내에서 처리되어  나온 결과이다.  포워드는 변경되지 않음  -
	초최    최초 url만 유지될 뿐, 타이틀 제목과 페이지는 sub 페이지 이다-->
	
	
</body>
</html>
