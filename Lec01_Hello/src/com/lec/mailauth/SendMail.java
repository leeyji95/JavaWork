package com.lec.mailauth;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void main(String[] args) {
		System.out.println("-----------메인 시작-----------");

		String host = "smtp.naver.com";
		String user = "";
		String password = "";
		
		// SMTP 서버 정보 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		session.setDebug(true); //for debug
		   
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(""));
			
			message.setSubject("Java 로 보내는 이메일 Test 입니다.");
			message.setText("이메일 인증이 정상적으로 인증되었습니다!!!!!!");
			
			Transport.send(message);
			System.out.println("이메일 보내기 성공!");
			
		} catch(MessagingException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------메인 종료-----------");
	} // end main()

} // end class
