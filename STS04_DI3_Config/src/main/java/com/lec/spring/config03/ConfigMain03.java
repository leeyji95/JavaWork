package com.lec.spring.config03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConfigMain03 {

	public static void main(String[] args) {
		// XML 설정으로부터 생성(XML 안에 Java 설정 포함)
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx03.xml");
		System.out.println("-- ctx 생성 --");
		
		// Java 에서 설정
		System.out.println(ctx.getBean("score1"));
		
		// XML 에서 설정 
		System.out.println(ctx.getBean("score2"));
		
		
		
		
		ctx.close();
	}

}
