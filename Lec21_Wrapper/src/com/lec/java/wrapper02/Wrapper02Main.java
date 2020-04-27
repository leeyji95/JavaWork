package com.lec.java.wrapper02;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 = 10; // Integer.valueOf(10); <-- auto-boxing    프리미티브를 인티저쩜 밸류오브에 담는것. 알아서 밸류오브상자에 담아서 레러런싱한다. 그걸 오토박싱이라고 한다. 
		Integer num2 = 20; // 마치 프리미티와 비슷하게 동작할 수있게 Wrapper 클래스 제공함. 
		System.out.println(num1 + num2); // 이렇게 시키지 않아도 자동으로 상자에서 꺼내서 프리미티 타입으로 바꿔서 연산한다. -> 오토 언박싱!
		System.out.println(num1.intValue() + num2.intValue());  // 이렇게 명시안해도 바로 윗줄처럼 출력해도 자동으로 이렇게 동작한다. 
		
		
		Integer num3 = num1 + num2;
		// 아래와 같이 동작한다
		Integer num30 = Integer.valueOf(num1.intValue() + num2.intValue());  // <--- 내부적으로 이렇게 동작한다. 이게 바로 래퍼클래스가 가진 특징 중 하나!
		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		Integer num4 = 100;  // Integer.valueOf(100)
		int n4 = num4; // num4.intValue()

		
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		// TODO
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		
		Long num100 = Long.valueOf(1000000000000000L);
		Long num101 = 100000000000000000L;
		
		Double num200 = 3.14;  // Double.valueOf(3.14)
		
		System.out.println(num1.intValue());
		System.out.println(num1.doubleValue());  // unboxing 은 내가 원하는 타입으로 가능하다
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















