package 배열1.자가진단09;
/*
입력 예
95 100 88 65 76 89 58 93 77 99

출력 예
100 99 95 93 89 88 77 76 65 58

 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		// cycle
		for(int i = arr.length; i > 0; i--) {
			
			// 비교 ( 9 번 발생)
			for(int j = 0; j < i - 1; j++) {
				
			
				if(arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		//  인덱스 가지고 장난치는구만...!@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}

}
