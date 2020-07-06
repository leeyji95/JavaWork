package com.lec.sts18_security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		// auth 객체가 핸들러에 전달이 되며, auth 객체에 담겨져 전달이 된다. 
		System.out.println("access Denied : " + auth);
		model.addAttribute("msg", "접근권한 거부");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error : " + error);  // 로그인 실패했을 때 담기는 에러 메시지임
		System.out.println("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Accout(계정 다시 확인하라우");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "LogOut!!!!!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("custom logout");
	}
	
	@PostMapping("/customLogout")
	public void logoutPOST() {
		System.out.println("post custom logout");
	}
}
