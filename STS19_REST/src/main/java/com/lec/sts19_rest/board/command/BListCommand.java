package com.lec.sts19_rest.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) { // controller에서 넘긴 model 바구니를 받은 것.
//		BWriteDAO dao = new BWriteDAO();
//		List<BWriteDTO> list = dao.select();
//		model.addAttribute("list", list); // model  바구니에 담는다!
		
//		DAO 객체가 
//		마이바티스가 알아서 디에오 코드 만들어준다.
		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list", dao.select());
		

	}

}
