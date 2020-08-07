package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) { // model 엔 uid가 담겨져 있음.
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();  // model 안에 있는 어트리뷰트 애들 어차피 이름 밸류 쌍으로 -> map으로 변환 가능하다
		int uid = (Integer)(map.get("uid"));
//		BWriteDAO dao = new BWriteDAO();
//		List<BWriteDTO> viewList = dao.readByUid(uid);
//		
//		model.addAttribute("view", viewList); // model  바구니에 담는다!
		
		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class); /* 마이바티스가 만들어준 dao 가져와서 우리가 사용하는 것 */
		//model.addAttribute("result", dao.insert(dto));
		dao.incViewCnt(uid);
		model.addAttribute("view", dao.selectByUid(uid));
		
		
		
		// 만약에  BWriteDTO dto 타입으로 받았다면,
		// Arrays.asList(new String[]{"aaa","bbb"})
		// Arrays.asList("aaa", "bbb")  <- 알아서 내부적으로 배열을 만들어서 List 로 만들어 준다. 알아서 타입도. 
		
		// 강사님 하신 방법
		// BWriteDTO dto = dao.readByUid(uid);
		// model.addAttribute("list", Arrays.asList(dto));
		
		
	}

}
