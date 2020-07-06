package com.lec.sts19_spa.ajaxcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_spa.board.C;
import com.lec.sts19_spa.board.beans.IAjaxDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int cnt = 0;
		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 유효성 검증
		String[] params = request.getParameterValues("uid");
		int[] uids = null;

		if (params == null || params.length == 0) {
			message.append("유효하지 않은 parameter 0 or null");
		} else {
			uids = new int[params.length];
			try {
				for(int i = 0; i < params.length; i++) {
					uids[i] = Integer.parseInt(params[i]);  // 여기서 숫자가 아닌 다른 것들이 들어왔을 때 익셉션 처리하도록 밑에 캐치절 추가
				}
				cnt = dao.deleteByUid(uids);  // 기존 uid 를 -> uids 로 바꾼다
				status = "OK"; 
			} catch (NumberFormatException e) {
				e.printStackTrace();
				message.append("[유효하지 않은 parameter : " + e.getMessage() + "]");
			} catch (Exception e) {
				e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} // end try

		}

		// 얘네들의 결과가 AjaxListCommand 로 넘어감
		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}
