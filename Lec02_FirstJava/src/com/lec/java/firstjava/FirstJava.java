package com.lec.java.firstjava;
/*
모든 자바 프로그램은 main() 메소드로부터 '시작'한다
프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/

// 블럭 주석
// 	/* ~ */
public class FirstJava {
	
	// 깜빡하고 public static void 메소드  체크 안했다면 ---->    main 입력하고 (Ctrl + space) 
	public static void main(String[] args) {
		System.out.println("My First Java App");
		
		System.out.println(123);
		System.out.println();
		System.out.println(10 + 20);  // 10, 20 은 숫자로 인식 => 연산, 결과가 30
		System.out.println("10 + 20"); // 쌍따옴표로 감싸면 -> "~" 안의 10 + 20 은 문자열로 인식
		
		// 문자열 출력은 반.드.시 "~" 로 감싸야 한다. 
//		System.out.println(안녕하세요);  // 에러     Ctrl + / =>  한줄 주석 
		
		
		System.out.println(3.141592 * 10 * 10);
		System.out.println(10 * 10 / 2);
		
		// + 연산자의 여러가지 동작
		// 좌우측 중 한개라도 "문자열" 이면 '문자열 연결' 연산 수행 ... 
		System.out.println("안녕하세요" + " 여러분"); // 문자열에서의 + ? -> 문자열끼리 연결...
		
		System.out.println("결과: " + 10); // 내부적으로 10 이라는 숫자를 문자열 10 으로 바꿈.
										// Home : 그 줄 맨 앞 , End : 그 줄 맨 뒤  ...   Shift + End/Home   한줄 전체 선택 
		
		System.out.println("결과: " + 10 + 20); 
		// -> 결과: 10 수행 하고 + 20 수행 
		
		System.out.println("결과: " + (10 + 20)); 
		// -> 10+20 =30   결과: 30 수행 (결과는 문자열로)
		
		
		// 사칙연산 보여주기(+, -, *, /)
		System.out.println("10 + 20 = " + (10 + 20)); 
		System.out.println("10 - 20 = " + (10 - 20)); 
		System.out.println("10 * 20 = " + (10 * 20)); 
		System.out.println("10 / 20 = " + ((double)10 / 20));  // 정수 / 정수  결과는 정수	(소수점 이하 절삭)
		
		// 이스케이프 문자(escape character)
		// " ~ " 문자열 안에서 특수한 문자 출력 
		// 역슬래스(\) 와의 조합문자로 구성
		
		// \"  	: 쌍따옴표 출력
		// \n 	: 줄바꿈
		// \t	: 탭문자 (8칸 간격)
		// \\	: 역슬래시
		
		// She says "Hi"  <-- 출력하려면?
//		System.out.println("She says "Hi"");
		System.out.println("She says \"Hi\"");
		
		System.out.println("\t123\t456"); 
		System.out.println("\t10\t4");
		System.out.println("Avengers\nEndgame");
		
		
		
		
		
		
		
		
		
	} // end main

} // class
