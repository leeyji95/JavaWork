package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.beans.IWriteDAO;

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
		
		//model.addAttribute("result",
		//		 dao.insert(dto.getSubject(), dto.getContent(), dto.getName()));
		
// 		핵심 ★★ insert 시 자동생성되는 키값만 가져오기 위해  사용하는 것임 !!  		
//		매퍼파일에 
//		keyProperty="uid" useGeneratedKeys="true" keyColumn="wr_uid" 명시하면 
//		useGeneratedKeys="true" : 자동 생성된 키값  
//		generated 된 key 값을 ""dto"" 에 받아올 수 있다!  → 강조 : 어디에?? dto 에!!! 가륏?
		System.out.println("생성된 uid 는  " + dto.getUid()); 
		// 매퍼파일에 dto 와 필드명이 설정되므로 자동생성된 uid 값이 dto 에 담겨온다. ! 
	}

}
