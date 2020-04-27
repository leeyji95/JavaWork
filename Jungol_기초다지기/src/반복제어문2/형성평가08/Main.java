package 반복제어문2.형성평가08;

import java.util.Scanner;

/*
 
입력 예 
3 4

출력 예
1 2 3 4
2 4 6 8
3 6 9 12

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt(); // 행
		int col = sc.nextInt(); // 열
		
		for(int i = 1; i <= col; i++) {
			
			for(int j = 0; i < col; j++) {
				System.out.print((i + i*j) + " ");
			}
		
			System.out.println();
		}
		
		
		
		sc.close();
	}

}
