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
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()"
	enctype="Multipart/form-data">
작성자:
<input type="text" name="name"/><br>
제목:
<input type="text" name="subject"/><br>
내용:<br>
<textarea name="content"></textarea>
<br><br>

<!-- 첨부파일 등록 -->
<div style="padding: 2px 10px; margin-bottom: 5px; border: 1px solid black;">
	<h4>첨부파일</h4>
	<button type="button" id="btnAdd">추가</button>
	<div id='files'></div>
	
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var i = 0;
$("#btnAdd").click(function(){
	$("#files").append("<div><input type='file' name='upfile" + i + "'/><button type='button' onclick='$(this).parent().remove()'>삭제</button></div>");  // id 가 file 인 div 안에다가 태그 추가 한다. <- append()
	i++;
});
// 삭제 시, button (니) 기준으로 부모 div 도 같이 삭제해야한다. 
// upfile

</script>


<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.do'">목록으로</button>
</body>













</html>