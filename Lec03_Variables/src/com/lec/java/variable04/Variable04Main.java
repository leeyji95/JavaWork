package com.lec.java.variable04;

public class Variable04Main {

	public static void main(String[] args) {
		System.out.println("변숟 - char, boolean, String");
		
		// char : 문자 하나를 저장하기 위한 데이터 타입 (2 바이트)
		char ch1 = 'A';
		// char 리터럴은 홀옴표('')로 묶어줍니다
		// 문자열(String) 리터럴은 쌍따옴표(" ~ ") 로 묶어줌
		
		System.out.println("ch1: " + ch1);
		
		char ch2 = '한'; // '한' 이라는 코드값이 ch2 에 담겨있는 것
		char ch3 = '글';
		System.out.println("ch2: " + ch2);
		System.out.println("ch3: " + ch3);
		
		char ch4 =  0xAE01;
		System.out.println("ch4: " + ch4);
		char ch5 = 1234;
		System.out.println("ch5: " + ch5);
		
		// println() 은 char 를 문자로 출력함
		// 그러나, 다른 정수형으로 변환되면 해당 코드값을 정수로 출력
		char ch6 = '!';
		System.out.println("ch6: " + ch6);
		char ch7 = 33;
		System.out.println("ch7: " + ch7);
		
		System.out.println("ch7 + 1 : " + (ch7 + 1));
		System.out.println("ch7 + 1 : " + (char)(ch7 + 1));
		
		
		char ch8 = 'A';
		char ch9 = 'a';
		System.out.println("'A' : " + ch8 + "-" + (int)ch8); 
		System.out.println("'a' : " + ch9 + "-" + (int)ch9); 
		// 여기서 알아둬야 할 건, 소문자 코드값이 대문자 코드값보다 크다는 사실.
		/*
		 * 1.aaAA
		 * 2.AaAa
		 * 3.AAaa
		 * 4.aAaA   작은순으로 나열하면? 3-2-4-1
		 */
		
		
		// boolean(논리형) : 참(true), 거짓(false)
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		
		boolean b3 = 10 < 20;
		System.out.println("b3: " + b3);
		
		
		// String 타입(문자열)
		// primitive 타입 아닙니다.  
		String name = "Hong"; // String literal 은 "~"
		String nick = "Thunder";
		System.out.println("이름은: " + name + "\n별명은: " + nick);
		
		
		
	} // end main

} // end class
