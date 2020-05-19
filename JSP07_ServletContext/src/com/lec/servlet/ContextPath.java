package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 여러개의 어플리케이션을 식별할 수 있는 수단으로 사용한다! 뭐가? context Path가 !
/**
 * Servlet implementation class ContextPath
 */
@WebServlet("/ConPath")
public class ContextPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextPath() {  
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// url 정보도, 파라메타 정보도 모두 request 객체로부터 뽑아낸다.!!!
		
		
		// URL : Uniform Resource Locator
		StringBuffer url = request.getRequestURL(); // url 뽑아냄. 얘는 StringBuffer를 리턴행
		// URI : Uniform Resource Identifier
		String uri = request.getRequestURI();  
		// Context Path
		String conPath = request.getContextPath();
		//domain 추출하기 
		String url_domain = request.getScheme() + "://" + request.getServerName()
		 	+ " : " + request.getServerPort();
		
		
		// 물리적인 servletContextName 은  --> context path 가 아니다
		ServletContext context = request.getServletContext();
		String servletContextName = context.getServletContextName();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset='utf-8'");
		out.println("<hr>");
		out.println("URL: " + url + "<br>");
		out.println("URI: " + uri + "<br>");
		out.println("Context Path: " + conPath + "<br>");
		out.println("URL_domain: " + url_domain + "<br>");
		out.println("servletContextName: " + servletContextName + "<br>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}  // end class
