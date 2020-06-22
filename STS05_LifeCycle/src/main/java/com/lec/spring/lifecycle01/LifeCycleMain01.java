package com.lec.spring.lifecycle01;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Score;

public class LifeCycleMain01 {

	public static void main(String[] args) throws Exception {
		System.out.println("Main 시작");

		// new  GenericXmlApplicationContext(설정파일) 
		
		// 먼저 컨테이너 '생성'
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 생성
		System.out.println("컨테이너 생성완료\n");
		
		// 나중에 설정을 load 할 수 있다.  설정 로딩함
		 ctx.load("classpath:appCtx01_A.xml"); 
		 System.out.println("설정 load 완료");
		 
		 
		 // 로딩 된 설정으로 빈을 만든다. 
		 ctx.refresh();  // 얘를 하니까 컨테이너 안에 진짜 bean 이 생성되었다 .   <--- refresh() 해야 제대로 설정(빈 생성)이 완료된다. 
		 System.out.println("컨테이너 refresh 완료");
		 
		 Score score1 = ctx.getBean("score1", Score.class);
		 System.out.println(score1);
		 
		 
		ctx.close(); // 종료
		System.out.println("Main 종료");
	} // end main
} // end class
