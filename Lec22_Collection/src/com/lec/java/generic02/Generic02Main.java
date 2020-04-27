package com.lec.java.generic02;

/* 제네릭 클래스의 타입
 * 	제네릭 클래스에서 사용되는 타입은 
 * 	기본 자료형(primitive type)은 사용될 수 없고,
 * 	Object 타입의 자료형들만 올 수 있음.
 * 		(예) int는 사용할 수 없고, Integer를 사용해야 함
 * 		(예) double은 사용할 수 없고, Double을 사용해야 함
 */
public class Generic02Main {

	public static void main(String[] args) {
		System.out.println("Generic 클래스 2");

		//Test<int, String> t1;  // 제너릭에 프리미티브 타입 절. 대 . 못써요
		Test<Integer, String> t1 = new Test<Integer, String>(123, "Hello, Java"); // 여기서 알아서 래퍼 클래스가 오토박싱, 언박싱 함.
		t1.display();
		
		System.out.println();
		Test<Integer, Double> t2 = new Test<Integer, Double>(111, 3.14);
		t2.display();
		
		// 여러개의 집합 데이터를 다루는 데이터.<= 컬렉션
		// 자료구조 시간에 많이 다룸 
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class Collection02Main


// 여러개의 타입 넣을 수 있다.
class Test<T, U>{
	T item1;
	U item2;
	public Test(T item1, U item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public void display() {
		System.out.println("item1 : " + item1);
		System.out.println("item2 : " + item2);
	}
	
} // end class Test<>





























