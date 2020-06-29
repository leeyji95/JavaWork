package com.lec.sts13_jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.sts13_jdbc.board.C;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;
import com.lec.sts13_jdbc.board.command.BCommand;
import com.lec.sts13_jdbc.board.command.BListCommand;
import com.lec.sts13_jdbc.board.command.BViewCommand;
import com.lec.sts13_jdbc.board.command.BWriteCommand;

@Controller
@RequestMapping("/board")
public class BoardController {
// 컨트롤러는 서버가 가동될 때 생성되며, 어디에? 스프링 컨테이너에 생성이 된다 .
	
	private BCommand command;
	private JdbcTemplate template;
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}
	
	
	@Autowired  // 스프링컨테이너에 요 객체(빈)가 생성되어 있다면 -> 자동으로 알아서 꽂힌다.  
	public void setTemplate(JdbcTemplate template) {
		System.out.println("setTemplate() 호출");
		this.template = template;
		C.template = template;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) { // 빈바구니 model 을 
		command = new BListCommand();
		command.execute(model); // execute에 넘겼고, 
		return "board/list"; 
	}
	
	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	}
	
	@RequestMapping(value="/writeOk.do", method = RequestMethod.POST)
	public String writeOk(BWriteDTO dto, Model model) { /* Command 객체인 BWriteDTO 에 한번에 담겨서온다 */
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}
	
	@RequestMapping(value="/view.do", method = RequestMethod.POST)
	public String view(BWriteDTO dto, Model model) {
		model.addAttribute("view", dto);
		new BViewCommand().execute(model);
		return "board/view";
	}
}
