package com.lec.java.operator03sign;

/* 부호연산자(+, -) sign operator
 * 	+: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
 * 	-: 부호 연산자(수의 부호(양,음)가 바뀜)
 */
public class Operator03Main {	// , Source -> Format  소스포맷팅  (알아서 들여쓰기, 띄어쓰기 맞춰줌)

	public static void main(String[] args) {
		System.out.println("연산자 3 - 부호연산자(+, -) sign operator");

		int num1 = -10; // 연산자 몇 개? 2개. 피연산자는 1개가 있는 것
		int num2 = +num1;
		int num3 = -num1;

		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);

		int num4 = 11;
		int num5 = -22; // 블럭 선택해주고, Source -> Format
		int num6 = num4 + -num5;
		System.out.println("num6 = " + num6);

		int num7 = num4 - -num5;
		System.out.println("num7 = " + num7);

		System.out.println("\n프로그램 종료");
	} // end main

} // end class
