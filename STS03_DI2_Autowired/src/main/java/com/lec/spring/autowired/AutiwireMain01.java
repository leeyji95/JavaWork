package com.lec.spring.autowired;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AutiwireMain01 {

	public static void main(String[] args) {
		System.out.println("Autowired 자동주입");
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:autowiredCtx1.xml");
		System.out.println("컨테이너 생성\n");
	
		System.out.println(ctx.getBean("regService"));
		System.out.println(ctx.getBean("readService"));  // 컨테이너가 빈객체가 생성할 때 자동 주입되는데, 이때 타입이 일치하는 애는 자동주입된다. 
		System.out.println(ctx.getBean("updateService"));
		System.out.println(ctx.getBean("deleteService"));
		
		ctx.close();
		System.out.println("종료");
	}  // end main
} // end class
