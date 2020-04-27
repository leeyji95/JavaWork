package com.lec.java.array11difference;

/* for와 enhanced for의 차이점
	 enhanced for문에서는 배열의 원소를 꺼내서
	 변수에 복사(저장)해서 사용하는 것입니다.
	 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
 */
public class Array11Main { 

	public static void main(String[] args) {  // 프로그램 시작될 떄 변수값 받아서  실행.... args . String 타입의 arg 변수 받앋와서 넘겨줌.
		System.out.println("for와 enhanced for의 차이점");
		
		int [] arr1 = {10, 20, 30, 40 , 50};
		
		System.out.println("증가전");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println("\n\n증가후");
		// 배열의 원소를 +1 씩 증가시키기
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] += 1;
		}
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println("\n\nEnhanced-for 증가후");
		int [] arr2 = {10, 20, 30, 40 , 50};
		for(int num : arr2) {   // arr2 에 있는 것을 num 에 복사시키기 때문에   원본에 변경이 없음
			num++;
		}
		for(int num : arr2) {  // 그래서 변화 없음
			System.out.print(num + " ");
		}
		
		System.out.println();
	} // end main()

} // end class Array11Main









