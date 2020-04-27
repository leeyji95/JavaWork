package practice.game369;

import java.util.Scanner;

/*
 * 힌 줄에 10개씩
 * 3,6,9 가 들어간 경우, * 로 표시
 * 문자열 메소드 쓰지 않고 하기
 * 
 * 순환문과 조건문만 만들어서 사용하기
 * 
 */
public class Game369 {
	public static void main(String[] args) {
		
		// 369 게임 
		for(int i = 1; i <= 100; i++) { // 1 ~ 100 까지 수
			
			// i 의 몫 과 나머지가 3 or 6 or 9 일때
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9 ||
					i / 10 == 3 || i / 10 == 6 || i / 10 == 9) { //		int x = i % 10; //int y = i / 10;  묶기.
				System.out.printf("%-4s", "*");
			} else {
				System.out.printf("%-4d", i);
			}
			
			if(i % 10 == 0) // i 가 10 단위일 때 줄바꿈 -> (10의 배수일 때 )
				System.out.println();
		}
		
		
//		int x = i % 10;
//		int y = i / 10;
	
		
		
		
		
		
		
//		// 두 번쨰 문제(사용자 입력까지 369 게임 작동)
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//			
//		for(int i = 1; i <= n; i++) {
//			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9 ||
//					i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
//				System.out.printf("%-4s", "*");
//			} else {
//				System.out.printf("%-4d", i);
//			}
//			
//			if(i % 10 == 0) // i 가 10 단위일 때 줄바꿈 -> (10의 배수일 때 )
//				System.out.println();
//		}
		
//		sc.close();
		
		
		
		
		
	}
}
