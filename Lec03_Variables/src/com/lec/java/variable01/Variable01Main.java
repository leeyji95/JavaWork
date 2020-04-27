package com.lec.java.variable01;
/*
	변수 (Variables) :
		값을 담는 공간.  변수이름(variable name)을 부여해서 관리
		
	변수는 사용하기 전에 먼저 '선언(declaration)' 해야 한다
	변수 선언:
		변수타입 변수이름;
	
	변수의 초기화 (initialization)
	변수에 최초로 값(value) 을 대입 (assignment) 하는 것.
	변수(지역변수)를 사용/참조하려면 그전에 반드시 초기화가 되어야 함.

*/
public class Variable01Main {

	public static void main(String[] args) {
		System.out.println("변수(Variables)");
		
		// 변수 선언
		//  변수타입 변수이름;
		
		// int - (정수타입, integer)
		
		int num1;	 // int타입 변수  num1 선언
		int num2;	 // int타입 변수  num2 선언
		
		// Aaaa bbb; 변수선언(Aaaa타입의 bbbb 변수를 선언한 것)
		
		// 변수의 초기화
		num1 = 10; // 대입연산자(=) 사용하여 변수에 값을 대입(assign)
					// assignment operator  -> 왼쪽의 값을 오른쪽에 담는다. 뜻
		
		// 변수 초기화 전에 '사용' 하려 하면 에러!
		// System.out.println("num2 = " + num2); // 에러 "may not have been initialized..."
		num2 = 20;
		
		// num3 = 30; // 선언안된 변수 사용불가, "cannot be resolved..."  -> 나 그런 이름 몰라요. 하는 에러구문
	
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		// 항상 타입과 값을 따라다녀야함
		
		num1 = 123; // 변수의 값은 변경 가능! 그래서 변수!(변수는 변할 수 있어서 변수)
		System.out.println("num1 = " + num1);
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		
		
	} // end main()

} // end class
