package 배열2.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int [] arr = new int[10];
		
		arr[0] = n1;
		arr[1] = n2;
		
		for (int i = 2; i < arr.length; i++) {
			
		}
		
		arr[3] = ((n1 + n2) % 10);
		
		
		
		
		
		
		sc.close();
		
		
		

	}

}
