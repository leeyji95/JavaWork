package com.lec.sts13_jdbc.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) { // controller에서 넘긴 model 바구니를 받은 것.
		BWriteDAO dao = new BWriteDAO();
		List<BWriteDTO> list = dao.select();
		model.addAttribute("list", list); // model  바구니에 담는다!

	}

}
