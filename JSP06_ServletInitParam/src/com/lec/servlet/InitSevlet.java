package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitSevlet
 */
@WebServlet(urlPatterns = {"/InitS"},
			initParams = {
					@WebInitParam(name = "id", value="test11"),
					@WebInitParam(name = "pw", value="1000"),
					@WebInitParam(name = "local", value="Busan"),
					
			})
public class InitSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitSevlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletConfig 의 메소드=> getInitParameter() 를 사용한다..
		String id = getInitParameter("id");   
		String pw = getInitParameter("pw");   
		String local = getInitParameter("local");   
		
		response.setContentType("text.html; charset=utf-8");
		
		PrintWriter out = response.getWriter();

		// 콘솔화면에 출력
		System.out.println("id : " + id);
		System.out.println("비밀번호 :" + pw);
		System.out.println("지역 :" + local);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
