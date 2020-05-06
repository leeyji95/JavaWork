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
		
		for (int i = 0; i < arr.length - 2; i++) {
			arr[i + 2] = (arr[i] + arr[i + 1]) % 10;
		}
		
//		arr[3] = ((n1 + n2) % 10);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		
		
		
		sc.close();
		
		
		

	}

}
