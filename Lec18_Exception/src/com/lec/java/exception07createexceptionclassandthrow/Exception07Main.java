package com.lec.java.exception07createexceptionclassandthrow;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Exception 클래스 만들어 사용하기  & throw
 	Exception 또는 RuntimeException 클래스를 상속 받아서 만듬
 */
public class Exception07Main {

	static Scanner sc = new Scanner(System.in);
	
	
	// TODO : ScoreException 을 throws 하는 메소드 만들기
	public static int inputScore() throws ScoreException{
		int score = sc.nextInt();

		if(score < 0 || score >  100) {
			ScoreException e = new ScoreException(score + "값은 유효한 점수가 아닙니다.");
			
			throw e;  // 예외객체 throw!  인위적으로 특정 예외 발생 을 내가 만들어준 경우 -> throws 아니고 thorw 다!
					// 핸들링 해주기!!
		}
		
		return score;
	} // end inputScore()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기, throw");
		
		System.out.println();

		// ScoreException 을 catch 해보자
//		try {
//			System.out.println("국어 점수 입력:");
//			int kor = inputScore();
//			System.out.println("kor = " + kor);
//			
//			System.out.println("영어 점수 입력:");
//			int eng = inputScore();
//			System.out.println("eng = " + eng);
//		} catch (ScoreException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			sc.close();
//		}
	int i = 0;
	while(i < 5) {
		try {
			System.out.println("국어 점수 입력:");
			int kor = inputScore();
			System.out.println("kor = " + kor);
			i++;
			
		} catch (ScoreException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("적절하지 않은 입력값입니다");
			sc.nextLine();
		}
	}	
		
		sc.close();
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Exception07Main












