package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member") // -> /member 로 시작하는 request 만 처리한다. 
public class MemberController {
	@RequestMapping(value="/save") // -> /member + /save 합쳐져서 => /member/save  요청들어오면 수행할 것
	public String saveMember() {
		return "member/save";
	}
	
	@RequestMapping(value="/load") // -> /member/load 
	public String loadMember() { 
		return "member/load";
	}
	
//	새로 추가하면 반드시 서버 재시작 한다.
	
	
	
//	@RequestMapping(value="/search") // -> /member/search ( 중복! )
//	// 과연 중복된 컨트롤러는 어떻게 동작할 것인가?
//	public String searchMember() {
//		return "member/search";
//	}
//	 ==> 서버 다시 리로딩 하는 도중에 에러 뜬다. 
	
}
