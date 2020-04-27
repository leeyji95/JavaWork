package 반복제어문1.자가진단04;

import java.util.Scanner;
/*
 * 
입력 예
1 2 3 4 5 6 7 8 9 10 100
출력 예
155
14.1
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int sum = 0, cnt = 0;
//		double avg = 0.0;
//		while(true) {
//			int n = sc.nextInt();
//			sum += n;
//			cnt++;
//			if( n >= 100) break;
//		}
//		avg = (double)sum / cnt;
//		System.out.println(sum);
//		System.out.printf("%.1f", avg);
//		
		
		
		int n;
		int sum = 0, cnt = 0;
		for(;;) {
			n = sc.nextInt();
			sum += n;
			cnt++;
			if(n >= 100) break;
		} // end for
		
		System.out.println(sum);
		System.out.printf("%.1f", (double)sum / cnt);
		
		
		
		
		
		sc.close();
		
	}

}
