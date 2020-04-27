package com.lec.java.inherit04parentconstructorautocall;

public class Car extends Vehicle{
	
	int oil;
	
	// 1
	public Car() {
		// 부모 클래스의 기본생성자 호출 =---> Vehicle() 
		// 명시적으로 super 생성자가 없으면 부모의 기본생성자를 호출하게 됨.
		System.out.println("Car() 생성");
	}
	
	
	// 2
	public Car(int oil){
		// super() 는 반드시 생성자 코드의 '첫번째 문장' 에 와야 한다. 
		super(); // 부모의 기본생성자를 호출하세요 의미. super 는 부모를 의미, super() 는 부모의 기본생성자를 호출하라는뜻
		this.oil = oil;
		System.out.println("Car(int) 생성 : oil = " + oil);
	}
	
	
	// 3
	public Car(int speed, int oil) {
		super(speed);  // super(int) <-- 부모생성자 중에서 int 타입인 생성자를 호출한다!)  // 명시적으로 int 타입 가진 생성자 호출하겠다고 한 것. 
		this.oil = oil;
		System.out.println("Car(int, int) 생성: speed = " + speed + "oil = " + oil);
			
	}
	
	public Car(double value) {
		this(555, (int)value); // 생성자 위임(delegation)   // this 에 호출코드 넣을 것 : 자기 생성자 호출하는 중. int 타입과int타입을 가지고 잇는 다른 생성자에게 할일을 넘김. 
		//super(100);  // this 와 super 는 양립할 수 없다
		System.out.println("Car(double) 생성 : value = " + value);
	}
	
	

}
