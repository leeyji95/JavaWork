package com.lec.java.method03;

import java.util.Scanner;

/* 메소드 연습
 * 국어, 영어, 수학 점수를 입력 받아서
 * 총점, 평균, 학점을 출력하는 프로그램
 * 
 * 총점, 평균, 학점을 구하는 각각의 메소드들을 작성하여 프로그램 완성하기
 * 
 *  [입력예]
 *  78 98 57
 *  
 *  [출력예]
 *  총점: 233
 *  평균: 77.66666666666667
 *  학점: C
 */
public class Method03Main {
	
	public static void main(String[] args) {
		System.out.println("메소드 연습");

		// 국어, 영어, 수학 점수를 위한 int 변수를 선언 int korean, english, math;
		
		// 키보드를 통해서 점수를 입력 받고 저장
		Scanner sc = new Scanner(System.in);

		int kor = sc.nextInt(), eng = sc.nextInt(), math = sc.nextInt();
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		
		sc.close();
		
		// calcTotal() 메소드를 정의+호출 하여 총점 계산하고 출력
		int total = calcTotal(kor, eng, math);
		System.out.println("total = " + total);
		
		
		// calcAvg() 메소드를 정의+호출 하여 평균 계산하고 출력
		double avg = calcAvg(total);
		System.out.println("double = " + avg);
		
		
		// calcGrade() 메소드를 정의+호출 하여 학점(A, B, C, D, F)을 출력
		// 평균 90 이상이면 A, 80 이상이면 B, 70 이상이면 C, 60 이상이면 D
		// 나머지는 F
		char grade = calcGrade(avg);
		System.out.println("grade = " + grade);
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	// calcTotal
	// 기능: 국어, 영어, 수학 점수를 입력 받아서 총점을 리턴하는 메소드
	// return: int
	// method name: calcTotal
	// arguments:
	//   1) int kor: 국어 점수
	//   2) int eng: 영어 점수
	//   3) int math: 수학 점수
	public static int calcTotal(int kor, int eng, int math) {
		return kor + eng + math;
	}
	
	// calcAvg
	// 기능: 총점을 입력받아서 평균을 리턴하는 메소드
	// return: double
	// method name: calcAvg
	// arguments: int total - 총점
	public static double calcAvg(int total) {
		return (double)total / 3;
	}
	
	
	// calcGrade
	// 기능: 평균을 받아서 등급을 리턴하는 메소드
	//      평균 90 이상이면 'A', 80 이상이면 'B', 70 이상이면 'C', 60 이상이면 'D'
	//      나머지는 'F' 리턴
	// return: char
	// method name: calcGrade
	// arguments: double avg - 평균
	// 
	public static char calcGrade(double avg) {
		if(avg >= 90) return 'A';
		if(avg >= 80) return 'B';
		if(avg >= 70) return 'C';
		if(avg >= 60) return 'D';
//		if(avg < 60) return 'F';
		return 'F';
	
	}
	
	
	
} // end class








