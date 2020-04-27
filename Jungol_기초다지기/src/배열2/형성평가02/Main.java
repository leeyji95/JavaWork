package 배열2.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] arrScore = new int[100];
		int [] n = {0, 1, 2, 3 ,4, 5, 6, 7, 8, 9, 10};
		int [] nCnt = new int [11];
		
		
		for (int i = 0; i < arrScore.length; i++) {
			int score = sc.nextInt(); // 내가 입력한 점수
			arrScore[i] = score / 10; // 점수대 담은 배열 
		
			if(score <= 0 || score > 100) {
				break;
				
			} else{
				for(int j = 0; j < n.length; j++) {
					if(arrScore[i] == n[j]) {
						nCnt[j]++;
					}
				} // end for
			}

		} // for
		
		
		for(int j = n.length - 1 ; j >= 0; j--) {
			if(nCnt[j] > 0)
			System.out.println(j * 10 + " : " + nCnt[j] + " person");
		}
		
		
		
		sc.close();
		
		
		
		/*
		 * 	
		 * 
			if(score == 0) {
				for (int j = 0; j < nCnt.length; j++) {
				
					if(nCnt[j] > 0) {
						System.out.println(n[j] * 10 + " : " + nCnt[j] + "person");
					} // if
				} // for
				break;
				
			} else {
				
				for(int j = 0; j < nCnt.length; j++) {
					if(arrScore[j] == n[j]) {
						nCnt[j]++;
						System.out.println(n[j] * 10 + " : " + nCnt[j] + "person");

					}
				} // end for 
				
			} // else 
			
			
		 */
		
		
//		for(int i = 0; i < 100; i++) {
//			score[i] = sc.nextInt(); // 점수 입력받은 걸 배열에 담기
//			if(score[i] == 0) break;
//			
//		}
//		
		
		
//		입력받은 점수를 가지고,  
//		10점 단위로 구분하여 점수대별 학생 수를 출력
	}

}
