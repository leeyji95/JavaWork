package 배열2.형성평가06;

public class Main {

	public static void main(String[] args) {
		
		int [][] arr = new int[5][5];
		
		arr[0][0] = 1;
		arr[0][2] = 1;
		arr[0][4] = 1;
		
	
		// 짝수 행(2행, 4행)
		for (int i = 0; i < 3; i += 2) { 
			
			for (int j = 1; j <= 4; j += 2) {
				arr[i + 1][j] = arr[i][j - 1] + arr[i][j + 1]; 
			}
		}// end for
		
		
//		// 홀수 행(3행, 5행)
//		for (int i = 1; i < 4; i += 2) {
//			
//			for (int j = 0; j < 5; j += 4) {
//				arr[i + 1][j] = arr[0][1] + arr[i][j - 1];
//			}
//		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
	} // end main

} // end class
