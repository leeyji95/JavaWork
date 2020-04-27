package com.lec.java.array04maxmin;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[5];
		
		int sum = 0, n;
		for (int i = 0; i < arr.length; i++) {
//			n = sc.nextInt();
//			arr[i] = n;
			arr[i] = sc.nextInt(); // 오 이렇게 한번에...!!
			sum += arr[i];
		}
		
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.1f", (double)sum / arr.length);
		
		
		
		
		
		System.out.println(); 
		// 최소값
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(min > arr[i]) 
				min = arr[i];
		}
		System.out.println("최소값 : " + min);
		
		
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {  // 여기서 int i = """"1 """ 부터....!!  데이터 5개니까 
			if(max < arr[i]) 
				max = arr[i];
		}
		System.out.println("최대값 : " + max);

// *******************	논리 : 데이터가 n개  있으면, n-1 번 비교한다. ***********************
		
//		int max1 = 0;
//		int num;
//		int min1 =0;
//		
//		while(true) {
//			num = sc.nextInt();
//			max1 = (max1 > num) ? max1 : num;
//			min1 = (min1 < num) ? min1 : num;
//		}
//		
//		
//		if(num == 0) {
//			System.out.println(max1 + min1);
//		}
//		
//		
		
		
		
		
		
		
		
		
		sc.close();
		
	} // end main()

} // end class Array04Main








