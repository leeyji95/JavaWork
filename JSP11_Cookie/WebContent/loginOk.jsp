<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! 
	// 아이디랑 비번이 이거이면 로그인 성공이라는 데이터 값.(아직DB에 대해 자세히 안배움)
	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
%>    
<% 
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");

	String cookieName = "userid";
	String cookieValue = userid; //로그인 승인 된 아이디의 쿠키 밸류값을 넣겠다.  

	// id / pw 일치하면  로그인 성공 + 쿠키 생성 할 것 
	if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
		out.println("<script>");
		out.println("alert('로그인 성공');");
		out.println("</script>");
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(2 * 30);  // 쿠키 파기(expiry) 시간 설정 (생성시점으로부터 2 * 30 초 후)
		response.addCookie(cookie);   // response 에 쿠키 정보 추가d
		
	}else{
		out.println("<script>");
		out.println("alert('로그인 실패');");
		out.println("</script>");
		
		
		// 쿠키 지우기(기존에 있었더라도 삭제하겠다)
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(0);		// 기존에 있었더라도 죽인다
		response.addCookie(cookie);   // response 에 쿠키 정보 추가
	}
%>

<script>
location.href = "login.jsp";  // 원래 페이지도 돌아가기 
</script>

    