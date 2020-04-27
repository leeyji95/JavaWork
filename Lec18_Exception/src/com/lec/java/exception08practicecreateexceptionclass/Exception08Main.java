package com.lec.java.exception08practicecreateexceptionclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);
	
	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		int age = sc.nextInt();

		// AgeInputException 을 throw 하기
		if(age < 0) {
			AgeInputException e = new AgeInputException(age + "는 숫자가 아닙니다.");
			
			throw e;
		}
		
		return age;
	} // end inputAge()
	

//---------------------------------------------------------------------
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");
		
		System.out.println();
		
//		int i = 0;
//		while(i < 5){
//			try {
//				int age = inputAge();
//				System.out.println("나이: " +  age);
//				
//			}catch (AgeInputException e) {
//				System.out.println(e.getMessage());
//			}catch (InputMismatchException e) {
//				System.out.println("적절하지 않은 입력값입니다");
//				sc.nextLine();
//			}
//		}
		
		
		// 제대로 된 나이 입력 받을 때까지 
		while(true){
			try {
				int age = inputAge();
				System.out.println("나이: " +  age);
				
				break;
				
			}catch (AgeInputException e) {
				System.out.println(e.getMessage());
			}catch (InputMismatchException e) {
				System.out.println("적절하지 않은 입력값입니다");
				sc.nextLine();
			}
		}
		
		
		
		
		
		
		
		sc.close();
		System.out.println("프로그램 종료...");
		
	} // end main()

} // end class Exception08Main












