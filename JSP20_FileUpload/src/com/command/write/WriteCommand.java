package com.command.write;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		//-------------------------------------------------
		// 업로드 파일 저장 경로
		ServletContext context = request.getServletContext(); // 물리적인 파일 명 
		String saveDirectory = context.getRealPath("upload");
		
		int maxPostSize =  5 * 1024 * 1024; // POST 받기, 최대크기 5M byte = ? byte
		String encoding = "utf-8";
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> originalFileNames = new ArrayList<String>();
		List<String> fileSystemNames = new ArrayList<String>();
		
		// File 들 추출
		// name 이 식별자임. 이걸로 파일별로 구분했다. 
		Enumeration names = multi.getFileNames();  // type="file" 요소 name 들 추출(input 의  file 타입의 name 들을 뽑음)
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String originalFileName = multi.getOriginalFileName(name);// 위 name 의 '업로드 파일명'을 가져온다.
			String fileSystemName = multi.getFilesystemName(name);// 서버 시스템에 '저장된 파일명'을 가져온다.
			System.out.println("첨부파일: " + originalFileName + "->" + fileSystemName);

			if (originalFileName != null && fileSystemName != null) {
				originalFileNames.add(originalFileName);
				fileSystemNames.add(fileSystemName);
			}

		}		
		
		// 매개변수 받아오기
		String name = multi.getParameter("name"); // ★MultipartRequest 객체 사용!
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");

		if (name != null && subject != null && name.trim().length() > 0 && subject.trim().length() > 0) {

			try {
				// ★ 첨부파일 정보 같이 INSERT 해준다 ! -> , originalFileNames, fileSystemNames 매개변수 추가 !
				cnt = dao.insert(subject, content, name, originalFileNames, fileSystemNames); // 성공하면 1
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end if()
		// 이 결과를 result 라는 이름의 request 객체에 담는다.
		request.setAttribute("result", cnt);
		
		
	}// end execute()

}// end Command()
