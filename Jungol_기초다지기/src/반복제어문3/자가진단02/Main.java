package 반복제어문3.자가진단02;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int  n = sc.nextInt();
		
		for(int i = 0; i < n; i++) { // n 번 출력
			for(int j = 0; j <= i ; j++) {  // 안 쪽에서 인덱스 번호를 어떻게 다루는가가 관건.   
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		sc.close();
	}

}
