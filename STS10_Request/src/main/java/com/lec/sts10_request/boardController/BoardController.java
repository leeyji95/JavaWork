package com.lec.sts10_request.boardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@RequestMapping(value="/list")
	public String boardList() {
		return "board/list_board";
	}
	
	@RequestMapping(value="/write")
	public String boardWrite() {
		return "board/write_board";
	}
	
	@RequestMapping(value="/view")
	public String boardView() {
		return "board/view_board";
	}
	
	@RequestMapping(value="/update")
	public String boardUpdate() {
		return "board/update_board";
	}
	
	@RequestMapping(value="/delete")
	public String boardDelete() {
		return "board/delete_board";
	}
	
}
