package test04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int [] arr = new int[100];
		
		int n;
		for (int i = 0; i < arr.length; i++) {
			n = sc.nextInt();
			
			arr[i] = n;
			
			if(arr[i] == 0) break;
		}

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(max < arr[i])
				max = arr[i];
		}
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(min > arr[i])
				min = arr[i];
		}
		
		
		System.out.println(max + "  " + min);
		
		
//		List<Integer> list  = new ArrayList<Integer>();
//		
//		int max, min;
//		while(true) {
//			int n = sc.nextInt();
//			if(n == 0) break;
//			list.add(n); // 정수값 입력받아서 리스트에 저장 
//		}
//		
//		
//		
//		// 배열 안쓰고 삼항연산자로?
//		
//		
//		
//		
		
		
		
		sc.close();
		
		
		

	}

}
