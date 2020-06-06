package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.*;


@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}
	
	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajaxAction() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 Command 를 선택할지에 대하여
		// Controller 는 다음 두 개를 선택해야 한다.
//		String viewPage = null;    여기선 이제 view 필요없으므로 날리세요 . 
		Command command = null;  // 어떠한 커맨드? --> 어떠한 로직 수행하는가.
		
		// url 찢어내기. 왜? url 에 command 가 담겨 있기 때문에. => URL 에서 Command 추출
		// URL로부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		//테스트 출력
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com: " + com);
		
		switch(com) {
		case "/list.ajax": // A 글목록(페이징)
			new ListCommand().execute(request, response); // command 에서의 결과가 request 에 담겨있다.
			new AjaxListCommand().execute(request, response);
			break;
			
		case "/view.ajax": // B 글 읽기
			new ViewCommand().execute(request, response); 
			new AjaxListCommand().execute(request, response);
			break;
			
		case "/writeOk.ajax": // C 글 작성
			new WriteCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
			
		case "/updateOk.ajax": // D 글 수정 
			new UpdateOkCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
			
		case "/deleteOk.ajax": // F 글 삭제 
			new DeleteCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
		
		} // end switch
		
		
	} // end ajaxAction()
	
	
	
} // end AjaxController
