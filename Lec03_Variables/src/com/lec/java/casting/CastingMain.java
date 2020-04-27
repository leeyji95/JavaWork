package com.lec.java.casting;
/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */


public class CastingMain {

	public static void main(String[] args) {
		System.out.println("형변환(Type Casting/Type Converting");
		
		byte num1 = 123; // 사실은 대입연산자가 형변환 자동으로 해준것. -> 대입연산자가 자동형변환 역할을 해주고 있는 것. 왼쪽이 리터럴일때.
		int num2 = 123;
		//byte num3 = num2; // 이 경우 int가 byte로 형변환 안됨.  자동형변환 불가..   num2 는 리터럴이 아니기 때문에. 
		byte num3 = (byte)num2; // 명시적 형변환 가능!
		
		System.out.println("num3: " + num3);
		
		
		byte num5 = (byte)513;
		System.out.println("num5: " + num5);
		/*
		 * 513 -> 4바이트짜리인데, byte 는 1 바이트. 그러니까 상위 3자리는 버리는 셈. 한자리만 가져오게 됨.
		 * 계산기에서 513  Bin 0010 0000 0001   앞에 상위 데이터 날라가버림. 
		 * 즉 명시적 형변환 시, 데이터 손실 발생할 수있다는 뜻.
		 * 	
		 * 
		 */
		
		double avg1 = (99 + 88 + 78) / 3;  // int /int -> 결과가 int 88이  double 로 자동형변환이 되긴 하는데, 이제 데이터 날라가는.... 
 		System.out.println("avg1: " + avg1);
		
 		double avg2 = (double)(99 + 88 + 78) / 3;   // -> 한 쪽을 double 로 해준다
		System.out.println("avg2: " + avg2);
		
		double avg3 = (99 + 88 + 78) / 3.0;
		System.out.println("avg3: " + avg3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main

} // end class
 