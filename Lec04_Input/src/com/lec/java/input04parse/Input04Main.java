package com.lec.java.input04parse;

import java.util.Scanner;

/*
 * 나중에 웹에서 사용자로부터  입력받는 건 모두 "문자열 타입"이다.   
 * 주문 수량이든 숫자든 뭐든 간에.
 * 		
 */

//일반적으로 프로그램에서 숫자입력하는 것이 처음에는 '문자열(String)' 형태다
//ex) 웹, 모바일앱..
//
//이를 숫자 타입으로 변환해야 산술 연산등이 가능해진다
//
//Integer.parseInt(문자열)  -->  int 로 변환
//Double.parseDouble(문자열)  --> double 로 변환

//Byte.parseByte(문자열)
//Short.parseShort(문자열)
//Long.parseLong(문자열)
//Float.parseFloat(문자열)
//Boolean.parseBoolean(문자열)

//문자열이 해당 타입으로 변환할수 없는 문자열이면 NumberFormatException 예외 발생 (에러)


public class Input04Main {

	public static void main(String[] args) {
		System.out.println("입력: 문자열 -> 숫자변환");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 3개(int, int, int) 를 입력받으세요>");
		// 결과가 문자 형태일때 int 타입으로 어떻게 형변환하는가
		String in1 = sc.next(); 
		int i1 = Integer.parseInt(in1); // 스트링 타입의 값을 받아서 int 타입으로 값을 변환해줌.
		int i2 = Integer.parseInt(sc.next());
		int i3 = Integer.parseInt(sc.next());
		
		System.out.println("합: " + (i1 + i2 + i3));
		
		// TODO
		// 실수 3개를 문자열로 입력받아서(next())
		// 3 실수의 곱을 계산하여 출력하세요
		
		double d1 = Double.parseDouble(sc.next());
		double d2 = Double.parseDouble(sc.next());
		double d3 = Double.parseDouble(sc.next());
		System.out.println("곱: " + d1 * d2 * d3);
		// 숫자 말고 다른 문자 입력시 -> parse 단계 에서 NumberFormatException  발생 -> 숫자 처리 잘못 한거다.   
		// 에러 메시지 무엇때문에 발생했는지 찾아내는 것이 중요.  
		// 에러 메시지 다양하게 접하는 것 추천.
		
		
		
		
		
		sc.close();
		
	} // end main

} // end class
