package com.lec.java.static02static;

public class Test {
	int num; // 인스턴스 변수
	static int sNum; // 클래스 변수(static 변수)
	
	
	// 인스턴스 메소드
	public void show() {
		System.out.println("인스턴스 num = " + num);
		System.out.println("클래스(static)  sNum = " + sNum);
	}
	
	// 클래스(static) 메소드
	public static void show2() {
		//System.out.println("인스턴스 num = " + num);  // static 은 static  붙은 애들하고만 놀 수 있다.
		System.out.println("클래스(static)  sNum = " + sNum);
		
	}
	
	
	
	

}
