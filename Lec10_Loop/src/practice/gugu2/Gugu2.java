package practice.gugu2;
/*
3개 열로 출력될 수 있도록 작성해보세요. 
 
2 x 1 = 2		3 x 1 = 3		4 x 1 = 4
2 x 2 = 4		3 x 2 = 6		4 x 2 = 8
.			.			.
.			.			.
.

5 x 1 = 5 		6 x 1 = 6		7 x 1 = 7	
.			.			.
.			.			.
.
8 x 9 = 72 		9 x 9 = 81
.			.
.			.

*/
public class Gugu2 {

	public static void main(String[] args) {
		
		
//		for(int i = 2; i <= 9; i++) {  // 2 ~ 9단
//			for(int j = 1; j <= 9; j++) {
//				if(j != 9) {
//				System.out.print(i + " x " + j + " = " + (i * j));
//				System.out.print((i + 1) + " x " + j + " = " + ((i + 1) * j));
//				System.out.print((i + 2) + " x " + j + " = " + ((i + 2) * j));
//				
//				} else {
//					System.out.print(i + " x " + j + " = " + (i * j));
//				}
//			}
//		}
		
//-------------------------------------------------------- 한 줄로 연결....   이쁜 코드.............   더 나아가서....  변수로 집어 넣어서 데이터 변경할 때마다 원하는 결과 얻을 수 있도록...
		
		
		for(int i = 2; i <= 9; i += 3) {  // 2 , 5, 8 단
			
			for(int j = 1; j <= 9; j++) {
				
				for(int k = 0; k < 3; k++) {
					
					if((i + k) == 10) break;
					System.out.print((i + k)+ " x " + j + " = " + ((i + k) * j) + "\t");
				}
				System.out.println();
			}
			System.out.println();
		} // end 전체 for
		
		
		
	} // end main

} // end class
