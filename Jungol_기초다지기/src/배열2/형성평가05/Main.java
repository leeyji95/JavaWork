package 배열2.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [][] arr = new int[4][3];
		
		for(int i = 0; i < 4; i++) {
			
			int sum = 0;
			System.out.print((i + 1) + "class? ");
			for (int j = 0; j < 3; j++) {  // 안에서 3번 돌아가므로 --> 3번 입력받을 것 !
				arr[i][j] = sc.nextInt();
//				System.out.print(arr[i][j] + " "); // 담은 배열을 출력 !
			}

			System.out.println((i + 1) + "class : " + sum);			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
