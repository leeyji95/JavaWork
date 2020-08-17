<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form method="post" action="${pageContext.request.contextPath}/user/auth">
		<div>
			<label class="control-label">Email Auth</label><br>
			<!-- 이메일 입력 -->
			<label for="user_email">이메일 : </label>
			<input type="email" id="user_email" name="user_email" placeholder="이메일을 입력하세요" />
			<!-- submit -->
			<button type="submit">인증하기</button>
		</div>
	</form>
</body>
</html>
