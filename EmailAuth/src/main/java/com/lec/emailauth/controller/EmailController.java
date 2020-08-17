package com.lec.emailauth.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.emailauth.beans.EmailDTO;
import com.lec.emailauth.common.C;
import com.lec.emailauth.dao.EmailDAO;

@Controller
@RequestMapping("/user")
public class EmailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	private SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	public EmailController() {
		super();
		System.out.println("EmailController() 생성");
	}

	@GetMapping("/emailreg")
	public void EmailInput() {
		System.out.println("--------- 이메일입력 페이지  진입 --------- ");
	}
	
	@PostMapping("/auth")
	public String EmailAuth(EmailDTO dto, HttpServletRequest request	) {
		
		EmailDAO dao = C.sqlSession.getMapper(EmailDAO.class);
		
		dto.setEmail((String)request.getParameter("user_email"));
		
		// 이메일 insert
		dao.EmailInsert(dto.getEmail());
		
		// 인증메일 보내기 
		mailSendwithUserKey(dto.getEmail(), request);
		
		return "redirect:/";
	}

	// 이메일 난수 만드는 메서드
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}

	// 난수를 이용한 키 생성
	private boolean lowerCheck;
	private int size;

	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}
	
	public void mailSendwithUserKey(String email, HttpServletRequest request) {

		EmailDAO dao = C.sqlSession.getMapper(EmailDAO.class);
		String key = getKey(false, 20);
		dao.Key(email, key); // 인증키 저장
		int uid = dao.SelectUid(email); // 해당 이메일로부터 uid 뽑기 

		MimeMessage mail = javaMailSender.createMimeMessage();
	
		String htmlStr = "<h2>안녕하세요. java 메일 인증 test 입니다. </h2><br>" 
				+ "<p>인증하기 버튼을 누르시면 회원가입 완료됩니다." 
				+ "<a href='http://localhost:8000" + request.getContextPath()
				+ "/user/keyalter?email_uid=" + uid + "&user_key=" + key + "'>인증하기</a></p>";
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			helper.setSubject("[본인인증]메일입니다.");
			helper.setText(htmlStr, true);
			helper.setFrom("");
			helper.setTo("");

			javaMailSender.send(mail);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

		
	@GetMapping("/keyalter")
	public void keyalter(@RequestParam("email_uid") int uid, @RequestParam("user_key") String key) {
		
		EmailDAO dao = C.sqlSession.getMapper(EmailDAO.class);
		
		dao.UpdateKey(uid, key); // 인증키 값을 -> 'Y' 로 update
	}
	
}
