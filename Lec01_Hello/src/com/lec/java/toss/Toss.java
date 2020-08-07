package com.lec.java.toss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Toss {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in); // String input = br.readLine();
		String [] arr = new String[10]; // 최대 5개까지 담을 수 있음
		
		
		for (int i = 0; i < 10; i++) { // 
			String str = sc.next();
			arr[i] = str; // 내가 입력한 은행이름을 배열에 담는다
		} // end for
		
		for(int i = 1; i <= arr.length; i ++) {

			if(arr[i - 1].equals(arr[i])) {
				System.out.println(arr[i]);
			} else {
//				System.out.println(arr[i] + " " + arr[i-1]);
				for(int j = i; j < arr.length; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
//		ArrayList<String> list = new ArrayList<String>();
//		
//	
//		
//		for(int i = 0; i < list.size(); i++) {
//			String str = sc.next();
//			list.add(str);
//			
//			if(list.get(i).equals(list.get(i+1))) {
//				System.out.println(list.get(i));
//			} else {
//				System.out.println(list.get(i + 1) + list.get(i));
//
//			}
//		}
//		
		
		
		
		
		
		sc.close();
		System.out.println("프로그램 종료");
	} // end main()

} // end class
