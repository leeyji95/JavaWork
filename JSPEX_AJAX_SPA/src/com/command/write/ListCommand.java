package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		WriteDAO dao = new WriteDAO(); // DAO 객체 생성 => 여기서는 서블릿에서 생성한다. 아까는 JSP에서 빈객체로 생성했음 그 차이 알기
		WriteDTO[] arr = null;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 페이징 관련 세팅값들
		int page = 1; // 현재 페이지(디폴트는 1page)
		int pageRows = 8; // 한 ' 페이지' 에 몇 개의 글을 리스트? (디폴트 8개)
		int writePages = 10; // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0; // 글은 총 몇개인지?
		int totalPage = 0; // 총 몇 '페이지' 분량인지?

		// 두개의 매개변수 받아옴
		String param;

		// page 값 : 현재 몇 페이지?
		param = request.getParameter("page");
		// 만약에 여기서 page 가 잘못 들어오거나 엉뚱한게 들어오면 -> 익셉션 처리 따로 하지 않고, page 1로 가도록 할 것.
		if (param != null && param.trim().length() != 0) {

			// 정상적으로 수행되었는지 아닌지 확인해보기 위해 try-catch 로 감싸줌
			try {
				page = Integer.parseInt(param); // 파싱하는 과정에서 null 이나 0이 나와도 -> page 1 로
			} catch (NumberFormatException e) {
				// 예외처리 하지 않음.
			}
		}

		
		// pageRows 값 : '한 페이지' 에 몇개의 글?
		param = request.getParameter("pageRows");
		if (param != null && param.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				// 예외처리 하지 않음.
			}
		}

		
		
		try {
			// 글 전체 개수 구하기 
			totalCnt = dao.countAll();
			
			// 총 몇 페이지 분량인가?
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			// 몇 번째 row 부터? 
			int fromRow = (page - 1) * pageRows + 1; // ORACLE 은 1부터 ROWNUM 시작
			// int fromRow = (page - 1) * pageRows; // MySQL 은 0부터 ROWNUM 시작

			dao = new WriteDAO();
			arr = dao.selectFromRow(fromRow, pageRows);
			
			if(arr == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				status = "OK";
			}
			
		} catch (SQLException e) {
			// e.printStackTrace();
			message.append("[트랜젝션 에러: " + e.getMessage() + " ]");
		} // end try

		
		
		// 얘네들의 결과(arr)가 AjaxListCommand 로 넘어감
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);
		
		request.setAttribute("page", page);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("writePages", writePages);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("totalPage", totalPage);
	}

}
