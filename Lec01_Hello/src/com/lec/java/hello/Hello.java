package com.lec.java.hello;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * Java 첫 프로그램.
 * [학습목표]
 * - 기본 출력 : println(), print() 
 * - 주석 (Comment)
 */
public class Hello {

	public static void main(String[] args) {
//		System.out.println("Hello Java!");  // 한줄 주석 : line comment
//		System.out.println("안녕하세요"); // println() 은 화면 출력하고 한줄 띄기.
///*
// * 하나의 명령문 만든 것. 화면에 출력하라는 명령어. 
// * 컴파일하면 이진수로 변환. 변환된 것을 컴퓨터가 실행할 수 있도록.
// * 소스코드는 ~.java   
// * 바이트 코드는 ~.class : 이게 바로 플랫폼 독립적인 언어 결과물
// * (Hello.class 파일가지고 리눅스, 맥, 윈도우 모두 열림)
// * source code (src) -> com -> 쭉쭉쭉 
// * D:\JavaApp1\Dropbox\Java_lecture\JavaWork\Lec01_Hello\src\com\lec\java\hello
//	
// * Window -> perspective-> Reset perspective(레이아웃 초기화)
// */
//		
//		System.out.println(); // 줄바꿈 
//
//		System.out.println(1 + 2);
//		System.out.println("1" + "2");
//		System.out.println('A' + 'B');
//		System.out.println('1' + 2);
//		System.out.println();
//		System.out.println('J' + "ava");
//		
//		// 클래스 파일  { }  안에  public~   
//		// 자바 프로그램은 public~ 시작함.  한줄 한줄 차례대로 실행.
//		
//		System.out.println("보이세요");
//		
//		
//		// print() 는 출력하고 줄바꿈 안함.
//		System.out.print("자바");
//		System.out.print("프레임워크");
//		System.out.println("풀스택 과정");
//		System.out.println("2020-03-16");
//		

		
		
		String S = "babaa"; // 매개변수 S 
		S.indexOf("a");
		String [] arr = S.split("a", S.length()/3); // 세 개의 덩어리가 배열에 담김.
		for(String wordSplit : arr) {
			System.out.println(wordSplit + "|");
		}
		
		
		
		
		
		
		
		
		
//		int result = num1 * num2 ;
//		System.out.println(Integer.toBinaryString(num1 * num2));

		
//		String result = Integer.toBinaryString(num1 * num2); // 바이트로 변환 10101
//		int [] arr = new int[result.length()];  // 
//		System.out.println(result.length());
//		
//		String result = "10101";
//	
//		String[] array_word; // 스트링을 담을 배열
//		array_word = result.split(""); //배열에 한글자씩 저장하기
//		int cnt = 0;
//		for(int i = 0; i < array_word.length; i++) { //출력
//			if(array_word[i].contains("1")) {
//				System.out.println("포함");
//				cnt++;
//			} else {
//				System.out.println("no");
//			}
//		}
//		System.out.println(cnt);
//		System.out.println(array_word[i]);
		
//		
//		int result2 = Integer.parseInt(result); // String -> int 로 변환
//		//arr = result2; 
//		
//		for (int i = 0; i < arr.length; i++) {
//			  if(IntStream.of(arr).anyMatch(x -> x == 1)) {
//			        System.out.println("포함");
//			    } else {
//			        System.out.println("포함되지 않음");
//			    }        
//		}
		
//		for(int i = 0; i < )
		
		
//			return result.length();
	}

}
