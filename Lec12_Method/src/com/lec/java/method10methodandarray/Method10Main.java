package com.lec.java.method10methodandarray;

import java.util.Arrays;
import java.util.Scanner;

/* 메소드와 배열
 * 매개변수가 배열,  리턴타입이 배열
 * 
 * 
 * 배열을 (매개)변수로 받아 메소드 실행예제
 * 
 * 반대로 배열로 리턴할 수 있다.
 */
public class Method10Main {

	public static void main(String[] args) {
		System.out.println("메소드와 배열");
		Scanner sc = new Scanner(System.in);

		int[] score = new int[10]; // 10 명의 점수
		
		// 점수를 입력받아서 score 배열에 저장
		inputScore(sc, score);
		
		// 저장된 점수 확인
		displayScore(score); // 매개변수로 배열을 넘겨준다
		
		// 총점 계산
		int total = calcTotal(score);
		System.out.println("총점: " + total);
		
		System.out.println("랜덤 숫자 배열 생성");
		double [] randArr =  genRandom(10);
		System.out.println(Arrays.toString(randArr));
		
		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// method name: inputScore
	// return: void
	// arguments: 
	//   1) Scanner sc - 입력장치
	//   2) int[] score: 점수를 입력받아서 저장할 배열
	public static void inputScore(Scanner sc, int[] score) {
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수" + (i) + " 입력:");
			score[i] = sc.nextInt();
		}
	}
	
	// method name: displayScore
	// return: void
	// arguments: int[] score - 출력할 점수가 저장된 배열
	public static void displayScore(int[] score) {
		System.out.println("점수출력");
		System.out.println("---------------------------");
		for(int x : score) {
			System.out.print(x + ", ");
		}
		System.out.println();
		System.out.println("---------------------------");
	}
	
	
	// method name: calcTotal
	// return: int (계산된 총점을 리턴)
	// arguments: int[] score (점수들을 저장한 배열)
	public static int calcTotal(int[] score) {
		int total = 0;
		for(int x : score) {
			total += x;
		}
		return total;
	}

	
	// method name: findMax
	// return: int (최대값)
	// arguments: int[] score (점수들 저장된 배열)
	
	
	
	// method name: findMin()
	// return: int (최소값)
	// arguments: int[] score
	// TODO
	
	// method name: genRandom()
	// return: double[]  (생성된 난수 배열)
	// arguments: n  생성할 난수 개수
	public static double[] genRandom(int n) {
		
		double [] arr = new double[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.random(); // 배열에다가 난수 넣어보자
		}
		return arr;
	}
	
} // end class Method09Main












