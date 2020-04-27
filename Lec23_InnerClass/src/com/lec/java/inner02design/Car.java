package com.lec.java.inner02design;

public class Car {
	// 멤버 변수( outer )
	private String color;
	
	// 생성자
	public Car(String color) {
		this.color = color;
	}
	
	// 메소드
	public void displayCarInfo() {
		System.out.println("color: " + color);
	}
	
	// 멤버 내부클래스
	public class Tire{
	
		private int radius;
		
		public Tire(int radius) {
			this.radius = radius;
		}
		
		public void dispalyInfo() {
			System.out.println("--- 자동차 정보 ---");
			System.out.println("color : " + color);  //Outer 클래스 멤버변수 얼마든지 사용가능 -> 같은 가족!
			System.out.println("tire: " + radius);
		}
		
		
		
		
		
	} // end Tire
	
	
	
	
} // end class Car











