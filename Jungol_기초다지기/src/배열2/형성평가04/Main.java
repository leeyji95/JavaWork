package 배열2.형성평가04;

public class Main {

	public static void main(String[] args) {
	
		int [][] arr = {
				{3, 5, 9},
				{2, 11, 5},
				{8, 30, 10},
				{22, 5, 1}
		};
		
		int sum = 0; // 합을 담을 변수

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
				sum += arr[i][j];
			}
			System.out.println();
		}
		
			System.out.println(sum);
		
		
		
		
		
	}

}
