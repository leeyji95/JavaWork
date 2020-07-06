package com.lec.sts19_spa.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts19_spa.ajaxcommand.DeleteCommand;
import com.lec.sts19_spa.ajaxcommand.ListCommand;
import com.lec.sts19_spa.ajaxcommand.UpdateOkCommand;
import com.lec.sts19_spa.ajaxcommand.ViewCommand;
import com.lec.sts19_spa.ajaxcommand.WriteCommand;
import com.lec.sts19_spa.board.beans.AjaxWriteList;
import com.lec.sts19_spa.board.beans.AjaxWriteResult;
import com.lec.sts19_spa.board.beans.BWriteDTO;

@Controller
@RequestMapping("/board/*.ajax")
public class AjaxController {
	
	@RequestMapping("/board/list.ajax")
	public AjaxWriteList list(HttpServletRequest request, HttpServletResponse response) {
		new ListCommand().execute(request, response);
		return buildList(request);
	}
	@RequestMapping("/board/view.ajax")
	public AjaxWriteList view(HttpServletRequest request, HttpServletResponse response) {
		new ViewCommand().execute(request, response);
		return buildList(request);
	}
	@RequestMapping("/board/writeOk.ajax")
	public AjaxWriteResult writeOk(HttpServletRequest request, HttpServletResponse response) {
		new WriteCommand().execute(request, response);
		return buildResult(request);
	}
	@RequestMapping(value = "/board/updateOk.ajax", method=RequestMethod.POST)
	public AjaxWriteResult updateOk(HttpServletRequest request, HttpServletResponse response) {
		new UpdateOkCommand().execute(request, response);
		return buildResult(request);
	}
	@RequestMapping(value = "/board/deleteOk.ajax", method=RequestMethod.POST)
	public AjaxWriteResult deleteOk(HttpServletRequest request, HttpServletResponse response) {
		new DeleteCommand().execute(request, response);
		return buildResult(request);
	}

	// response 할 메소드
	public AjaxWriteResult buildResult(HttpServletRequest request) {
		AjaxWriteResult result = new AjaxWriteResult();

		result.setStatus((String) request.getAttribute("status"));
		result.setMessage((String) request.getAttribute("message"));
		result.setCount((Integer) request.getAttribute("result"));

		return result;
	} // end execute()
	
	@SuppressWarnings("unchecked") // 노란색 경고 지워짐
	public AjaxWriteList buildList(HttpServletRequest request) {
		List<BWriteDTO> list = (List<BWriteDTO>) request.getAttribute("list");

		AjaxWriteList result = new AjaxWriteList();
		result.setStatus((String) request.getAttribute("status"));
		result.setMessage((String) request.getAttribute("message"));

		if (list != null) {
			result.setCount(list.size());
			result.setList(list);
		}

		// 페이징 할때만 필요한 것들.
		try {
			result.setPage((Integer) request.getAttribute("page"));
			result.setTotalPage((Integer) request.getAttribute("totalPage"));
			result.setWritePages((Integer) request.getAttribute("writePages"));
			result.setPageRows((Integer) request.getAttribute("pageRows"));
			result.setTotalCnt((Integer) request.getAttribute("totalCnt"));
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return result;
	} // end buildList()

}
