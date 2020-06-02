<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="com.lec.beans.*"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%--
	//dao 사용한 트랜잭션
	WriteDTO[] arr = (WriteDTO[]) request.getAttribute("view");
--%>

<%--
	if (arr == null || arr.length == 0) {
--%>

<c:choose>

	<c:when test="${empty view || fn:length(view) == 0 }">


		<script>
		alert("해당 정보가 삭제되거나 없습니다");
		history.back();
	</script>
	</c:when>
	<c:otherwise>



		<%--
	return; // 더이상 JSP 프로세싱 하지 않고 종료
	} // end if
--%>

		<%--
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regDate = arr[0].getRegDate();
	int uid = arr[0].getUid();
	int viewCnt = arr[0].getViewCnt();
--%>

		<!DOCTYPE html>
		<html lang="ko">
<head>
<meta charset="UTF-8">
<title>읽기 ${view[0].subject}</title>
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
	<h2>읽기 ${view[0].subject}</h2>
	<br> uid : ${view[0].uid}
	<br> 작성자 : ${view[0].name}
	<br> 제목: ${view[0].subject}
	<br> 등록일: ${view[0].regDate}
	<br> 조회수: ${view[0].viewCnt}
	<br> 내용:
	<br>
	<hr>
	<div>${view[0].content}</div>
	<hr>
	
	
	<%-- 첨부파일 및 다운로드 링크  --%>
	<c:if test="${fn:length(file) > 0}"> <%--파일이라는 이름으로 넘어온 애가 (Viewcommand에서 넘어온 애) 비어있지 않아야함. --%>
	 	<h4>첨부파일</h4>
	 	<ul>
	 			<c:forEach var="element" items="${file }">
	 			<li><a href="download.do?uid=${element.uid}">${element.source }</a></li> <%-- 클릭 시 ->  url 여렇게 생성 .http://localhost:8082/JSP20_FileUpload/download.do?uid=1 --%>
	 			
	 		</c:forEach>
	 	</ul>
	</c:if>
	
	<%-- 이미지인 경우 보여주기  --%>
	<c:forEach var="element" items="${file }">
		<c:if test="${element.image == true }">
			<div style="width:300px;">
				<img style="width:100%; height:auto"
					src="upload/${element.file }"/>
					</div>
		</c:if>
	</c:forEach>
	
	
	
	
	
	
	<br>
	<button onclick="location.href='update.do?uid=${view[0].uid}'">수정하기</button>
	<button onclick="location.href='list.do'">목록보기</button>
	<button onclick="chkDelete(${view[0].uid})">삭제하기</button>
	<button onclick="location.href('write.do')">신규등록</button>
	</c:otherwise>
</c:choose>
</body>
</html>

