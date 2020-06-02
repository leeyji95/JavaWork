package com.command.write;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. 업로드 된 파일 저장
		
		final String SAVE_URL = "ckupload";   
		
		// 실제 저장되눈 물리적인 경로 확인 
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath(SAVE_URL);
		System.out.println("업로드 경로: " + saveDirectory);
		
		Enumeration names = null;
		String name = null; // parameter 로 넘어오는 name 값
		String originalFileNmae = null ; // 원본 파일 이름
		String fileSystemName = null; // 실제 저장되는 파일 이름
		String fileType = null; // 파일 MYME 타입
		String fileUrl = null; // 업로드 된 파일의 URL 
		
		int maxPostSize = 5 * 1024 * 1024; // POST 받기, 최대 5M byte
		String encoding = "utf-8"; // 인코딩
		FileRenamePolicy policy = new DefaultFileRenamePolicy(); //업로딩 파일 이름 중복에 대한 정책 
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(  // 생성자 생성한 것만으로도 물리적 저장까지 완료가 진행된다. 
						request, 
						saveDirectory,
						maxPostSize,
						encoding,
						policy
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		// 1-2 저장된 파일 꺼내오기 
		names = multi.getFileNames();  // type="file" 요소의 name 들 추출 
		
		// ch에디터가 html 만들었는데, 서버전송 을 어떤 name 으로 보냈는가
		while(names.hasMoreElements()) {
			name = (String)names.nextElement()	;
			System.out.println("input name: " + name); // CKEditor 에선 name 이 "upload" 에 있다. 
			
			// 전부다 파라메타는 name 으로 준다.
			originalFileNmae = multi.getOriginalFileName(name); //원래 이름 가져오기
			fileSystemName = multi.getFilesystemName(name);  // 파일 시스템 이름
			fileType = multi.getContentType(name);
			
			
			// 지금 이거 뭐한거다? 물리적인 경로 뽑아내기 위해 작성한 거다. 
			fileUrl = request.getContextPath() + "/" + SAVE_URL + "/" + fileSystemName;
			System.out.println("fileUrl: " + fileUrl);
			
			
		}
		
		// 2. response (CKEditor 에서 정한 포맷)
//		{
//		    "uploaded": 1,
//		    "fileName": "foo.jpg",
//		    "url": "/files/foo.jpg"
//		}
		
		// 위에 json 파일 손코딩으로 만들어보자
		
		String jsonString = "{\"fileName\" : \"" + fileSystemName
					+ "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";
		
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		}catch(IOException e ) {
			e.printStackTrace();
		}
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	} // end execute()	

} // end Command 
