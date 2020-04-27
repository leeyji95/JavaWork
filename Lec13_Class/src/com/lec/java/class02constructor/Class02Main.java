package com.lec.java.class02constructor;

// 생성자(Constructor)
// 생성자의 목적: 인스턴스 생성시 멤버변수들의 초기화
// 생성자의 이름은 반드시 클래스의 이름과 동일
// 생성자는 리턴 타입이 없다.
// 생성자도 매개변수(argument)를 가질 수 있습니다.
// 생성자도 오버로딩(overload) 가능

// 클래스를 만들 때, 생성자를 따로 만들지 않으면
// '디폴트 생성자(default constructor)'를 자동으로 만들어줌.
// 디폴트 생성자란 : 매개변수가 없는 생성자.  모든 멤버변수는 기본값으로 초기화
// (주의) 클래스에서 하나 이상의 생성자를 만들게 되면,
// 자동으로 디폴트 생성자를 만들어 주지 않습니다.
// (강력권장) 아무일도 안하더라도 디폴트 생성자는 반드시 만들어 주자. 



public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1 = new Circle(); // --> 인스턴스 생성, 이때 실행하면  생성자() 호출됨. 
		/*
		 * new 다음에 있는 것 Circle() 이거. 이게 바로 생성자.
		 * 생성자의 목적 : 멤버변수의 초기화. 
		 * 
		 */
		Circle c2 = new Circle(3);  // 처음부터 반지름 3이라는 값을 가진 인스턴스를 만듦.
		
		double perimeter = c1.calcPerimeter();
		System.out.println("c1 의 둘레 : " + perimeter);
		perimeter = c2.calcPerimeter();
		System.out.println("c2 의 둘레 : " + perimeter);
		
		
		System.out.println("c1의 넓이: " + c1.calcArea());
		System.out.println("c2의 넓이: " + c2.calcArea());
		
		System.out.println();
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(2, 3);
		
		
		// r1, r2 의 둘레, 넓이 출력
		perimeter = r1.calcPerimeter();
		System.out.println("사각형1의 둘레: " + perimeter);
		double area = r1.calcArea();
		System.out.println("사각형1의 넓이: " + area);
		
		perimeter = r2.calcPerimeter();
		System.out.println("사각형2의 둘레: " + perimeter);
		area = r2.calcArea();
		System.out.println("사각형2의 넓이: " + area);
		 
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










