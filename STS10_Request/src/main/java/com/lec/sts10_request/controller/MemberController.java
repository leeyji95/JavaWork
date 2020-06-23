package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member") // -> /member로 시작하는 request만 시작한다
public class MemberController {
	
	@RequestMapping(value="/save") // -> /member/save
	public String memberSave() {
		return "member/save";
	}
	
	@RequestMapping(value="/load")
	public String memberLoad() {
		return "member/load";
	}
	
//	@RequestMapping(value="/search")
//	public String memberSearch() {
//		return "member/search";
//	}
	
}
