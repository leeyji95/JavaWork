package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ..
		// 2 x 9 = 18
		// 3 x 1 = 3
		// 3 x 2 = 6
		// ..
		// 9 x 9 = 81
		
		for(int dan = 2; dan <= 9; dan++) {  // 단은 2단 부터 9단 까지
			
			System.out.println(dan + "단");
			for(int n = 1; n <= 9; n++) { // 곱하기 1 ~ 9  =>  매 단마다 수행
				System.out.println(dan + " x " + n + " = " + (dan * n));
			}
			System.out.println();  // 안쪽 for 문이 끝난 후!   안쪽 곱하기가 끝나고 나서 줄바꿈!
		}
		
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		
		int dan = 2;
		while(dan <= 9) {
			
			int n = 1;  // 직전에 초기화해라!   
			System.out.println(dan + "단");
			while(n <= 9) {
				System.out.println(dan + " x " + n + " = " + (dan * n));
				n++;
			}
			
			dan++;
			System.out.println();
		}
		
						
		
			
		/* while 문으로 정올 풀어보기 */
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















