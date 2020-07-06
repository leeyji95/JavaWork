package com.lec.sts19_spa.ajaxcommand;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_spa.board.C;
import com.lec.sts19_spa.board.beans.IAjaxDAO;

public class UpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		
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

			} catch (NumberFormatException e) {
				e.printStackTrace();
				message.append("[유효하지 않은 parameter : " + e.getMessage() + "]");
			} catch (Exception e) {
				e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} // end try

		} // end if

		// 얘네들의 결과가 AjaxListCommand 로 넘어감
		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		
	}

}
