package com.lec.java.exception01concept;

import java.util.Scanner;

/* 예외(Exception)
	
	컴파일 에러 : 문법상 오류
	예외(Exception) : 문법상의 오류 가 아닌 '실행중' 에 발생되는 오류상황
	  
	(기본적으로) 예외 가 발생되면, 예외 관련 메세지 출력하고 프로그램이 종료 됩니다.  
 */
public class Exception01Main {

	public static void main(String[] args) {
		System.out.println("예외(Exception)");
		
		System.out.println("[1] ArithmeticException");
		int num1 = 123;
		int num2 = 0;

		//System.out.println("num1 / num2 = " + (num1 / num2));
		
		System.out.println("[2] ArrayIndexOutOfBoundsException");
		int[] numbers = new int[10];
		
		//numbers[10]	 = 100;
		
		System.out.println("[3] NegativeArraySizeException");

		int size = -1;
		//int[] numbers2 = new int[size];
		
		
		System.out.println("[4] NullPointerException");
		String str = null;
		
		//System.out.println("문자열 길이: " + str.length());
		// null 값 다음에 절대로 . 쩜 붙을 수 없다.
		/// aaa = bbb.ccc -> nullpointException  발생했으면 -> 쩜 왼쪽을 항상 의심.
		// aaa = bbb.ccc(dddd[10].eee)   여기서 bbb를 의심, dddd의 10번째를 의심 !!! --> 자바프로그래머로서 NPE 잡아내야 함. 
		// NPE 는 어디서 발생했는지 잡아내는것이 중요
		
		
		System.out.println("[5] InputMismatchException");  
		Scanner sc = new Scanner(System.in);
	
		//sc.nextInt();
		
		sc.close();
		

	} // end main()

	// 문법적으로 오류는 없으나,  반드시 처리해야한다. 그게 try~catch 문  02 패키지로
	
	
	
	
} // enc class Exception01Main











