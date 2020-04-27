package com.lec.java.variable02;

// 자바의 기본 자료형(primitive data type)
// 정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
// 실수 타입: float(4바이트), double(8바이트)
// 문자 타입: char(2바이트)
// 논리 타입: boolean

public class Variable02Main {

	public static void main(String[] args) {
		System.out.println("정수타입 변수들");
		
		// 1 byte = 8 bit, 2의 8승, 256 개 표현, -128 ~ +127 까지 표현
		System.out.println("byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		byte num1 = -128;                                                   // 왼쪽 바이트 타입, 오른쪽 인트타입 .  대입연산자는 기본적으로 타입이 같아야함.  대입연산자가 형변환 가능한지 판단.   
		byte num2 = 0; 
		byte num3 = 123;
		//byte num4 = 1234; // 에러:  byte 에 저장할 수 있는 크기를 넘어섬 (cannot convert from int to byte...)
		
		System.out.println("short: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		short num5 = -12345;
		short num6 = 12345;
		//short num7 = 32768; 
		//short num8 = -32769;
		
		// 노란줄(warning문구) : The value of the local variable num1 is not used  ...    쓰지도 않을 거면서 왜 메모리 차지하게 만드냐. 
		
		
		System.out.println("int: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE); 
		System.out.println("long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		// 각각의 차지하는 용량 차이.
		
		//int num9 = 9876543210; 
		//long num10 = 9876543210;  // The literal 9876543210 of type int is out of range  
		// 대입연산자(형변환 단계)로 넘어가기 전에. 이 리터럴을 int 정수로 인식하지못하겠다는 뜻.   int 자체로 이미 범위가 넘었기 때문에 인식 못하겠다는 뜻. 
		
		
		/*
		 * literal : 리터럴
		 * 코드 상에 직접 입력한 값들은 모두 리티럴임.
		 * 무슨말..?
		 * -128, 0, 123 , "byt: " ...  내가 타이핑한 모든 것들 -> 리터럴.
		 * 	
		 * 		정수리터럴 --> int 로 형변환 하려 한다.
		 * 		실수 리터럴 --> double 로 형변환 하려 한다. 
		 * 		"~" 리터럴 --> 문자열(String) 로 형변환
		 *      ... 
		 */
		
		/*
		 *  정수 타입에서는 int 가 대표
		 *  실수 타입에서는 double 이 대표.
		 *  긍까 얘네가 기본적으로 동작하려는 타입들.
		 *  
		 *  
		 */
		
		
		long num11 = 9876543210L;  // long 형 리티럴로 인식.  즉 정수int 리티럴로 인식하지 못하는 리터럴을 long 형 리터럴로 바꿔줌.  L 없으면 int로 인식하려 할 것.
		long num12 = 12; // 12 는 롱으로 변환 가능해서 넘어간 것.
		long num13 = 12L; 
		                  // 똑같은 12 인데 위에는 4바이트, 아래는 8바이트로 인식
		int num14 = 12;
		//int num15 = 12L;  // 8 바이트 짜리를 4 바이트로 형변환 할 수 없음. 즉  long 타입을 int 에 대입 불가. 엄밀히 말하면 큰 타입을 작은 타입에 대입 불가
		
		// 값의 경계선
		byte num15 = Byte.MAX_VALUE; // 127
		byte num16 = (byte)(num15 + 1);
		System.out.println("num15 = " + num15);
		System.out.println("num16 = " + num16);
		/*
		 * 자바에서 정수는 순환구조를 가지고 있다
		 * +1 하면  넘어감. 
		 * 2의 보수법, 컴퓨터의 음수 표현법 ...
		 * 
		 * 정수 타입 4가지에서만 국한되서 나옴.
		 */
		
		// 정수 표기법
		int number1 = 11; // 10진수 (Decimal)
		int number2 = 0xB; // 16진수 (Hexadecimal) , 0x 로 시작
		int number3 = 013; // 8진수 (Octal) : 0 으로 시작
		//  코드상에서 값을 때려박는 걸 '리터럴' 이라고 한다. 고 어제 배웠다.
		int number4 = 0b1011; // 2진수(Binary) : 0b 로 시작
		
		
		System.out.println("number 1 = " + number1);
		System.out.println("number 2 = " + number2);
		System.out.println("number 3 = " + number3);
		System.out.println("number 4 = " + number4);
		
		// String.format() 을 사용하여 원하는 포맷(진법)으로 출력 가능
		System.out.println("number 1 = " + String.format("%x", number1)); // number1 을 16진수로 출력한다는 
		System.out.println("number 1 = " + String.format("%o", number1));
		
		// Integer.toXxxx(n) 를 사용하여 원하는 포맷의 문자열로 변환 가능
		System.out.println("number 1 = " + Integer.toHexString(number1)); // number1 을 16진수 문자열로 변환하여 출력
		System.out.println("number 2 = " + Integer.toOctalString(number1));
		System.out.println("number 3 = " + Integer.toBinaryString(number1));
		
		
	} // end main()

} // end class
