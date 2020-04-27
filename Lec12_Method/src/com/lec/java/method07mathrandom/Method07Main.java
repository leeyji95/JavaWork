package com.lec.java.method07mathrandom;

import java.util.Random;

/* Math 클래스의 메소드
 */

/*  <나의 필기>
 * floor(num) 는 num 기준으로 '왼쪽' 에서 가장 큰 값(음수던, 양수던)   --->   f'l'oor...  'l'eft....로 기억하자...
 * ceil(num) 은 num 기준으로 '오른쪽' 에서 가장 작은 값(음수던, 양수던)
 * round(num) 의 경우	
 * 			음수 : 왼쪽으로 반올림  -2.8 이면 -3 
 * 			양수 : 오른쪽으로 반올림 2.8 이면 3 
 * 
 */
public class Method07Main {

	public static void main(String[] args) {
		System.out.println("Math 객체의 메소드");

		// Math.random() : 0.0 <=  r < 1.0 사이의 난수 발생(double)
		double r;
		for (int i = 0; i < 10 ; i++) {
			r = Math.random();
			System.out.println(r);
		}
		
		System.out.println();
		// double Math.floor(num): num을 넘지 않는 가장 큰 정수(바닥)
		// double Math.ceil(num): num보다 큰 가장 작은 정수(천장)
		// long Math.round(num): num에서 소수점 사사오입 (반올림)
		System.out.println(Math.floor(2.7)); // 2
		System.out.println(Math.ceil(2.7)); // 3
		System.out.println(Math.round(2.7)); // 3  (정확히 long 타입 리턴)
		
		System.out.println(Math.floor(-1.2)); // -2 
		System.out.println(Math.ceil(-1.2)); // -1
		System.out.println(Math.round(-1.2)); // -1
		
		System.out.println(Math.floor(-2.8)); // -2
		System.out.println(Math.ceil(-2.8)); //  
		System.out.println(Math.round(-2.8)); //  round 는 -> 음수는 왼쪽으로 반올림, 양수는 오른쪽으로 반올림.
	
		System.out.println();
		System.out.println("1,2,3 범위중 난수 발생시키기");
		for(int i = 0; i < 5; i++) {
			double num;
			num = Math.random(); // 0.0 <= num < 1.0
			num = num * 3;  	// 0.0 <= num < 3.0
			num += 1;			//1.0 <= num < 4.0
			System.out.print((int)num + " ");  // 소수점 걸러내기
		}
		
		System.out.println();
		System.out.println("로또: 1 ~ 45 숫자중에서 랜덤으로 6개 출력");
		for(int i = 0; i < 6; i++) {
//			double num;
//			num = Math.random(); 
//			num = num * 44;
//			num += 1;
//			System.out.println((int)num);
			System.out.print((int)(Math.random() * 45 + 1) + " ");
		}
		
		
		System.out.println();
		System.out.println("Random 객체 사용하여 난수 출력");
		Random rand = new Random();
		// 0 ~ 2 사이 난수 5개 발생
		for (int i = 0; i < 5; i++) {
			System.out.print(rand.nextInt(3) + ", ");  // -> 0 부터  3 사이 발생
		}
		 System.out.println();
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// TODO

} // end class









