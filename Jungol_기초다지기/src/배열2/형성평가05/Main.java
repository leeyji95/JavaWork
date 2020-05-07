package 배열2.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [][] arr = new int[4][3];
		
		for (int i = 1; i <= arr.length; i++) {
			System.out.print(i + "class? ");
		}
		
		for(int i = 0; i < 4; i++) {
		
			int sum = 0;
			for (int j = 0; j < 3; j++) {  // 안에서 3번 돌아가므로 --> 3번 입력받을 것 !
				arr[i][j] = sc.nextInt();
//				System.out.print(arr[i][j] + " "); // 담은 배열을 출력 !
				sum += arr[i][j];
			}

			System.out.println((i + 1) + "class : " + sum);			
		}
		
		sc.close();

	}

}
