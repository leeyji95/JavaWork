<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글작성</title>

<style>
h2{

}

</style>

</head>

<script>

function chkSubmit() {
	frm = document.forms.frm;
	
	var name = frm.name.value.trim();
	var title = frm.title.value.trim();
	
	if(name == ""){
		alert("닉네임을 적으셔야 해유...");
		frm.name.focus();
		return false;
	}
	if(title == ""){
		alert("제목 반드시 입력해야합니다.");
		frm.title.focus();
		return false;
	}
	return true;
}

</script>

<body>
<h2>글작성</h2>
<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
<form name="frm" action="pr_writeOk.jsp" method="post" onsubmit="return chkSubmit()">

<span>작성자: </span><input type="text" name="name"/><br><br>
<span>제목: </span><input type="text" name="title"/><br><br>
<span>내용:</span><br>
<textarea name="content"></textarea>
<br><br>
<input type="submit" value="글 등록"/>

</form>

<br>
<button type="button" onclick="location.href='pr_list.jsp'">목록</button>
</body>
</html>