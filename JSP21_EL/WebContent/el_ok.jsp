<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL 내장객체</title>
</head>
<body>

<% 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String [] hobby = request.getParameterValues("hobby");
%>

아이디: <%= id %><br>
비밀번호 : <%= pw %> <br>
취미 : 
<% for(int i = 0; i < hobby.length; i++){ %>
	<%= hobby[i] %>
<% } %>

<%-- EL에서의 내부객체 : param. 이 있다. --%>

	아이디 : ${param.id }<br>
	비밀번호 : ${param.pw }<br>
	취미 : ${paramValues.hobby[0] }
		  ${paramValues.hobby[1] }
		 ${paramValues.hobby[2] }<br>
<hr>
	<%--프라퍼티 접근할 때 이런식으로도 할 수 있따는 걸 보여줌. --%> 
	아이디 : ${ param["id"] } <br>
	비밀번호 : ${ param["pw"] } <br>  <%-- 명심: EL 은 Java가 아니다. --%>
	취미: ${ paramValues["hobby"][0] } 
		${ paramValues["hobby"][1] } 
		${ paramValues["hobby"][2] } <br>
	
<hr>
	applicationScope : ${ applicationScope.application_name }<br>
	sessionScope : ${ sessionScope.session_name }<br>
	pageScope : ${ pageScope.page_name }<br>
	requestScope : ${ requestScope.request_name }<br>
	
<hr>
	context 초기화 파라미터<br>
	${initParam.con_name }<br>
	${initParam.con_id}<br>
	${initParam.con_pw}<br>

<hr>
	ContextPath<br>
	<%= request.getContextPath() %>
	${pageContext.request.contextPath }<br>
	  <!-- 프론트 엔드에서 많이 쓴다.
	  	/ 는 도메인 다음 
	 그래서 아래와 같이 어느 컨텍스트 패스에서도 동작할 수 있도록 만드는 것이다.
	  	-->
	
<!-- 		만약에 컨텍스트 패스가 바뀐 경우 다 고쳐야해..  -->
	<a href="/JSP21_EL/el_form.jsp">입력폼</a>	
	<a href="${pageContext.request.contextPath }/el_form.jsp">입력폼</a>	
<!-- 		그래서 이렇게 쓴다. 컨택스트 경로가 꼭 필요한 경우에 이렇게 써라.(수정해도 어느 컨텍스트 패스에서도 동작할 수있도록한다.) -->
	



</body>
</html>