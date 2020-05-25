<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL Core2</title>
</head>
<body>

<h2>set, remove, out</h2>
<c:set var="name" value="장윤성"/><!-- 변수 선언하기 : set 태그 -->
이름 : <c:out value='jang'/><br>  <!-- 출력하기 : out 태그 -->
이름: <c:out value='${name }'/><br>  <%-- JSP 세상의 변수를 EL 로 가져왔따 --%>
									 <%-- JSTL 변수는 EL 에서 사용 가능 --%>
${name }<br>


<c:remove var="name"/><!-- 변수 제거하기 : remove 태그 -->
이름: <c:out value='${name }'/>  <!-- 변수 제거되어 출력되지 않음 -->

<hr>

<%
int age = 10;
%>
나이: ${age }<br>  <!-- age는 뭐가 나온다? 10? X  EL 은 java변수 안 나온다고 했다. -->
				<!-- 다시 한 번, Java 는 -> EL  (X)  -->

<c:set var="age" value="<%= age %>"/>
나이 : ${age }<br> <%-- Java → JSTL → EL (○) --%>


<hr>
<h2>catch</h2>

<c:catch var="error">
<!-- 이 안에서 예외 발생하면 예외객체를 error 변수에 담는다 -->
  <%= 2/0 %>
 </c:catch>
 <br>
 <c:out value="${error }"/> <!--익셉션 이름과 메시지 담겨있다.   -->
 
 <br>
 <c:catch var="ex">
 name parameter 값 = <%= request.getParameter("name") %>  <!-- name 못 찾았으므로 null 리턴 -->
 <% if(request.getParameter("name").equals("test")){ %> <!-- 예외 발생 (이러면 NPE) ~. 에서 쩜 앞에 ~ 가 null이므로. -->
  	${param.name } 은 test 입니다. 
 <% } %>
 </c:catch>  <!-- 실행시 500은 뜨지 않음 catch 로 에러 핸들링 해주었으므로  -->
 
 <br>
 <c:if test="${ex != null }">
 	null이 아닌경우 예외가 발생했다는 것..
 	- 예외발생<br>
 	${ex }<br>
 	
 
 </c:if>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 



</body>
</html>