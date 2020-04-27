package com.lec.java.if01;
/*
 * 프로그램의 흐름을 바꾸는 것을 제어문이라고 한다.
 *
 */
/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {   // -> boolean 값
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;
		if(num < 0) {
			System.out.println("음수입니다");
		}
		
		if(num > 0) {
			System.out.println(num + " 은 양수입니다");
		} else {
			System.out.println(num + " 은 양수가 아닙니다");
		}
		
		System.out.println();
		
		// 수행문장이 하나뿐이면 굳이 {..}  블럭 안 잡아도 된다. 
		if(num < 0) 
			System.out.println(num + " -> 음수");
		else
			System.out.println(num + " ->  0 혹은 양수");
		
		
		// 주어진 숫자가 짝수/홀수 인지 여부 
		int num3 = 123;
		if(num3 % 2 == 0) {
			System.out.println(num3 + " 는 짝수입니다");
		} else {
			System.out.println(num3 + " 는 홀수입니다");
		}
		
		
		// 주어진 숫자가  0 ~ 100 점까지의 범위인지 여부 
		int num4 = 101;
		
		// if(0 <= num4 <= 100) // <-- 자바는 이런 조건식 표현 불가 
		
		
		if(0 <= num4 && num4 < 100	) {  //  알고리즈메서 이 조건문 만드는 것이 관건.
			System.out.println(num4 + " 는 유효한 점수입니다");
		} else {
			System.out.println(num4 + " 는 유효점수 아님");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
