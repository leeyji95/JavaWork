<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${result == 0 }">  <!-- request 에 담겨온 result 를 의미(request.getAttribute("result") -->
		<script>
			alert("등록 실패!!!!!!");
			history.back(); // 브라우저가 기억하는 직전 페이지(입력중 페이지로)
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("등록 성공, 리스트를 출력합니다");
			location.href = "list.do";
		</script>
	</c:otherwise>
</c:choose>

<!-- // 태그로만 구성되어 있고, 직관적이다. -->











































