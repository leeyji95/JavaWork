<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <!-- JDBC 관련 import -->
<%@ page import ="java.text.*" %>

<% // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요 
%>

<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과
	int cnt = 0;  // DML 결과 executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>

<%!  
	// 쿼리문 준비
	// 글 읽어오기 
	final String SQL_WRITE_SELECT_BY_UID =  // 글 읽어 오기
		"SELECT * FROM test_write WHERE wr_uid = ?";


%>
<%
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>



<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>"); //  테스트 출력
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>"); // 테스트 출력
		
		//트랜잭션 실행   : 트랜잭션이란, 데이터 조작 동작 단위이다. (여러개의 쿼리 수행될 수도 있음)
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		
		
		// 한개의 레코드만 select 된다.  따라서 while 안 돌려도 된다. 걍 있으면 읽어오면 된다.
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");  // 이 아이는 null 허용함. 
			if(content == null) content = "";  // null 처리 해주는 거임
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			 
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			 
			 regdate = "";
			 if(d != null){
				 regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
						 + new SimpleDateFormat("hh:mm:ss").format(t);
			 }
		}else{  // 해당 uid 값이 없는 경우
			//wr_uid 값의 레코드가 없다는 뜻. (쿼리가 실패한 것이 아님)
%>

<script>
	alert("해당 정보가 삭제되거나 없습니다.");
	history.back();
</script>
					
<% 			return;  // 더이상 JSP 프로세싱 하지 않고 종료 
		}// end if 
	} catch(Exception e){
		e.printStackTrace();
		// 예외처리
	} finally{
		//리소스 해제
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} 

%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 <%= subject %></title>
</head>

<script>
function chkSubmit() {
	frm = document.forms.frm;
	var subject = frm.subject.value.trim();
	
	
	if(subject == ""){
		alert("제목은 반드시 작성해야 합니다");
		frm.subject.focus();
		return false;
	}
	return true;
}
</script>


<body>
<h2>수정</h2>	
<form name="frm" action="updateOk.jsp" method="post" onsubmit="return chkSubmit()">
	<input type="hidden" name="uid" value="<%= uid %>">  <!-- uid 받은 값을 또 다시 보내야 할 때.  get 방식에는 ? 로 해서 보내면 된다.  -->

작성자: <%= name %><br>  <!-- 작성자 이름 변경 불가  -->
제목 : 
<input type="text" name="subject" value="<%= subject %>"/><br>
내용: <br>
<textarea name="content"><%= content %></textarea>
<br>
<input type="submit" value="수정"/>
</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.jsp'">목록보기</button>

</body>
</html>