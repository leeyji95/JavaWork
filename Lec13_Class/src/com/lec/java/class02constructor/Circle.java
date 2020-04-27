package com.lec.java.class02constructor;

public class Circle {
	
		// 원의 상태(속성) -> 멤버변수
		public double radius; // 반지름
		
		
		// 생성자(Constructor) (들...)
		public Circle() {  // 얼핏보면 메소드 같지만, 메소드 아님. 
			System.out.println("Circle() 셍성자 호출"); // 내가 직접 호출하는 것이 아니고, 인스턴스 생성될 때 '자동호출'된다.
			System.out.println("반지름: " + radius);  // 0 으로 디폴트
		}
		
		
		// 생성자 오버로딩 가능
		public Circle(double r) {
			System.out.println("Circle(" + r + ") 생성자 호출");
			radius = r; // 멤버변수 초기화
			System.out.println("반지름: " + radius);  
			}
		
	
		// 원의 기능(동작) -> 멤버 메소드
		
		
		
		
		// 원의 둘레 계산
		public double calcPerimeter() {
			return 2 * Math.PI * radius;
		}
		
		// 원의 면적 계산
		public double calcArea() {
			return Math.PI * radius * radius;
		}
		
		
	

}
