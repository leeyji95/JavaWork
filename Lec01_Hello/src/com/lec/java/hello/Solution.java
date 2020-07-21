package com.lec.java.hello;

import java.util.Scanner;

public class Solution {

	public int solution(int[] A) {
		
		Scanner sc = new Scanner(System.in);
		 
		int num1 = sc.nextInt(); // 3 입력 
		int num2 = sc.nextInt(); // 7 입력
		sc.close();
		
//		int result = num1 * num2 ;
//		System.out.println(Integer.toBinaryString(num1 * num2));

		
		String result = Integer.toBinaryString(num1 * num2);
		
		int reulst2 = Integer.parseInt(result);
		
		System.out.println(result.length());
		int [] arr = new int[result.length()];
		
//		for(int i = 0; i < )
		
		
			return result.length();
		
	} // end main()

} // end Solution
