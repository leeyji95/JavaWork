package com.lec.java.dowhile;
/*
do {     do 블럭 열고, 그 안에 조건문을 일단은 한 번 실행.     그리고 조건식 건드려서 실행.
	...
	...
}while(조건식) 문인 경우에는,

{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
조건식을 검사하게 된다.

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do~while");
			
		int n = 0;
		while(n > 0) {
			System.out.println("카운트다운: " + n);
			n--;
		}
		
		
		System.out.println("---------------------------");
		n = 0;
		do {
			System.out.println("카운트다운: " + n);   // 일단 한 번은 실행 함
			n--;
		} while(n > 0);
		
		
		// 구구단 9단을 do ~ while 로 출력
		n = 1;
		do {
			System.out.println("9 x " + n + " = " + (9 * n));
			n++;
		} while(n < 10);
		
		// 실무에서 잘 안 쓰임.  
		// 
		
		
		
	} // end main()

} // end class While04Main









