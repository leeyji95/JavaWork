package com.lec.sts11_param;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.beans.WriteDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// parameter 추출
	// handler 메소드에서도 서블리셍서 보았던 HttpServletRequest, HttpServletResponse 매개변수 가능!! 
	
	@RequestMapping(value="/member/delete") // -> /member/delete?id=34
	// public String delMember( Model model, HttpServletRequest request) {
	public String delMember(HttpServletRequest request, Model model) {  // <--- 매개변수 순서 무관! (앞으로 스프링하면서 되게 많이 사용한다. ) 스프링 컨테이너 구조때문에 오토와이어드 시 자동 주입되는 건 타입 따라가는 거지, 순서는 아무 상관없다.
		String id = request.getParameter("id");
		model.addAttribute("mbId", id);
		
		return "member/delete";
	}
	
	@RequestMapping(value = "/member/regOk", method = RequestMethod.POST)  // --> Defalut : GET  
	public String regOkMember() {
		System.out.println("/member/regOk : POST");
		return "member/regOk";
	}
	
	
	@RequestMapping(value = "/member/regOk", method = RequestMethod.GET)  // --> Defalut : GET  
	public String regOkMember(Model model) {
		System.out.println("/member/regOk : GET");
		return "member/regOk";
	}
	
	@RequestMapping(value = "/member/regist")
	public String registMember() {
		
		return "member/regist";
	}
	 
	
	// GET/POST 둘다 받는 handler
	@RequestMapping(value = "/member/regOk2", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public String regOkMember2() {
		return "member/regOk";
	}
	
	
	// handler 에 
	// request parameter 의 name 값과 '같은 이름의 매개변수' 가 있으면
	// 바로 그 매개변수가 request parameter 값을 받아온다.
	
	//@RequestMapping("/member/find")
	//public String findMember(String id, String name, Model model) { // param 이름과 매개변수 이름 같으면 바로 그냥 꽂힌다. ~?id=aaa&name=bbb 하면 그대로 받아온다.  
	//public String findMember( Model model, String id, String name) { // 순서 무관
	
	// 숫자 타입은 parsing 하여 처리한다(받는다). --> 만약 숫자가 아닌 다른 문자가 입력되면 400 에러(잘못된 요청) 뜬다. 
	// 동일한 이름으로 여러개의 파라미터가 요청된다면 첫번째 parameter 가 선택된다. 
	//public String findMember( Model model, int id, String name) {  // 정수타입으로 매개변수 주면, 바로 파싱하여 받는다. 
	//public String findMember( Model model, String name, double id) {
	
//	public String findMember( Model model, String [] name, int [] id) {
//		model.addAttribute("id", Arrays.toString(id));  
//		model.addAttribute("name", Arrays.toString(name));
//		
//		return "member/find";
//	}
	
	
	//@RequestParam 사용
	@RequestMapping("/member/find")
	public String findMember(Model model, 
			@RequestParam("id") String userid,  // name "id" parameter 값을 받아서 name 에 꽂아넣는다. 
			@RequestParam("name") String username) {
		model.addAttribute("id", userid);  
		model.addAttribute("name", username);
	
		return "member/find";
	}
	
	
	//-------------------------------------------------------------------------------
	// 커맨드 객체 (Command Object) 사용
	
	@RequestMapping("/board/write")
	public String writeBoard() {
		return "board/write";
	}
	
	// 기존방식으로 구현하기 
	// 매 parameter 들을 매개변수화? 해야한다. 힘들다. 
	@RequestMapping(value = "/board/writeOk", method = RequestMethod.POST)
//	public String writeOkBoard(
//			Model model,
//			@RequestParam("name") String name,
//			@RequestParam("subject") String subject,
//			@RequestParam("content") String content
//			) {
//		WriteDTO dto = new WriteDTO();
//		dto.setName(name);
//		dto.setSubject(subject);
//		dto.setContent(content);
//		
//		model.addAttribute("dto", dto);
//		
//		return "board/writeOk";
//	}
	
//	public String writeOkBoard(WriteDTO dto) {  // 매개변수가 dto 하나만 주었다. 
		// model 에 뭘 담은 것이 없어... 근데 param 들이 넘어옴. 
//		setter 들이 동작해서 dto에 세팅된다. 이게 컨테이너에 있고, 이게 뷰까지 간다. 
//		jsp 에서 writeDTO 객체로 끌고 들어온다.
// 		
//		여러개의 파람을 담는 객체가 command 객체이다.
//		System.out.println(dto);
//		return "board/writeOk";
//	}
	
	// 커맨드 객체에 attribute id 변경
	public String writeOkBoard(
			@ModelAttribute("DTO") WriteDTO dto) {
		return "board/writeOk";
		}
	
	
	// @PathVariable 방식 (서울시 공공데이터 가지고 놀때)
	@RequestMapping("/board/writePath/{name}/{subject}/{content}")
	public String writePathBoard(Model model,
			@PathVariable String name,
			@PathVariable String subject,
			@PathVariable String content
			) {
		model.addAttribute("name", name);
		model.addAttribute("subject", subject);
		model.addAttribute("content", content);
		return "board/writepath";
	}
	
	@RequestMapping("/member/ageCheck")
	public String chkAge(int age,
			RedirectAttributes redirectAttr) { //리다이렉트에서 파라메타 넘겨주는 방법 -> redirectAttribute 사용한 방법
		redirectAttr.addAttribute("age", age); // age라는 이름으로 age값을 받아서 redirect 페이지로 attribute 넘긴다는 의미
		
		if(age < 19) {
			return "redirect:/member/underAge";
		} else {
			return "redirect:/member/adult";
		}
	}
	
	@RequestMapping("/member/underAge")
	public String pageUnderAge(
			@RequestParam("age") int age, Model model
			) {
		model.addAttribute("age", age);
		return "member/ageUnder";
	}
	
	@RequestMapping("/member/adult")
	public String pageAdult(
			@RequestParam("age") int age, Model model
			) {
		model.addAttribute("age", age);
		return "member/ageAdult";
	}
	
	
	@RequestMapping(value="/common") // /common 으로 요청이 오면
	public String cccmmm() {		 // cccmmm() 핸들러가 수행되고
		return "comn"; // → /WEB-INF/views/comn.jsp 를 리턴하여 response 되게 한다.
	}
	
	
}
