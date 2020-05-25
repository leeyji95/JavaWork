<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="com.lec.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL & Bean</title>
</head>
<body>
	<%
		Person chang = new Person();
		chang.setName("장윤성");
		chang.setAge(27);
	%>


	<c:set var="dto" value="<%=chang%>" />
	이름: ${dto.name }
	<br>
	<!-- 내부적으로 dtogetName() 호출  -->
	나이: ${dto.age }
	<br> dto: ${dto }
	<br>
	<!-- dto 객체 -> 주소값 출력   -->

	<hr>

	<%-- EL 은 bean 객체 의 내용을 읽어올수 있다 --%>
	<jsp:useBean id="p0" class="com.lec.beans.Person">
		<jsp:setProperty name="p0" property="name" value="홍성용" />
		<jsp:setProperty name="p0" property="age" value="28" />
	</jsp:useBean>

	이름: ${p0.name}
	<br> 나이: ${p0.age}
	<br> p0: ${p0}
	<br>



	<%
		Person p1 = new Person();
		p1.setName("고질라");
		p1.setAge(100);
		Person p2 = new Person();
		p2.setName("킹기도라");
		p2.setAge(200);
		Person p3 = new Person();
		p3.setName("모스라");
		p3.setAge(80);

		Person[] arr = { p1, p2, p3 };
	%>

	<c:set var="dtoArr" value="<%=arr%>" />
	<c:forEach var="p" items="${dtoArr }">
	${p.name }<br>
	${p.age }<br>
	${p }<br>
	</c:forEach>

	<%
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
	%>

	<hr>
	<br>

	<c:set var="dtoArr" value="<%=list%>" />
	<c:forEach var="p" items="${dtoArr}">
	${p.name }<br>
	${p.age }<br>
	${p }<br>
	</c:forEach>

	<hr>

	${dtoArr[0].name }
	<br>
	<%-- dtoArr 은 배열이 아니라 List 였다... --%>
	${dtoArr[1].name }
	<br> ${dtoArr[2].name }
	<br> ${dtoArr[3].name }
	<br>
	<!-- Exception 없이 넘어간다.. -->

	<hr>
	<%--  특정 id 의 bean 이 있는지 체크 : empty --%>
	<c:if test="${empty dto }">
		<!-- dto 가 비어있으면 참! -->
		dto 는 없습니다. <br>
	</c:if>

	<c:if test="${ not empty dto }">
		<!-- dto 가 있으면 참! -->
		dto 는 있습니다. <br>
	</c:if>


	<c:if test="${dto == null }">
		dto 는 없습니다.<br>
	</c:if>
	<c:if test="${dto != null }">
		dto 는 있습니다.<br>
	</c:if>


	<c:choose>
		<c:when test="${empty ghost }">
			ghost 는 없습니다. <br>
		</c:when>
		<c:when test="${not empty ghost }">
			ghost 는 있습니다. <br>
		</c:when>
	</c:choose>

<hr>
<%
	Person park = null;
%>

<c:set var="v1" value="<%= park %>"/>   <!-- park 은 null 값(변수는 존재하나 값이 없는 상태) -->
park: ${v1 }  
<br>

<c:if test="${empty v1 }">  <!-- null 값도 empty! -->
v1 은 empty 입니다 <br>
</c:if>
<c:if test="${empty v2 }"> <!-- 존재하지 않는 것도 empty! -->
v2 은 empty 입니다 <br>
</c:if>


<!-- (empty 의 의미) -->
<!-- 변수 자체가 없는 것도 empty, 변수 있지만 값이 없는 것(null)도 empty 이다. -->


</body>
</html>