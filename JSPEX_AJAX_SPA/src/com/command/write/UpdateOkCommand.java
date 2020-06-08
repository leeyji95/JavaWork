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

		WriteDAO dao = new WriteDAO(); // DAO 객체 생성 => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 입력한 값을 받아오기
		String param = request.getParameter("uid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// 유효성 체크
		if(param == null) {
			message.append("유효하지 않은 parameter 0 or null");
		} else if(subject == null || subject.trim().length() == 0) {
			message.append("유효하지 않은 parameter : 글제목 필수 !");
		} else {
			
			try {
				int uid = Integer.parseInt(param);
				
				cnt = dao.update(uid, subject, content);
				status = "OK";

				// status 는 일단 OK 로 갈게, 근데 메시지만 다르게 해줄게
				if(cnt == 0) {
					message.append("[0 update]");
				} 

			} catch (SQLException e) {
				//e.printStackTrace();
				message.append("트랜잭션 에러: " + e.getMessage());
			} catch (Exception e) {
				message.append("유효하지 않은 parameter : " + param);
			}

		} // end if

		// 얘네들의 결과가 AjaxListCommand 로 넘어감
		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		
	}

}
