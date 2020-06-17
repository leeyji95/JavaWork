<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/common.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/category.js"></script>
<title>다단계 카테고리 - SELECT 하기</title>
</head>
<body>
	<div class="cate" id="mycate">
		<span>
			<select disabled id="depth1"></select>
		</span>
		<span>
			<select disabled id="depth2"></select>
		</span>
		<span>
			<select disabled id="depth3"></select>
		</span>
		
	</div>

</body>
</html>