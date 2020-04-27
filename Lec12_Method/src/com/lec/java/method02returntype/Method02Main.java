package com.lec.java.method02returntype;

/* return 의 믜미
 * 
 *   1. 메소드를 호출한 곳으로 값을 '1개' 리턴할 수 있다.
 *   2. 메소드 종료
 *   3. 메소드 정의시 명시한 리턴타입의 값이 '반드시' 리턴되어야 한다
 *          (혹은 리턴타입으로 형변환 가능한 값이)
 */

public class Method02Main {

	public static void main(String[] args) {
		System.out.println("메소드의 리턴 타입");
		
		int sum = add(110, 220); // 매소드 호출하고, 호출한 리턴 '값'을 변수에 담아주고 출력
		System.out.println("\nsum = " + sum);
		
		sum = add(10, 20) + add(30, 40);
		System.out.println("\nsum = " + sum);
		
		sum = add(50, add(10, 20));
		System.out.println("\nsum = " + sum);
		
		System.out.println("sum = " + (add(10, -40) + add(add(20, 30) + 10, 10))); // 40  -->  실무에서 이런 메소드가 메소드 누가누가 호출하고 등등  엽기적인 코드 많이 볼 수 있음
		
		int result = sub(25, 23);
		System.out.println("result = " + result);
		
		result = multiply(25, 23);
		System.out.println("result = " + result);
		
		result = divide(25, 0);  // exception 발생 --> Rjava.lang.ArithmeticException: / by zero  
		System.out.println("result = " + result);
		
		String result_1 = divide2(25, 0);
		System.out.println("result = " + result_1);
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	// 메소드 이름: add
	// 매개변수:
	//   1) int x
	//   2) int y
	// 리턴타입: int
	// TODO
	public static int add(int x, int y) {
		int result = x + y;
		
		return result; // 리턴! (메소드 종료, 값을 리
	} // end add()
	
	// 메소드 이름: sub
	// 매개변수:
	//   1) int x
	//   2) int y
	// 리턴타입: int
	public static int sub(int x, int y) {
		return x - y;
	}
	
	// 메소드 이름: multiply
	// 매개변수:
	//   1) int x
	//   2) int y
	// 리턴타입: int
	public static int multiply(int x, int y) {
		return x * y;
	}
	
	// 메소드 이름: divide
	// 매개변수: 
	//   1) int x
	//   2) int y
	// 기능: x를 y로 나눈 몫을 리턴하는 메소드
	// 리턴타입: int
	public static int divide(int x, int y) {
		return x / y;
	}
	
	
	// 메소드 이름: divide2
	// 매개변수:
	//   1) int x
	//   2) int y
	// 만약에 y 가 0 이면 -->  "0으로 나눌수 없습니다" 
	// y 가 0 이 아니면 -->  "몫은 ~~이고 , 나머지는 ~~ 입니다"
	// 리턴타입: String ★
	public static String divide2(int x, int y) {
		if(y == 0) {
			return "0으로 나눌 수 없어유!!!!";
		} else {
			return "몫은 " + (x / y) + "이고\n, 나머지는 " + (x % y) + "입니다."; 
		}
	}

	
} // end class









