package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// uid 파라미터 받아오기.
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성  => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기
		WriteDTO [] arr = null;

		try {
			arr = dao.selectByUid(uid);
			
			request.setAttribute("update", arr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
