package com.lec.sts19_rest.board.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/board")
public class BoardrestController {

	// 로딩 시 첫 시작 페이지
	@RequestMapping("/rest/{page}/{pageRows}")
	public AjaxWriteList list(Model model, @PathVariable int page, @PathVariable int pageRows) {

		// Ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 페이징 관련 세팅값들
//		page = 1; // 현재 페이지(디폴트는 1page)
//		pageRows = 8; // 한 ' 페이지' 에 몇 개의 글을 리스트? (디폴트 8개)
		int writePages = 10; // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0; // 글은 총 몇개인지?
		int totalPage = 0; // 총 몇 '페이지' 분량인지?

		// 두개의 매개변수 받아옴
		String param;
		List<BWriteDTO> list = null;

		// page 값 : 현재 몇 페이지?
		param = (String) model.getAttribute("page");
		// 만약에 여기서 page 가 잘못 들어오거나 엉뚱한게 들어오면 -> 익셉션 처리 따로 하지 않고, page 1로 가도록 할 것.
		if (param != null && param.trim().length() != 0) {

			// 정상적으로 수행되었는지 아닌지 확인해보기 위해 try-catch 로 감싸줌
			try {
				page = Integer.parseInt(param); // 파싱하는 과정에서 null 이나 0 이 나와도 -> page 1 로
			} catch (NumberFormatException e) {
				// 예외처리 하지 않음.
			}
		}

		// pageRows 값 : '한 페이지' 에 몇개의 글?
		param = (String) model.getAttribute("pageRows");
		if (param != null && param.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				// 예외처리 하지 않음.
			}
		}

		try {
			// 글 전체 개수 구하기
			IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
			totalCnt = dao.countAll(); // mapper 적용 완료
			System.out.println("전체 글 개수_ totalCnt: " + totalCnt);

			// 총 몇 페이지 분량인가?
			totalPage = (int) Math.ceil(totalCnt / (double) pageRows);
			System.out.println("총 페이지개수: " + totalPage);
			// 몇 번째 row 부터?
			int fromRow = (page - 1) * pageRows + 1; // ORACLE 은 1부터 ROWNUM 시작
			// int fromRow = (page - 1) * pageRows; // MySQL 은 0부터 ROWNUM 시작

			dao = C.sqlSession.getMapper(IWriteDAO.class);
			list = dao.selectFromRow(fromRow, pageRows); // List<BWriteDTO> 타입으로 리턴 하겠쥐..
//			dtoArr = list.toArray(new BWriteDTO[list.size()]);
			// System.out.println(dtoArr);
			if (list == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				status = "OK";
				// 얘네들의 결과(list)가 AjaxWriteList 로 넘어감
				model.addAttribute("status", status);
				model.addAttribute("message", message.toString());
				model.addAttribute("list", list);

				model.addAttribute("page", page);
				model.addAttribute("pageRows", pageRows);
				model.addAttribute("writePages", writePages);
				model.addAttribute("totalCnt", totalCnt);
				model.addAttribute("totalPage", totalPage);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			message.append("[트랜젝션 에러: " + e.getMessage() + " ]");
		} // end try

		AjaxWriteList result = new AjaxWriteList(); // AjaxWriteList 객체 생성해주고

		result.setStatus((String) model.getAttribute("status"));
		result.setMessage((String) model.getAttribute("message"));

		if (list != null) {
			result.setCount(list.size());
			result.setList(list);
		}

		// 페이징 할 때 필요한 값들
		try {
			result.setPage((Integer) model.getAttribute("page"));
			result.setTotalPage((Integer) model.getAttribute("totalPage"));
			result.setWritePages((Integer) model.getAttribute("writePages"));
			result.setPageRows((Integer) model.getAttribute("pageRows"));
			result.setTotalCnt((Integer) model.getAttribute("totalCnt"));

		} catch (Exception e) {
			// 개 무시.. /view.ajax 에선 페이징 관련 변수값들이 없다..
		}

		return result;
	}

	@RequestMapping("/writeOk.ajax")
	public AjaxWriteList writeOk(HttpServletRequest request, Model model) {
		AjaxWriteList result = new AjaxWriteList();
		int cnt = 0;

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 FAIL

		// 매개변수 받아오기
		String subject = (String) request.getParameter("subject");
		String content = (String) request.getParameter("content");
		String name = (String) request.getParameter("name");

		// 유효성 체크
		if (name == null || name.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 작성자 필수]");
		} else if (subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 글제목 필수]");
		} else {
			try {
				IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
				cnt = dao.insert(subject, content, name);
				if (cnt == 0) {
					message.append("[트랜잭션 실패: 0 insert");
				} else {
					status = "OK";// 얘가 최종적 성공
				}
			} catch (Exception e) {
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}
		} // end if

		// 이 결과를 result 라는 이름의 request 객체에 담는다.
		model.addAttribute("result", cnt);

		// 얘네들의 결과가 AjaxListCommand 로 넘어감
		model.addAttribute("status", status);
		model.addAttribute("message", message.toString());

		result.setCount((Integer) model.getAttribute("result"));

		result.setStatus((String) model.getAttribute("status"));
		result.setMessage((String) model.getAttribute("message"));

		// 페이징 할 때 필요한 값들
		try {
			result.setPage((Integer) model.getAttribute("page"));
			result.setTotalPage((Integer) model.getAttribute("totalPage"));
			result.setWritePages((Integer) model.getAttribute("writePages"));
			result.setPageRows((Integer) model.getAttribute("pageRows"));
			result.setTotalCnt((Integer) model.getAttribute("totalCnt"));

		} catch (Exception e) {
			// 개 무시.. /view.ajax 에선 페이징 관련 변수값들이 없다..
		}

		return result;
	}

	@RequestMapping("/view.ajax")
	public AjaxWriteList view(BWriteDTO dto, HttpServletRequest request, Model model) throws SQLException {
		AjaxWriteList result = new AjaxWriteList();
		List<BWriteDTO> list = null;

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

				IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class); /* 마이바티스가 만들어준 dao 가져와서 우리가 사용하는 것 */
				dao.incViewCnt(uid); // 조회수 증가
				list = dao.selectByUid(uid); // 읽기

				if (list == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}

			} catch (Exception e) {
				message.append("[예외발생:" + e.getMessage() + "]");
			} // end try
		} // end if

		model.addAttribute("list", list);
		model.addAttribute("status", status);
		model.addAttribute("message", message.toString());

		result.setStatus((String) model.getAttribute("status"));
		result.setMessage((String) model.getAttribute("message"));
		if (list != null) {
			result.setCount(list.size());
			result.setList(list);
		}

		// 페이징 할 때 필요한 값들
		try {
			result.setPage((Integer) model.getAttribute("page"));
			result.setTotalPage((Integer) model.getAttribute("totalPage"));
			result.setWritePages((Integer) model.getAttribute("writePages"));
			result.setPageRows((Integer) model.getAttribute("pageRows"));
			result.setTotalCnt((Integer) model.getAttribute("totalCnt"));

		} catch (Exception e) {
			// 개 무시.. /view.ajax 에선 페이징 관련 변수값들이 없다..
		}

		return result;
	}

}
