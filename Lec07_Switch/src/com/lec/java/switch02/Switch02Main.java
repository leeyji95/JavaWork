package com.lec.java.switch02;

public class Switch02Main {

	public static void main(String[] args) {
		System.out.println("switch 연습");

		// 도전
		// switch ~ case 조건문을 사용해서
		// 짝수 이면 --> "짝수입니다"  출력
		// 홀수 이면 --> "홀수입니다"  출력

		
		int num = 45;
		
		switch(num % 2) {  // 핵심은 switch 안에 무엇을, 어떤 조건을 넣을 것인가.  그 값이 case에 들어가야 한다.  기본적으로 int 값 또는 int 로 자동형변환할 수 있는 타입들이 올 수 있다. 그래서 long 은 들어올 수 없다
		case 0: 
			System.out.println("짝수입니다");
			break;
		case 1:
			System.out.println("홀수입니다");
			break;
		} 
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









