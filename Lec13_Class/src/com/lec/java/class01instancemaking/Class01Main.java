package com.lec.java.class01instancemaking;

/*
 * 객체지향은 유지보수에 용이함. 
 * 유지보수를 생각하고 설계
 * 
 * 객체지향언어 기술, 
 * 처음부터 설계를 잘 만들 필요가 있음
 * 
 * ~쩜~쩜. 명사 '의'  -> 객체 쩜
 * 
 * 특성(객체) 과 동작
 *  
 *  오버로딩: 메소드 시그니처가 다른 동일한 이름의 메소드를 중복 정의하는 것.
 *  
 */

// ----------------------------------------------------------------------------------------------------------------
/*
 	클래스 정의 및 사용
 	
 	우리가 만든 클래스를 사용하려면,
	그 클래스의 '인스턴스(실체 instance)'를 생성해야 함.
	
	구문
		클래스이름 변수이름 = new 생성자();
		생성자(): 클래스의 이름과 동일, 클래스의 멤버변수들을 초기화
		
 	new 로 생성하는 instance 들은
 	지역변수와는 달리 인스턴스가 생성될 때 (자동으로) 초기화가 된다.
 	특별히 초기화를 할 값들이 지정되어 있지 않을 때는
 	각 변수 타입의 기본값(디폴트 값)으로 초기화가 됨
 		boolean -> false, 숫자타입(int, double, ...) -> 0
 		String, 참조 타입(클래스) -> null
 	
 	지역변수: 메소드 안에서 선언된 변수
 	지역변수는 사용하기 전에 반드시 초기화를 해줘야 함.
 */
public class Class01Main {

	public static void main(String[] args) {
		System.out.println("클래스 생성 & 사용");
		
		MyTV tv1;   // tv1 타입은? MyTV 타입
		tv1 = new MyTV(); // MyTV 인스턴스 생성;
		tv1.displayStatus();   
		
		// TV 켜기
		tv1.powerOnOff();  
		
		// 볼륨조정
		tv1.volumeUp();
		tv1.volumeUp();

		// 채널조정
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
	
		tv1.displayStatus();
		
		/*
//		 private 은 자기 클래스안에서만 사용 가능. public 은 모두 사용 가능.
//		 일반적으로
//		 멤버변수는 private 으로 설정하여 
//		 외부클래스에서 아래와 같이
//		 직접 사용하는 것을 금하게 설계함.
//		tv1.isPowerOn = false;
//		tv1.volume = 32;   //  남의 집 클래스  
//		tv1.channel = 100;
		 */
		
		tv1.displayStatus();
		
		System.out.println();
		MyTV tv2 = new MyTV(); 
		tv2.powerOnOff();
		tv2.channelUp();
		tv2.volumeUp();
		tv2.displayStatus();
		
		System.out.println();
		System.out.println(tv1);  // 인스턴스 주소출력 : com.lec.java.Class01.MyTV.@~~.
		System.out.println(tv2);
		
		
		System.out.println();
		tv1 = tv2;        // 어떻게 될까?
						 // 원래 tv1 이 레퍼런싱 하던 인스턴스는 Garbage Collector 에 의해 소멸된다. (GC된다. 표현)
						// 자바에서는 각각 레퍼런스 타입이므로, 주소값의 복사 발생. 
		tv1.displayStatus();
		tv1.powerOnOff();
		tv2.displayStatus();  // tv1 과 tv2 는 같은 인스턴스를 레퍼런싱 하고 있다. !!!!!@@!!!@!@ 
		
		System.out.println(tv1);
		System.out.println(tv2);
		
		/*
		 * heap 에서 자바의 가비지 컬렉터가 레퍼런스가 끊긴 인스턴스를 지운다.  이제 끊긴 인스턴스는 쓰레기이므로! 
		 * 가비지 컬렉터 -->  자바를 특징 짓는 중요한 개념
		 * 
		 *  그래서 메모리를 머릿속으로 그릴 줄 알아야함. 
		 *  
		 *  당연히 프로그래머라면 내가 만든 메모리가 언제 어디에 생기고 없어지는지 알아야함.
		 */
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class















