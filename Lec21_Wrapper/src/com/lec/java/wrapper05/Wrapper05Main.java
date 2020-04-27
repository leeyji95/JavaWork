package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object[] obj = new Object[5];
		obj[0] = new Wrapper05Main(); // 다형성에 의해 가능하죠
		obj[1] = new A();
		obj[2] = new A2();
		obj[3] = new B();
		obj[4] = 123; // Object 가 primitive type 도 받을 수 있다?!
					// 이유: Auto-Boxing + Polymorphism(다형성)	
					// Object < -- Integer <-- int
		// 오브젝트 타입은  프리미티브 타입도 담을 수도 있다. 왜? 바로 래퍼클래스 오토 박싱에 의해..
		
		for(Object e : obj) {
			System.out.println(e);
			// Wrapper 는 자동적으로 Auto-unboxing 발생
		}
		
		System.out.println();
//		int num = obj[4] * 3; // 에러..-> object 와 곱셈으로 인식함.
//		int num = (Integer)obj[4] * 3; // 그래서 강제 형변환 해야 한다.
				
		// 실타입이 Object 이면
		// auto-unboxing 등이 필요한 연산식 에선 '형변환' 해주어야 동작한다.
		// int num = obj[4] * 3;  // 에러!
		int num = (Integer)obj[4] * 3;
		System.out.println(num);

		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO
	
} // end class

class A{}
class A2 extends A{}
class B{}









