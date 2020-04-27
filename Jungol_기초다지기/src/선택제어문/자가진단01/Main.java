package 선택제어문.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(n);
		
		if(n < 0) {
			System.out.println("minus");
		}
		
		
		
		sc.close();
	}

}
