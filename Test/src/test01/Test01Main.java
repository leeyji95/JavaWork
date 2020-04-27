package test01;

import java.util.Scanner;

public class Test01Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		
		System.out.println(d1 + d2);
		System.out.printf("%.1f", (d1 * d2));
		
		
		sc.close();
		
		

	}

}
