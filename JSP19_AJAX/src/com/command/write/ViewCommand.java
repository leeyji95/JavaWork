package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		// uid 파라미터 받아오기.
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		
		try {
			arr = dao.readByUId(uid);
			
			
			// view 이름으로 request 결과 담아 Controller 에 보내겠다.
			request.setAttribute("view", arr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
