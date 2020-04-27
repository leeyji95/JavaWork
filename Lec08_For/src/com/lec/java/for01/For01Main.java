package com.lec.java.for01;


/*
 * ■ 순환문(loop)
 * 	- for
 * 	- while
 * 	- do ~ while

 * 
 * ■ for 순환문 구문
 * 
 * for(①초기식; ②조건식; ④증감식){
 * 		③수행문;
 * 		..
 * }
 *      ①초기식 : 최초에 단한번 수행
 *      ②조건식 : true / false 결과값
 *      		위 조건식의 결과가 false 이면 for문 종료
 *      ③수행문 : 위 조건식이 true 이면  수행
 *      ④증감식 : 수행문이 끝나면 증감식 수행
 *               증감식이 끝나면 다시 ②조건식 으로.. 
 * 
 * 순환문을 작성시 내가 만드는 순환문에 대해 다음을 확실하게 인지하고 작성해야 한다
 * 1. 몇번 순환하는 가?
 * 2. 순환중에 사용된 인덱스값의 시작값과 끝값은? 
 * 3. 순환문이 끝난뒤 인덱스값은?
 * 
 * 
    for문 작성시 TIP
	 1) n번 순환 하는 경우 (즉 횟수가 촛점인 경우) 혹은 배열
	 for(int i = 0; i < n; i++){ .. }
	
	 2) a ~ b 까지 순환하는 경우 (즉 시작값과 끝값이 중요한 경우)
	 for(int i = a; i <= b; i++){ .. }
 */

   		// ※※※ 항상 값의 경계선에서 문제 발생. 주의 ※※※※


public class For01Main {

	public static void main(String[] args) {
		System.out.println("for 반복문");
		
		System.out.println("Hello, Java1");
		System.out.println("Hello, Java2");
		System.out.println("Hello, Java3");
		
		System.out.println();
		
		for(int i = 1; i <= 3; i++) {
			System.out.println("Hello, Java" + i);
		}
		
		System.out.println();
		for(int count = 1; count <= 10; count++) {
			System.out.println("count : " + count);
		}
		
		System.out.println();
		for(int k = 10; k > 0; k--) {
			System.out.println("k = " + k);
		}
		
		System.out.println();
		for(int k = 10; k >= 0; k--) {
			System.out.println("k = " + k);
		}
		
		System.out.println();
		// 초기식과, 증감식에 식을 여러개 사용 가능
		int i, j;
		for(i = 0, j = 10; i < j; i++, j -= 2) {
			System.out.println("i : " + i + " j : " + j);
		}
		System.out.println("for 종료후 \n i: " + i + ", j: " + j);
		
		for(int k = 1; k % 27 != 0; k+=4) { // 조건식 : 27 의 배수이면 끝내라.
			System.out.println("k= " + k);
		}
		//System.out.println("for 종료후 k = " + k);  ->  for 문 밖에서도 k 쓰려면 for문 밖에 int k; 선언해줘야 한다. 
		
		/*
		 * for 문 블럭 안에서 선언한 건 그 블럭 안에서만 쓸 수 있다. 
		 * 지역변수 라고 함
		 * 지역변수 : local variable
		 * 블럭{ .. } 인에서 선언한 변수는 
		 * 선언한 이후 그 블러안서만 사용 가능
		 * 블럭이 끝나면 소멸됨.
		 */
		
		{
			int a = 100;
			System.out.println("a = " + a);
			{
				 // 안쪽의 블럭은 바깥쪽 블럭의 지역변수 사용 가능
				// 바깥블럭 지역변수와 동일 이름의 변수 사용 불가
				//int a = 100; 
				int b = 100;
				System.out.println("b = " + b);
			}
			//System.out.println("b = " + b);  // b 는 이미 안쪽 블럭 끝났을 때 소멸.
		}
		//System.out.println("a = " + a);
		
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class For01Main









