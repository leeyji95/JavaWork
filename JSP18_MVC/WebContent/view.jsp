<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*"%>

<%
	//dao 사용한 트랜잭션
	WriteDTO[] arr = (WriteDTO[]) request.getAttribute("view");
%>

<%
	if (arr == null || arr.length == 0) {
%>
<script>
		alert("해당 정보가 삭제되거나 없습니다");
		history.back();
	</script>
<%
	return; // 더이상 JSP 프로세싱 하지 않고 종료
	} // end if
%>

<%
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regDate = arr[0].getRegDate();
	int uid = arr[0].getUid();
	int viewCnt = arr[0].getViewCnt();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>읽기-<%=subject%></title>
</head>

<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm("삭제하시겠습니까?");
	
	if(r){
		location.href = 'deleteOk.do?uid=' + uid;
	}
} // end chkDelete()
</script>

<body>
	<h2>
		읽기
		<%=subject%></h2>
	<br> uid :
	<%=uid%><br> 작성자 :
	<%=name%><br> 제목:
	<%=subject%><br> 등록일:
	<%=regDate%><br> 조회수:
	<%=viewCnt%><br> 내용:
	<br>
	<hr>
	<div>
		<%=content%>
	</div>
	<hr>
	<br>
	<button onclick="location.href='update.do?uid=<%=uid%>'">수정하기</button>
	<button onclick="location.href='list.do'">목록보기</button>
	<button onclick="chkDelete(<%=uid%>)">삭제하기</button>
	<button onclick="location.href('write.do')">신규등록</button>

</body>
</html>

