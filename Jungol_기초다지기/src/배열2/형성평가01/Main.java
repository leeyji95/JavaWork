package 배열2.형성평가01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] dice = { 1, 2, 3, 4, 5, 6 }; // 주사위
		int[] arrCnt = new int[6];

		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			for (int j = 0; j < 6; j++) {
				if (n == dice[j]) {
					arrCnt[j]++;

				} // end if

			} // end for(j)

		} // end for(i)
			
		for (int i = 0; i < arrCnt.length; i++) {
			System.out.println((i+1) + " : " + arrCnt[i]);
		}
		
		
		sc.close();
	} // end main

} // end class
