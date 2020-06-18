package com.lec.spring.di01;

import com.lec.spring.MessageBean;
import com.lec.spring.MessageEng;

public class DIMain01 {

/*
 * Dependency Injection (DI, 의존주입)
 * 필요한 객체를 '누가' 만들어 사용하나?    ---> 현재 "메인"이  사용 
 * 
 * 방법1 : 직접 생성(new) 하여 사용
 * 
 */

	public static void main(String[] args) {
		System.out.println("Main시작");
		MessageBean msg = null;
		
		
		// 필요한 MessageBean 객체를
//		msg = new MessageKor(); // 직접 만들어(new) 사용 
//		msg.sayHello();
		
		// 의존하고 있던 객체의 버젼 등이 없그레이드 되면 (설계변경이 되면 )
		// 의존하고 있던 객체를 재컴파일 해야 한다(수정해야 한다!!)
		msg = new MessageEng();
		msg.sayHello();
		
		
//		메인이 사용하는 경우 의존 객체가 바뀌면 메인에 와서 계속 수정해줘야 한다. 
//		이렇게 되면 sw 생산성 떨어짐.
//		내가 직접 만들어 사용하는 것이 아니라,  외부에서 만들어서 사용한다. 즉 외부에서 만들어서 꽂아준다.
//		이걸 스프링이 제공한다. 
		System.out.println("Main 종료");
	} // end main

} // end class


