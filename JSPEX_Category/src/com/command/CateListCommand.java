package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		CategoryDAO dao = new CategoryDAO(); // DAO 객체 생성
		CategoryDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 클라이언트 쪽에서 request 받아옴
		int depth = Integer.parseInt(request.getParameter("depth"));
		String param = request.getParameter("parent");
		
		
		// 유효성 검사
		try {
			if (param == null  || param == "" || depth == 1) {
				arr = dao.readBydNp(depth);
				if (arr == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}
			}else {
				int parent = Integer.parseInt(param);
				
				dao = new CategoryDAO();
				arr = dao.readBydNp(depth, parent); // DTO 애들 담김.
				if (arr == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			message.append("[트랜잭션 에러:" + e.getMessage() + "]");
		} catch (Exception e) {
			message.append("[예외발생:" + e.getMessage() + "]");
		} // end try
		request.setAttribute("list", arr);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	} // end execute()

} // end CateListCommand
