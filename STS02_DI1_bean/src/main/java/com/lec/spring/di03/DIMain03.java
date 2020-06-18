package com.lec.spring.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain03 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// ApplicationContext (컨테이너) 생성, (빈(bean) 도 자동 생성)
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		System.out.println("컨테이너 생성\n");
		
		Score score = null;
		
		score = ctx.getBean("myScore1", Score.class); //  myscore1 이 Score 타입으로 변환된다?
		System.out.println(score);
		
		
		// getBean(빈 id) 는 Object 리턴. 형변환해서 사용 가능하다.
		score = (Score)ctx.getBean("myScore2");  // -> 매개변수 하나이면  Object 타입으로 변환된다. -> 그러므로 Score 타입으로 강제 형변환 해준다.  
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore3");    
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore4");    
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore5");    
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore6");    
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore7");    
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore8");    
		System.out.println(score);
		
		System.out.println("생성된 빈의 개수: " + ctx.getBeanDefinitionCount());
		for(int i = 1; i <= ctx.getBeanDefinitionCount(); i++) {
			System.out.println(ctx.getBean("myScore" + i));
		}
		
		System.out.println("Main 종료");
	} // end main()
} // end class