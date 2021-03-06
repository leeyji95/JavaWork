<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글작성</title>
</head>


<!-- 프론트 단에서 검증해야하고, writeOk 벡앤드 단에서도 검증해야 한다! -->
<script type="text/javascript">
	function chkSubmit() {
		frm = document.forms["frm"];
		
		// 얘네는 필수였음
		var name = frm.name.value.trim();
		var subject = frm.subject.value.trim();
		
		if(name == ""){
			alert("작성자 란은 반드시 입력해야 합니다.");
			frm.name.focus();
			return false;
		} 
		if(subject == ""){
			alert("제목은 반드시 입력해야 합니다.");
			frm.subject.focus();
			return false;
		}
		return true;
	}
	
</script>

<body>
<h2>글작성</h2>
<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
<form name="frm" action="writeOk" method="post" onsubmit="return chkSubmit()">

<%-- int 매개변수 받는 setter 도 동작할까? --%>
uid : 
<input type="text" name="uid" value="123"/><br>
작성자:
<input type="text" name="name" value="엣지"/><br>
제목:
<input type="text" name="subject" value="바람과 함께 후다닥"/><br>
내용:<br>
<textarea name="content">오늘 점심은 어디서...</textarea>
<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.jsp'">목록으로</button>
</body>

</html>