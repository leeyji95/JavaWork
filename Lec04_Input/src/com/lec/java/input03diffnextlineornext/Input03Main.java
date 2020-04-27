package com.lec.java.input03diffnextlineornext;

import java.util.Scanner;

public class Input03Main {

	public static void main(String[] args) {
		System.out.println("nextLine() vs next()");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("여러 단어의 문장을 입력>");
		String line = sc.nextLine(); // \n 까지 한 라인 전체 입력
		System.out.println("line: " + line);
		
		// next()
		// 다음 단어(token) 을 받아서 String 으로 결과 리턴 
		System.out.print("여러 단어의 문장을 입력>");
		String token1 = sc.next();
		System.out.println("token1 : " + token1);
		/*
		 * 단어 단위로 뽑아냄.
		 * 공백 나오면, 그 전까지 출력
		 * 아직 키보드 버퍼에 남아있음
		 * 또 뽑아보면 출력됨
		 */
		
		// next() 를 또 실행시키면 
		// 기존의 버퍼에 담겨 있는 내용들이 
		String token2 = sc.next();
		System.out.println("token2 : " + token2);
		
		String token3 = sc.next();
		System.out.println("token3 : " + token3);
		
		/*
		 * 처음 호출할 때 a a a 출력하고, 
		 * 다음 next수행되면  앞에 있는 공백은 제거가 됨. 그 다음  b b b 찾아내고, 그 다음 공백 앞에서 끊어내고
		 * 또 앞에 있는 공백 제거하고, 그 다음 공백 있기 전까지 문자 단어 뽑아냄. 
		 * -> 이게 문자 next() 가 작동하는 방식임.
		 * 
		 */
		
		
		// nextInt(), nextDouble() ... <-- next() 처럼 동작함.  //  nextLine() 은 한 줄이 아예 덩어리임. 
		
		// 따라서  숫자 타입도 여러개를 '한줄'로 입력 받을 수 있다.
		System.out.println("숫자 3개(int, double, int)를 입력받으세요>");
		int i1 = sc.nextInt();
		double d1 =sc.nextDouble();
		int i2 =sc.nextInt();
		
		System.out.println("li, d1, i2 : " + i1 + ", " + d1 + ", " + i2);
		/*
숫자 3개(int, double, int)를 입력받으세요>
100 3.14 200
li, d1, i2 : 100, 3.14, 200

--> 기존에 이렇게 입력해도 결과가 잘 나왔던 이유가 바로 next 처럼 작동했기 때문에 그런거였군....!

		 */
		
/*
 * 나중에 웹에서 사용자로부터  입력받는 건 모두 "문자열 타입"이다.   
 * 주문 수량이든 숫자든 뭐든 간에.
 * 
 * 다음 패키지에서  문자열 형변환 하는 것 배워보자.
 * 		
 */
		sc.close();
	} // end main

} // end class
