package com.lec.java.variable03;


//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double
public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수 - 실수타입");
		
		double number1 = 3.141592;
		//float number2 = 3.14;  // 기본적으로 실수 리터럴은 double 로 인식
		// float <- double 대입 불가
		
		// 그래서, float 타입의 리터럴이 따로 있다.
		float number3 = 3.14f;  // f 붙여주면 실수 리터럴 4바이트짜리가 된다. 
		
		// 실수타입 최소, 최대값
		System.out.println("float: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		/*
		 * float: 1.4E-45 ~ 3.4028235E38
		 * double: 4.9E-324 ~ 1.7976931348623157E308
	
		* 실수 표기할 때 소수점이 많으므로, 유효한 실수형으로 나타냄. E " 10의 -45승 이라는 뜻. 
		* 1.4E : 1.4 * 10의 45승,  
		* 4.9E : 4.9 * 10의 -324승
		* 
		* 실수값의 최소 최대는 정수와 다르다. 0< __ <1  소숫점 어디까지 내려갈 수 있는가.   얼마만큼 자리수 많아지는가의 개념
		* 실수는 음수표현 못하나요?  아뇨, 그냥  - 붙이면 돼유.
		* 비트를 표혀하는 방식이 달라서 그럼.
		* 근본적으로 한정되어 있다. 
		* 무한히 표현해내는 건 불가능. 적당한 선까지 표현해줌.
		* 
		* 실수타입은 정확한 값을 기대하면 안된다. -> 정밀도의 문제
		* 
		 */
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println("number4 = " + number4); //number4 = 1.2345679
		System.out.println("number5 = " + number5); //number5 = 1.23456789
		/*
		 * float 와 double 은 저장할 수 있는 값의 크기만이 아니라 
		 * 소숫점 이하 정밀도(precision)의 차이가 있다. 
		 * 
		 * float 은 소수점 6개 정도까지만 정확도 유지될 거고, double 은 약 13자리 정도?  그 뒤는 정확도 기대하면 안된다. 
		 */
		

		// 실수 표기법
		double number6 = 123;  // 자동 형변환된다. int 가 double 로.
		double number7 = 1.23e2; // 지수표기법 (exponential notation)
		System.out.println("number6 = " + number6);
		System.out.println("number7 = " + number7);
		
		double number8 = 0.0001213;
		double number9 = 1.213E-4;
		System.out.println("number8 = " + number8);
		System.out.println("number9 = " + number9);
		
		
		
		
		
		
		
	} // end main()

} // end class
