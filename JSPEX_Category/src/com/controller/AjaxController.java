package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.AjaxListCommand;
import com.command.CateListCommand;
import com.command.Command;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
		System.out.println("ajaxAction() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 Command 를 선택할지에 대하여
		// Controller 는 다음 두 개를 선택해야 한다.
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
		
		//  /cate_list.ajax  : 목록 요청 
		switch(com) {
		case "/cate_list.ajax":
			new CateListCommand().execute(request, response); // command 에서의 결과가 request 에 담겨있다.
			new AjaxListCommand().execute(request, response);
			break;
		
		}
		
	}

}
