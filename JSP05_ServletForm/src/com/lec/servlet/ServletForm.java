package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/FormOk")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request.getParameterNames()
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String paramName = names.nextElement()	;
			String paramVlaue = request.getParameter(paramName);
			System.out.println(paramName + " : " + paramVlaue);
		}
		
		System.out.println("getParameterMap()사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			System.out.println(key + " : " + Arrays.deepToString(paramMap.get(key)));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 방식. 한글 인코딩 처리 우선!!
		request.setCharacterEncoding("utf-8");
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String [] hobbys = request.getParameterValues("hobby"); // 1개, 0개 가 담겨있어도 배열로 넘어옴
		String gender = request.getParameter("gender");
		String local = request.getParameter("local");
		String memo = request.getParameter("memo");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("hidden : " + data1 + ", " + data2 + "<br/>");
		out.println("이름 : " + name + "<br/>");
		out.println("아이디 :" + id + "<br/>");
		out.println("비밀번호 :" + pw + "<br />");
		
		out.println("취미 :" + Arrays.toString(hobbys) + "<br/>");
		out.println("성별 :" + gender + "<br/>");
		out.println("지역 :" + local + "<br/>");
		out.println("메모 :" + memo + "<br/>");
		out.println("</body></html>");
		
		out.close();
		
		//request.getParameterNames() => name과 value 같이 뽑는애들. 한번에 뽑기 
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String paramName = names.nextElement()	;
			String paramVlaue = request.getParameter(paramName);
			System.out.println(paramName + " : " + paramVlaue);
		}
		
		System.out.println("getParameterMap()사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			System.out.println(key + " : " + Arrays.deepToString(paramMap.get(key)));
		}
		
//	사용자가 
		
	}

}
