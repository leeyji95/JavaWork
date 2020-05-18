package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/He")  // <--- 이게 url 매핑 된 url이다. !! (대소문자 가리므로 ->  주의하쟈) 에러날 시, 무조건 url 부터 확인 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

    
    // 웹프로그램 구조를 가지고 있다. get 방식으로 url 요청하여, post 방식으로 url요청하여 response 받는가.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("안녕하세요 첫번째 Servlet 입니다.");  // => get 방식으로 url 요청 시마다  찍힘.
		
		// 서블릿으로 HTML 문서 response 하기
		// 1. content type 설정
		// 2. PrintWriter 객체 생성 -> response 객체로부터
		// 3. PrintWriter 객체로 HTML 스트림에 쓰기.                     // MDN mime  레퍼런스 참고 
		response.setContentType("text/html; charset=utf-8");  // 마임타입 설정해줌. -> html 은  기본적으로 text/html 임. html/plain 하면 -> 걍 text 파일로 보여준다 
		PrintWriter out = response.getWriter(); 
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>서블릿 response</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>HTML문서 response</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
