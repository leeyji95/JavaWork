package com.lec.java.exception04inherit;

/*	예외 클래스의 상속 관계 (★필수 암기★)
	java.lang.Object
	|__ java.lang.Throwable
	  |
	  |__ java.lang.Exception  : 복구 가능
	  |    |
	  |    |__ java.lang.RuntimeException
	  |    |    |__ ArithmeticException, NullPointerException, ...
	  |    |
	  |    |__ IOException, ParseException ...
	  |
	  |__ java.lang.Error    : 복구 불가
	         ...   OutOfMemoryError, StackOverFlowError ...  
	
	 getMessage(), printStackTrace() 등의 메소드는 Throwable 클래스에 정의
	 자식 클래스들은 Throwable에 정의된 메소드들을 사용할 수 있음
	 
	catch문은 여러개를 사용할 수는 있지만, 
	 상위 예외 클래스를 하위 예외 클래스보다 먼저 사용할 수는 없다. (컴파일 에러) 
*/
public class Exception04Main {

	
	public static void main(String[] args) {
		System.out.println("try ~ catch ~ catch ");
		
		int num1 = 123, num2 = 10, result = 0;
		String str = "abcd";
		int[] numbers = new int[10];

		// TODO : try ~ catch ~ catch .. 사용
		try {
			result = num1 / num2;
			System.out.println("나눈 결과: " + result);
			
			int length = str.length();
			System.out.println("스트링 길이: " + length);
			
			str.charAt(20); // StringIndexOutOfBoundsException.  ---> catch 절 못 찾으면, Exception 발생! 
			
			numbers[10] = 11111;
			System.out.println("numbers: " + numbers[10]);
		} catch (ArithmeticException e) {					// catch 절 차례대로 찾음    찾았으면 핸들링하고 빠져나감
			System.out.println("산술 연산 예외:" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("베열 인덱스 예외: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Null 포인터: " + e.getMessage());
		} catch(Exception e) {
			// Exception 은 모~든 Exception 들(상속된 예외 객체들까지도) catch 할 수 있다. 
			//(다형성)!!
			System.out.println("Exception 발생");   // 다형성의 의해서  다잡아냄 . . . . . . . . . . . . ........ . .. . . . . .
		}										  // 가장 윗줄에서 잡을 떈, 구조적으로 말이 안되는 구문. 
// 												 // catch문은 여러개를 사용할 수는 있지만,
												// 상위 예외 클래스를 하위 예외 클래스보다 
											   // 먼저 사용할 수는 없다. (컴파일 에러) 
		System.out.println();
		System.out.println("프로그램 종료");

	} // end main()

	
} // end class Exception04Main












