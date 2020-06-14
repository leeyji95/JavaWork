<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- cos 라이브러리 -->
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.FileRenamePolicy"%> <!-- 중복된 파일 이름 rename 해줌 -->
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
 
 <!-- parameter 값들, file 값들 추출 -->
 <%@ page import="java.util.Enumeration" %>
 
 <!-- File 객체  -->
 <%@ page import="java.io.File" %>
 
 <!-- 업로드 된 파일이 이미지인 경우..  이미지 다루는 객체 가져오기 -->
 <%@ page import="java.awt.image.BufferedImage" %>
 <%@ page import="javax.imageio.ImageIO" %>
 
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>파일 업로드 결과</title>
</head>
<body>

<form action="FileCheck.jsp" method="post" name="fileCheck">
<%
	// MultipartRequest 객체 생성 준비 
// 	String saveDirectory = "C:\\tomcat\\upload";  // 저장할 경로

	// 파일 저장경로
	// 서버에서(서블릿) 어디에 어느폴더에서 서블릿으로 변환되는지 알아내기
	ServletContext context = this.getServletContext();// 현재 가동중인 서블릿 : this,    
	String saveDirectory = context.getRealPath("upload");
	
	System.out.println("업로드 경로: " + saveDirectory); // 콘솔에 찍어보기
	
	int maxPostSize = 5 * 1024 * 1024; // POST 받기, 최대크기 5M byte = ? byte
	String encoding = "utf-8";  // 인코딩
	FileRenamePolicy policy = new DefaultFileRenamePolicy(); // 업로딩 파일 이름 중복에 대한 rename 정책

	MultipartRequest multi = null;
	
	try{ // jsp 파일에서 에외를 반드시 catch 할 필요는 없다.. 안하면 500이 나올 뿐
		
		// MultipartRequest 생성단계에서 이미 파일은 저장됨(((((())))))
		multi = new MultipartRequest(
				request, // JSP 내부객체 request
				saveDirectory, // 업로드 파일 저장 경로 
				maxPostSize, // 최대 파일 크기 (post 크기)
				encoding, 
				policy  // 중복이름의 파일 rename 객체 
				);
	
	
	Enumeration names = null;
	
	// 1. Parameter name 들 추출
	names = multi.getParameterNames(); // 일반 form parameter name 
	while(names.hasMoreElements()){
		String name  = (String)names.nextElement(); // name
		String value = multi.getParameter(name); // value
		out.println(name + " : " + value + "<br>");
		
	} // end while 
	out.println("<hr>");
	
	// 2. File 들 추출 
	names = multi.getFileNames(); // type="file" 요소 name 들 추출(input 의  file 타입의 name 들을 뽑음) 
	while(names.hasMoreElements()){
		String name = (String)names.nextElement();
		out.println("input name: " + name + "<br>"+ "<br>");
		
		
		// 파일첨부 구현하려면, 이 두가지의 파일명을 모두 서버에 저장해야 한다 !!!
		
		// 위 name 의 '업로드 파일명'을 가져온다.
		String originalFileName = multi.getOriginalFileName(name);
		out.println("원본파일 이름: " + originalFileName + "<br>"+ "<br>");
		out.println("<input type='hidden' name='originalFileName' value='" + originalFileName + "'");
	
		// 서버 시스템에 '저장된 파일명'을 가져온다. 
		String fileSystemName = multi.getFilesystemName(name);
		out.println("파일시스템 이름: " + fileSystemName + "<br>"+ "<br>");
		out.println("<input type='hidden' name='fileSystemName' value='" + fileSystemName + "'");
		
		// 업로딩된 파일의 타입 : MIME 타입(ex: image/png ...)  __ 내가 정해준 파일 타입만 업로드 걸어줄 경우  -> 이 시점에서 마임타입 정해서 해줘야 한다. 
		String fileType = multi.getContentType(name);
		out.println("파일타입: " +  fileType + "<br>"+ "<br>");
		
		// 문자열 '파일이름' 이 name 에 들어온 상태
		// 문자열 파일이름을 통해 실제 파일 정보를 -> File 객체로 가져오기 
		File file  = multi.getFile(name);
		if(file != null){
			long fileSize = file.length(); // 파일 크기 (byte)
			out.println("파일크기: " + file + " bytes<br>");
		}
		
		// 이미지 파일 다루기
		BufferedImage bi = ImageIO.read(file); // 파일 객체를 read 안에 넣어주면 파일을 읽어들임. 
		
		// 파일이 이미지였으면 -> null 이 아닌 어떤 걸 리턴할 것임.
		
		if(bi != null){ // ★이미지 파일 판정 여부 ★
			int width = bi.getWidth();
			int height = bi.getHeight();
			out.println("이미지파일 W x H: " + width + " x " + height);
		} else {
			out.println("이미지가 아닙니다.<br>");
		}
		
			out.println("<hr>");
		
	} // end while 
	
		
	} catch(Exception e){
		e.printStackTrace();
		out.println("파일 처리 예외 발생 <br>");
		
	}
%>
<input type="submit" value="업로드 파일 확인"/><br>
</form>
</body>
</html>