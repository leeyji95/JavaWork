package com.lec.java.static03singletonpattern;

//import java.util.Calendar;

//Singleton 디자인 패턴
// 생성되는  인스턴스가 최대 1개까지만 허용해야 하는  패턴설계
public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
		// 디자인패턴 : 방법론이나 구조
		// 내가 만든 클래스에서 인스턴스가 최대 1개만 만들어야하는 상황 -> 에서 적용한다.
		
//		Test t1 = new Test();
//		Test t2 = new Test();
//		
		
		Test t1 =  Test.getInstance();
		System.out.println("t1: num = " + t1.getNum());
		t1.setNum(123);

		System.out.println("t1 : num = " + t1.getNum());
		
		
		Test t2 = Test.getInstance();
		System.out.println("t2: num = " + t2.getNum()); // 123
		
		/*
		 * new 로 인스턴스 생성 할 수 없음 -> 왜? Test 클래스에서 생성자를 private 으로 막아놨음.
		 * 
		 * 
		 */
		
		
		// Singleton 사용예
		//Calendar c = new Calendar();
		//Calendar c = Calendar.getInstance();  // ~ 쩜 getinstance 나와있다? 아 이거 싱글톤이군
		
		
		
	} // end main()

} // end class Static03Main











