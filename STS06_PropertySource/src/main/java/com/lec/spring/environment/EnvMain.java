package com.lec.spring.environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvMain {

	public static void main(String[] args) {
		System.out.println("Main 시작");

		// Context -> Environment -> PropertySources
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment(); // environment 타입으로 리턴
		// 왜 이 메소드를 썻는가? ConfigurableApplicationContext 소속 메소드이기떄문에, 얘를 가지고
		// getEnvironment() 를 끌고 들어와야 한ㄷ
		MutablePropertySources propertySources = env.getPropertySources();

		// PropertySources 에 PropertySource 추가
		// addLast() : 현재 소스들 목록에서 맨 끝에 추가 하겠다.
		try {
			// propertySource 하나를 생성하여 PropertySources 에 추가 : addLast() <-- 끝에 추가
			propertySources.addLast(new ResourcePropertySource("classpath:admin.auth")); // file 로부터 읽어와서 추가해준다.
			// IOException 잡아주고,

			// 이제 Environment 를 통해 원하는 property 에 접근 가능하다.
			// 굳이 '어느 PropertySource' 의 '어느 property' 를 지정할 필요 없다.
			// '어느 property' 에 대한 것만 요청하면
			// PropertySources 에 소속된 모~ 든 PropertySource 들을 다 스캔해서 찾아낸다!!
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));

		} catch (IOException e) {
			e.printStackTrace();
		} // end try

//		ctx.load("classpath:appCtx1.xml"); <-- 안된다!
		// 에러 -> load() 는 GenericXmlApplicationContext 소속 메소드이므임
		// ctx 는 ConfigurableApplicationContext 타입이므로 형변환 해줘야 한다.

		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		gCtx.load("classpath:appCtx1.xml"); // 설정 로딩
		gCtx.refresh(); // 빈 생성
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);

		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());

		gCtx.close();

		System.out.println("Main 종료");
	} // end main

} // end clas
