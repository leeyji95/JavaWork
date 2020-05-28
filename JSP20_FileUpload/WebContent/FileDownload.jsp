<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.*"%>
<%@ page import="java.io.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String fileSystemName = request.getParameter("fileSystemName");
	if (fileSystemName == null) {
		return;
	}

	String originalFileName = request.getParameter("originalFileName");
	if (originalFileName == null) {
		originalFileName = fileSystemName;
	}
%>

<%
	//파일을 다운로드 할때 파일의 제목이 인코딩에 따라 제목이 깨질수 있다.
	// 따라서 제목 인코딩이 필요하다

	// 유형을 파악해야 한다
	//  - FileInputStream : byte stream - 바이너리
	//  - FileReader : char stream  - 문자기반

	// 1) 다운로드 받을 파일의 경로및 이름  지정
	// 업로드된 폴더 위치와 업로드 폴더의 이름을 알아야 한다.
	String realPath = "";

	// 직접 폴더 지정할 경우
// 	realPath = "C:\\tomcat\\upload";
	
	ServletContext context = getServletContext();
	realPath = context.getRealPath("upload");
	
	

	System.out.println("downloadPath: " + realPath);

	String downloadFilePath = realPath + File.separator + fileSystemName;
	System.out.println("downloadFilePath: " + downloadFilePath);

	// 2. 유형 (MIME) 확인 - 읽어올 파일의 유형
	// -> response 받을 브라우저에서 페이지 생성할 때 위 타입정보를 가지고 판단함

	String fileType = getServletContext().getMimeType(downloadFilePath); // 마임타입에 경로 지정해준다. ? 
	// 유형이 지정되지 않은 경우  --> 디폴트 마임타입 지정해줘야 한다.  
	if (fileType == null) {
		fileType = "application/octet-stream"; // 일련의 8-bit 스트림 형식
												// 유형이 알려지지 않은 파일에 대한 읽기 형식 지정 
	}
	System.out.println("파일유형(MIME): " + fileType);

	// 3. response 세팅
	// response 에 유형(MIME) 을 알려준다.
	response.setContentType(fileType);

	// 원본 파일 이름으로 다운로드 받을 수 있게 처리
	String encFileName = URLEncoder.encode(originalFileName, "utf-8");

	// response 헤더에 추가 
	response.setHeader("Content-Disposition", "attachment; filename=" + encFileName);
	// 웹 크롤에서 (이미지)   url 에 파일 이름이 없는 경우, 대신에 Content-disposition 헤더값에 들어있어서 우리가 찢어냈었는데, 
	// 지금은 우리가 이 안에 이름을 집어 넣고 있는 중

	
	
	
	 
	// 4. 클라이언트에 파일 전송하기 전에 내부객체 out 을 clear()______청소해준다고 생각!
	// JSP 에서 OutputStream 을 이용해서 바이너리나 이미지 등을 스트림으로 전송할 때 밑의 response.getOutputStream() 을 해주기 전에
	// 기본적으로 생성된 내부객체 out 과의 충돌 이 생실수 있으니, 미리 clear() 한다.
	// 충돌 발생시  IllegalStateException 발생
	out.clear();  // out 객체내 출력할 내용들 제거.
	out = pageContext.pushBody();  // <-- 커스텀 태그 등도 clear 하고 JspWrite(out)에 새로운 body 생성
	
	
	
	
	// 5. File 전송 --> ServletOutputStream
	File srcFile = new File(downloadFilePath);
	FileInputStream in = new FileInputStream(srcFile);
	ServletOutputStream sout = response.getOutputStream();  //ServletOutputStream 은 response 의 getOutputStream 에서 뽑아온다. 
	
	// 입력은 File 과 FileInputStream 으로, 출력은 ServletOutputStream 으로! 
	
	// 버퍼 준비. 최대 5M 짜리 버퍼 준비
	byte [] buff = new byte[5 * 1024 * 1024]; // 5M
	int numRead = 0;
	int totalRead = 0;
	
	try{
		// 파일로 부터 읽기
		while((numRead = in.read(buff, 0, buff.length)) != -1){ // 버퍼를 0부터 최대 버퍼 길이만큼 읽어들이겠다.
			totalRead += numRead;
			sout.write(buff, 0, numRead); // 버퍼를 0부터 읽어들인 만큼  출력하겠다. -> 이게 ' 전송' 역핡한다
 		} // end while 
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		sout.flush(); // 마지막 한 바이트까지 완전히 전송.
		sout.close(); 
		in.close();
	}
	System.out.println("전송  byte: " + totalRead + " bytes");  //콘솔에 몇 바이트 읽고 썻는지만 찍어 주자. 
	
	
	
	
	
%>
































