package com.lec.sts19_spa.ajaxcommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_spa.board.C;
import com.lec.sts19_spa.board.beans.BWriteDTO;
import com.lec.sts19_spa.board.beans.IAjaxDAO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		List<BWriteDTO> arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// uid 파라미터 받아오기.
		String param = request.getParameter("uid");

		// 유효성 검사
		if (param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {
			try {
				int uid = Integer.parseInt(param);

				//dto = dao.readByUId(uid); // 읽기 + 조회수 증가
				dao.incViewCnt(uid); // 조회수 증가
				arr = dao.selectByUid(uid); // 읽기

				if (arr == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}

			} catch (NumberFormatException e) {
				// e.printStackTrace();
				message.append("[유효하지 않은 parameter : " + e.getMessage() + "]");
			} catch (Exception e) {
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} // end try
		} // end if

		request.setAttribute("list", arr);  // dto 타입이면 list로 변환해주면 된다. Arrays.asList(dto) 사용하기
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}
