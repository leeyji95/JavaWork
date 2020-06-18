package com.lec.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

// 여기서는 스프링 컨테이너에 생성된 객체를 사용하는 메인을 만들어 보자 
/*
	Dependency Injection (DI, 의존주입)
	필요한 객체는 누가 만들어 사용하나?
	
	방법2 : 외부에서 만들어 주입 (injection)
 	스프링 특징 의존주입 (Dependenty Injection) 사용
 	즉 '외부' 에서 만들어 놓은 것을 가져옴.
*/

public class DIMain02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// 스프링 설정파일 resource 명시
		String configLocation = "classpath:appCtx.xml";
		
		// ApplicationContext 객체를 만드는 시점에서 bean 객체가 생성된다. 
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation);
		System.out.println("Application Context 컨테이너 생성 완료\n");
		
		// 외부에서 만들어진 객체 주입 ( injection)
		MessageBean msg = ctx.getBean("messageBean", MessageBean.class);  // xml 에서 만들어 놓은 MessageBean 이름(id) 과 class 가지고옴.
										
		msg.sayHello();
		
		ctx.close(); //Application Context 컨테이너도 메모리 잡아먹는 자원이므로 반드시 close()!
		System.out.println("Main 종료");
		
		ApplicationContext ctx2;
		
		
	} // end main
} // end class
