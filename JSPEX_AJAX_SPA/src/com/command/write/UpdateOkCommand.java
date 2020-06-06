package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
	
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성  => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기

		// ajax response 에 필요한 값들 
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		try {
			cnt = dao.update(uid, subject, content);
			
			request.setAttribute("updateOk", cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try
		
		//	얘네들의 결과가 AjaxListCommand 로 넘어감
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}
