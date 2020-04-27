package com.lec.java.class02constructor;

public class Rectangle {
	
	// 속성 : 멤버변수
	// 가로, 세로
	double width;
	double height;
	 
	// 셍성자
	// 1. 디폴트 생성자
	public Rectangle() { // public 클래스 이름 그대로 사용.  디폴트생성자란? 매개변수가 없는 생성자. 딱 나와줘야 함.!!
		System.out.println("Rectangle() 생성");
		width = 100;  // 디폴트 값 지정 가능
		height = 100;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}
	
	
	// 2. 매개변수 가진 생성자
	public Rectangle(double w, double h) {
		System.out.println("Rectangle(w, h) 생성");
		width = w; // 멤버변수 초기화  ---> 위해 생성자 만드는 것!!!!
		height = h;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}
	
	
	// 동작  : 멤버 메소드
	// 1) calcPerimeter: 사각형의 둘레
		public double calcPerimeter() {
			return (width + height) * 2;
		}
		
		// 2) calcArea: 사각형의 넓이
		public double calcArea() {
			return width * height;
		}
		
		
	
	
	
	

}
