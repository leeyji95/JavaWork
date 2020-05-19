package com.lec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCycle
 */
@WebServlet("/Cycle") // 이러한 url로 보내겠다 명시_url매핑
public class ServletCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCycle() { // Request 했을때 톰캣 컨테이너에서 최초 단 한 번 생성된다. 
        super();
        System.out.println("서블릿 생성");
    }
    
    // 서블릿 객체 생성 이후(직후)
    @Override
    public void init() throws ServletException {
    	System.out.println("init 호출");
    }

    //서버 종료 될 때 소멸됨.
    @Override 
    public void destroy() {
    	System.out.println("destroy 호출");
    }
    
    // 언제 이걸 쓰는가? 자원을 쓰고 해제할 때 서블릿 init 과 destroy 해준다.
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("doPost()호출");
	}
    
    
    // 서버 가동하고 console 에 찍히는 순서를 보아라. 
    
    // doGet(), doPost() 같이 있으면 service() 얘부터 호출된다. 
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("service() 호출");
    }
    

} // end class
