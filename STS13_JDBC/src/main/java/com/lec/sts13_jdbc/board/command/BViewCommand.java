package com.lec.sts13_jdbc.board.command;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BWriteDAO dao = new BWriteDAO();
		BWriteDTO dto = dao.readByUid(uid);
		model.addAttribute("view", dto); // model  바구니에 담는다!
	}

}
