package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SCEx")
public class ServletContextEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextEx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletContext 객체를 통해 초기화 값 얻어오기
				String id = getServletContext().getInitParameter("id");
				String pw = getServletContext().getInitParameter("password");
				String local = getServletContext().getInitParameter("local");
				
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				
				//html 형식으로 출력
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("id : "+id+"<br>");
				out.println("비밀번호 :" + pw+"<br>");
				out.println("지역 :" +local+"<br>");
				out.println("</body>");
				out.println("</html>");
				// 콘솔화면에 출력		
				System.out.println("id : "+id);
				System.out.println("pw :"+pw);
				System.out.println("local : "+local);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
