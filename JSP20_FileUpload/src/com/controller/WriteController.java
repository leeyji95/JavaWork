package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.Command;
import com.command.write.DeleteCommand;
import com.command.write.DownloadCommand;
import com.command.write.ListCommand;
import com.command.write.UpdateCommand;
import com.command.write.UpdateOkCommand;
import com.command.write.ViewCommand;
import com.command.write.WriteCommand;

/**
 * Servlet implementation class WriteController
 */
@WebServlet("*.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 Command 를 선택할지에 대하여
		// Controller 는 다음 두 개를 선택해야 한다.
		String viewPage = null;   // 어떠한 뷰? --> 페이지
		Command command = null;  // 어떠한 커맨드? --> 어떠한 로직 수행하는가.
		
		// url 찢어내기. 왜? url 에 command 가 담겨 있기 때문에. => URL 에서 Command 추출
		// URL로부터 URI, ContextPath, Command 분리
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		//테스트 출력
		System.out.println("uri: " + uri);
		System.out.println("conPath: " + conPath);
		System.out.println("com: " + com);  // cotextPath 뒤에 붙는 ~.uo 에서 ~  /~.uo
		
		// 컨트롤러는 커맨드에 따라, 로직을 수행하고
		// 결과를 내보낼 view 를 결정한다
		switch(com) {
		case "/list.do":
			command = new ListCommand(); // ListCommand 생성하고,  => 이게 command 골라내주고, DAO 만들겠지
			command.execute(request, response); // 그러면 execute 수행한다. 
			// 이 결과는 가득 담겨 있음.
			// 즉 request 에 DTO 배열 타입이 담겨있음!!! 
			viewPage = "list.jsp";
			break;
		case "/write.do":
			viewPage = "write.jsp";
			break;
		case "/writeOk.do":
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "writeOk.jsp";
			break;
		case "/view.do":
			command = new ViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
			break;
		case "/update.do":
			command = new UpdateCommand();
			command.execute(request, response);
			viewPage = "update.jsp";
			break;
		case "/updateOk.do":
			command = new UpdateOkCommand();
			command.execute(request, response);
			viewPage = "updateOk.jsp";
			break;
		case "/deleteOk.do":
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "deleteOk.jsp";
			break;
		case "/download.do":
			command = new DownloadCommand();
			command.execute(request, response);
			// 굳이 view 필요없다. 
			break;
		} // end switch
		
		// request 를 위에서 결정된 view 에 forward 해줌. 
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
			// viewPage 를 통해서 dispatcher 만들어 지고, 그 dispatcher로 부터 request 를 forward 해준다.
		}
		
	}// end actionDo()
	

} // end class
