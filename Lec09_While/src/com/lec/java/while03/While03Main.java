package com.lec.java.while03;

public class While03Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		// 1 ~ 10 까지 수 중에서 홀수만 출력
		int i = 1;
		while(i < 11) {
			if(i %  2 == 1) 
				System.out.println(i);
			i++;
		}
		
		System.out.println();
		
		
		
		
		i = 1;
		while(i < 11) {
			System.out.println(i);
			i += 2;
		}
		
		
	} // end main()

} // end class While03Main









