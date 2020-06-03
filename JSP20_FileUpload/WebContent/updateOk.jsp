<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:choose>
 	<c:when test="${updateOk == 0 }">
		<script>
			alert("수정실패... ㅠㅠ");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정성공!");
			location.href="view.do?uid=${uid}";  // 멀티파트 request 에 담겨 넘어온  uid 값 넣어줌.  
		</script>
	</c:otherwise>
</c:choose>