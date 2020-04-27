package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count = 1;
		while(count <= 10) { // 조건식  // 조건식이 참인 동안~  수행하는 문이 while 문
			count++;
			System.out.println(count); // count++ 위에 -> 2 ~ 11 까지 출력,  count++ 아래 -> 1 ~ 11   똑같이 11에 밖으로 나옴.
		} // end while
		
		
		System.out.println();
		
		
		// 10, 9, 8, ... 1 출력
		int i = 10; // 초기식
		while(i >= 1) { // 조건식
			System.out.println(i);
			i--; // 증감식
		} // end while
		
		/*
		 * for문 과 while문 서로 대응이 된다. 
		 * 
		 */
		
		
		
	} // end main()
	
} // end class While01Main









