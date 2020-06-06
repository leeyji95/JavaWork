package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt = 0;
		
		WriteDAO dao = new WriteDAO();
		
		// ajax response 에 필요한 값들 
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL
		
		// 입력한 값을 받아오기
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			cnt = dao.deleteByUid(uid);
			
			request.setAttribute("delete", cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try
		
		//	얘네들의 결과가 AjaxListCommand 로 넘어감
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

		
	}

}
