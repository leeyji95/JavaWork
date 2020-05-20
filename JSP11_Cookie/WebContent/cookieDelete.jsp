<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Cookie[] cookies = request.getCookies();
	String cookieName = "num1";
	
	if(cookies != null){
		for(int i = 0; i < cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){
				cookies[i].setMaxAge(0); // expiry 를 0 으로 하면      / 리스폰스 되자마자 바로 죽음
				response.addCookie(cookies[i]); // response 직후 곧바로 삭제
			}
		}// end for 
	} // end if

%>
<script>
alert("<%= cookieName%> 쿠키삭제");
location.href = "cookieList.jsp";
</script>