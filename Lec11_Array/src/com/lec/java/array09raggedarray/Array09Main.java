package com.lec.java.array09raggedarray;

/* ragged array: column(열)의 개수가 일정하지 않은 배열

	가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
	열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
 */
public class Array09Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)"); 
			
//		int[] arr[];  이렇게 써도 가능
//		int arr[][];  이렇게 써도 가능
		int[][] arr = new int[3][];  // -> 에러(빨간줄) 뜨지 않았으나,  Exception 나옴. NullPointerException
									// int[] 3개짜리 2차원배열 객체만 생성
// null 값으로 초기화.  어떠한 주소값도 갖고 있지 않다는 뜻. 
		//  null 에다가 . 찍으면 아무것도 없으므로 nullpointexception  ,  이때는 따로 하나씩 만들어 줌.
		
		// null 에다가 뭔가를 집어넣음.  length 값 집어넣음.
//		arr[0] = new int[1];
//		arr[1] = new int[2];
//		arr[2] = new int[3];

		arr[0] = new int[] {10};
		arr[1] = new int[] {11, 12};
		arr[2] = new int[] {20, 30, 40};
		/*
		 *  0 
			0 0 
			0 0 0 
	자바는 각각의 다른 차원을 갖는 배열 생성이 가능 하다. 
	예를 들어 C언어의 경우 각각 열과 행이 딱딱 맞아야 함. 
		 */
		
		// ragged  들쑥날쑥한 .    각각이 가지고 있는 배열의 개수를 맘대로 조작할 수가 있다.
		
		
		int[] temp = arr[1];
		arr[1] = arr[2];
		arr[2] = temp;
		// 확인
		for (int i = 0; i < arr.length; i++) {
			for (int j 	= 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		

	} // end main()

} // end class Array09Main

