package com.lec.sts13_jdbc.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) { // model 엔 uid가 담겨져 있음.
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();  // model 안에 있는 어트리뷰트 애들 어차피 이름 밸류 쌍으로 -> map으로 변환 가능하다
		int uid = (Integer)(map.get("uid"));
		BWriteDAO dao = new BWriteDAO();
		List<BWriteDTO> viewList = dao.readByUid(uid);
		
		model.addAttribute("view", viewList); // model  바구니에 담는다!
	}

}