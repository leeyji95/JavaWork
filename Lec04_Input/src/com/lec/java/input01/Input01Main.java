package com.lec.java.input01;

import java.util.Scanner;

/*
 * 가장 기본적인 입력장치 : 키보드 (마우스, 등등등~~) 
 * 가장 기본적인 출력장치 : 모니터
 */

//  우리가 키보드로부터 무언가 입력 받아서 출력해보는 것을 배워보자.

/*
 * 표준입력(Standard Input) : 키보드로부터 입력
 * 			Scanner 객체 사용
 * 
 * 표준출력(Standard Output) : 모니터로 출력
 */

public class Input01Main {

	public static void main(String[] args) {
		System.out.println("표준입력: Scanner 사용");
		
		
		Scanner sc = new Scanner(System.in); // import 필요, Scanner 객체 생성          --->  일단은 공식처럼 사용해주세요 
		/*
		 *  import java.util.Scanner 클래스를 사용하겠다. import 사용하여 외부로부터 끌고 들어와야함.
		 *  
		 */
		
		// Scanner 사용한 입력작업
		int num1, num2;
		System.out.print("숫자1을 입력하세요: ");
		num1 = sc.nextInt();
		System.out.print("숫자2를 입력하세요: ");
		num2 =sc.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		
		// nextInt() 에서 문자나 다른걸 입력하면 InputMismatchException  발생
		
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
		
		
		
		sc.close();  // Scanner 객체를 사용한 뒤에는 반드시 close() 를 해주자.     뭔가를 사용하겠습니다. 하고 close 로 마무리 해줘야 하는 종류의 프로그램 많다. 
		
	} // end main()
	

} // end class
