package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		WriteDAO dao = new WriteDAO();
		
		// ajax response 에 필요한 값들 
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL
		
		// 매개변수 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// 유효성 체크
		if (name == null || name.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 작성자 필수]");
		} else if (subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 글제목 필수]");
		} else {
			try {
				cnt = dao.insert(subject, content, name);
				if(cnt == 0) {
					message.append("[트랜잭션 실패: 0 insert");
				}else {
					status = "OK";// 얘가 최종적 성공
				}
			} catch(SQLException e)	{
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}
		} // end if

		
		// 이 결과를 result 라는 이름의 request 객체에 담는다.
		request.setAttribute("result", cnt);

		// 얘네들의 결과가 AjaxListCommand 로 넘어감
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}// end execute()

}// end Command()
