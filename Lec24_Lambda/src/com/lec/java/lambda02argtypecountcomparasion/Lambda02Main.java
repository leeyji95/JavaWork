package com.lec.java.lambda02argtypecountcomparasion;

/*	람다 표현식 (lambda - expression): 
	 	() -> 수행코드
	 	() -> 리턴값
	 	(매개변수..) -> 수행코드
	 	(매개변수..) -> 리턴값
	 	
	 매개변수의 타입은 생략해서 표현이 가능
	 매개변수가 여러개 있을 경우,
		 모든 매개변수의 타입을 생략해서 표현하거나,
		 모든 매개변수의 타입을 모두 다 표현해야 함. 
*/
public class Lambda02Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
		// 매개변수 없고, 리턴값도 없는 경우
		Test01 lamTest01 = () -> System.out.println("안녕하세요");
		lamTest01.testPrint();
		
		
		// 매개변수 한개, 리턴값은 없는 경우
		Test02 lamTest02 = (x) -> System.out.println("num = " + x);
		lamTest02.testPrint(55);
		
		
		// 매개변수 여러개, 리턴값이 있슴.
		Test03 lamTest03  = (x, y) -> (x > y) ? x : y; //  둘 중 큰 값 리턴(int 타입으로)   //  우측에 수행코드로 끝나면 그 결과값이 리턴.
		System.out.println("result = " + lamTest03.max(10, 20));
		
		
		// 매개변수 한개, 내부 수행코드 여러줄.., 리턴값.
		Test04 lamTest04 = (x) -> {
			System.out.println(x);
			return x.length();   // 수행코드로가 여러줄이면 블럭잡고,   리턴해야될 게 있으면 블럭 안에서 반드시 리턴해주면 됨.
		};
		System.out.println("result = " + lamTest04.myStrLen("Java lambda expression"));
		
		
		
		
		// Test05 인터페이스 만들기
		// void printMax(double x, double y)
		// [출력양식 예제]
		// x = 3.14
		// y = 1.2
	    // 3.14 > 1.2
		
		Test05 lamTest05 = (x, y) -> {
			System.out.println("x = " + x );
			System.out.println("y = " + y );
			
			// if 문 사용!...!!!>..!!!!!
			if(x > y) {
				System.out.println(x + " > " + y);
			}else {
				System.out.println(x + " <= " + y);
			}
		};
		lamTest05.printMax(3.14, 1.2);
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















