package 반복제어문3.형성평가09;
/*
 * 
 * 
#
# #
# # #
  # #
    #

 * 
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정수 입력
		sc.close();
		
		for(int i = 0; i < n; i++) {
			 
			for(int j = 0; j < i+1; j++) {
				System.out.print("# ");
			}
			System.out.println();
		}
		
		
		
		for (int i = 0; i < n-1; i++) {
//			for(int j = 0; j < i+1; j++) {
//				System.out.print("  ");
//			}
			
			for(int j = 0; j <= 2*i; j++) {
				System.out.print(" ");
			}
			
			for(int j = 1; j < n-i; j++ ) {
				System.out.print(" #");
			}
			System.out.println();
			
			
		}
		
		
		
		
		
		

	}

}
