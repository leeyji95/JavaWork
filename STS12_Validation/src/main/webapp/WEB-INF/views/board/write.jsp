<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<style>
span { color: red;}
</style>
</head>
<body>
<form action="writeOk.do">
uid(<span>숫자</span>): 
	<input type="text" name="uid" value="${w.uid }"></br> <!-- 에러발생하면 다시 원래 입력했던 값으로 보여주기 위해  -->
작성자(<span>*</span>): 
	<input type="text" name="name" value="${w.name }"></br>
제목(<span>*</span>):
	<input type="text" name="subject" value="${w.subject }"><br>

<input type="submit" value="등록"></br>
</form>
</body>
</html>

