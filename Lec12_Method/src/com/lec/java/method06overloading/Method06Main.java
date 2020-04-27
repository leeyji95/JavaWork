package com.lec.java.method06overloading;

/* Method Overloading (메소드 중복 정의)
	 같은 이름으로 메소드를 매개변수 리스트를 달리하여 중복 정의,    " 핵심 : 같은 이름 , 중복 정의 " (****************)   면접에 많이 나옵니다
	 즉, 이름이 같아도 메소드 signature 가 다르면 중복정의 가능.
	
  Method Signature 란
	   메소드 이름 + 매개변수 리스트 (parameter list)
	
	 1. 매개변수의 개수가 다르거나
	 2. 매개변수의 자료형이 다르거나
	 3. 매개변수의 순서가 다를 때
	 위 3개를 '매개변수 리스트' 라 한다
	                                    <><<<<<<<<<<<<<<<<<  타입 순서 개수!!!>>>>
    메소드의 리턴 타입만 다른 경우는 중복 정의할 수 없다!!

     메소드 오버로딩의 장점:
	동일한 동작을 하는 메소드에 대해 매개변수만 달리하여 중복정의 하면
	이 메소드를 사용하는 입장에선 여러타입의 이름을 익힐 필요가 없다. 
	
	(*******) 장점? 왜 쓰는가? 
	*			println메소드 . 우리가 이미 사용하고 있었어.   여러가지 타입을 담을 수 있음
	*			같은 이름으로  작동만 다르게 함. 
	*

 */

public class Method06Main {

	public static void main(String[] args) {
		System.out.println("Method Overloading (메소드 중복 정의)");
		
		sayHello();
		sayHello("남윤주");
		sayHello(20);
		sayHello("이승환", 23);
		sayHello(27, "김광진");
		//sayHello(100, 100);
		
		byte b = 100;
		sayHello(b); // 자동 형변환  근데 short, int 중 누가 호출되는가?   ( 자동형변환 순서)(***********)
		
		
		// 메소드 오버로딩 장점
		System.out.println(10);
		System.out.println(3.14);
		System.out.println("Hello");	
		System.out.println(new int[4]);
		// 프로그램으로 하여금  동일한 동작을 수행할 수 있도록. 사용 개발자 입장에서 여러 이름을 기억할 필요 없음.(**********)
		// 스캐너처럼 일일히 따로따로 만들지 않아도 된다.
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// 1
	public static void sayHello() {   // 메소드 이름 sayHello,  매개변수 리스트 없음
		System.out.println("sayHello() 호출");
		System.out.println("안녕하세요");
	}
	
	// 리턴타입 다르다고 오버로딩 안된다
//	public static int sayHello() {
//	}                                 	
	
	
	// 2
	public static void sayHello(String name) {
		System.out.println("sayHello(String) 호출");
		System.out.println("Hi ~");
		System.out.println("제 이름은 " + name + " 입니다~");
	}
	
	
	// 3-1
	public static void sayHello(int age) {
		System.out.println("sayHello(int) 호출");
		System.out.println("My age is " + age);
	}
	
	
	// 3-2
	public static void sayHello(short age) {
		System.out.println("sayHello(int) 호출");
		System.out.println("My age is " + age);
	}
	
	
	
	// 4
	public static void sayHello(String name, int age) {
		System.out.println("sayHello(String, int) 호출");
		System.out.println("헬로~");
		System.out.println("이름: " + name + ", 나이: " + age);
	}
	
	// 5
	public static void sayHello(int age, String name) {
		System.out.println("sayHello(int, String) 호출");
		System.out.println("헬로~");
		System.out.println("이름: " + name + ", 나이: " + age);
	}
	
		
} // end class









