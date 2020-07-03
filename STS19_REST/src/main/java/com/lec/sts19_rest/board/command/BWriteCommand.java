package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();  // model 안에 있는 어트리뷰트 애들 어차피 이름 밸류 쌍으로 -> map으로 변환 가능하다
		BWriteDTO dto = (BWriteDTO)map.get("dto");
		
//		BWriteDAO dao = new BWriteDAO();
//		int result = dao.insert(dto);
//		model.addAttribute("result", result);
//		모델에서 디티오 꺼내서 인서트에 보냄
//		인서트한 결과를 다시 모델에 담는다.
		
		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class); /* 마이바티스가 만들어준 dao 가져와서 우리가 사용하는 것 */
		model.addAttribute("result", dao.insert(dto));
		System.out.println("생성된 uid : " + dto.getUid());
//		model.addAttribute("result",
//				 dao.insert(dto.getSubject(), dto.getContent(), dto.getName()));
		
	}

}
