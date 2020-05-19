package com.lec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CL_Ex")
public class ContextEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextEx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("App START~");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
//서버가 가동될 때 웹어플리케이션 시작되고, 서버 종료할 때 어플리케이션도 종료된다. 