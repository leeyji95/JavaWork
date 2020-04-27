package com.lec.java.oop01polymorphism;
/*
 	다형성  ( Polymorphism )  -> 하나의 이름을 가진 클랴스나 메소드가  여러가지 동작을 함.(하나의 이름의 여러가지 동작을 함)    
 	하나의 이름의 클래스나 메소드가 '여러 가지 형태의 동작을 하는 능력'
 	
 	클래스의 다형성:
	 	한 타입의 참조변수로 여러타입의 객체를 참조 가능.
	 	조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조가능한것
 	
 	메소드의 다형성:
 		메소드 오버로딩, 메소드 오버라이딩
 	
 */
public class Polymorphism01Main {

	public static void main(String[] args) {
		System.out.println("다형성(Polymorphism)");
		
		// "=" 대입연산자에 집중!
		Vehicle v1 = new Vehicle();
		Car c1  = new  Car();
		HybridCar h1 = new HybridCar();
		
		v1.displayInfo();
		c1.displayInfo();
		h1.displayInfo();
		
		System.out.println();
		
		
		// 하나의 타입으로 여러가지 클래스를 수행  !!   아래의 경우, vehicle 타입 으로 각각의 클래스 메소드를 수행
		Vehicle car1 =  new Vehicle();
		Vehicle car2 = new Car();   // vehicle 타입의 자식     // Car IS-A Vehicle
		Vehicle car3 = new HybridCar(); // vehicle 타입의 손자  // HybirdCar IS-A Vehicle
  		// 부모(조상)가 자손 다 받을 수 있다.
		
		car1.displayInfo();
		car2.displayInfo();
		car3.displayInfo();
		// 어느 타입에 있던 displayInfo 가 나올 것인가? 
		// 자바는 생성자의 실제 인스턴스 값이 나옴. new 로 초기화된 값이 출력됨
		
		Car car4 = new HybridCar();
		
		// HybridCar car5 = new Vehicle(); //  불가능! 자손에다가 조상타입을 대입시키려하면 안됨.!  (자손) <- (조상) X
		
		
		// 이즈어 관계, 해즈어 관계 리뷰 
		
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()
	
	// TODO

} // end class








































