<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글작성</title>
<script src="sckeditor/ckeditor.js"></script>
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
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
작성자:
<input type="text" name="name"/><br>
제목:
<input type="text" name="subject"/><br>
내용:<br>
<textarea name="content" id="editor1"></textarea>
<script type="text/javascript">
   // editor1 엘리먼트를 찾아서 cheditor 로 변환해줌. 
   CKEDITOR.replace('editor1', {
		allowedContent: true,   // HTML 태그 자동삭제 방지 설정
		width: '640px',     // 최초 너비, 높이 지정 가능
		height: '400px',
		filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload.do'  //fileUpload.do 의 url 로 파일 없로드를 처리하겠다.우리가 url 만드는 것
	});
</script>
<br><br>
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.do'">목록으로</button>
</body>

</html>