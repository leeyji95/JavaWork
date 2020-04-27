package com.lec.java.class03gettersetter;

/*
	캡슐화, 은닉, 추상화

	클래스 안에 필요한 '속성' 과 '행동' 을 멤버로 묶고
	외부에서의 '직접적인 접근을 제한'하여
	객체의 데이터 와 메소드를 은닉(hiding)하고, 
	사용자에게는 필요한 기능만 제공하여 추상화(abstraction) 하는   
	객체지향 기술을 '캡슐화(encapsulation)' 라고 한다
	
	
	클래스의 멤버변수를 접근하기 위한 기능을 제공하는 메소드를 
	getter , setter 라 한다
*/


public class Class03Main {

	public static void main(String[] args) {
		System.out.println("Getter & Setter");
		
		Number n1 = new Number(100, 'A');
		//n1.num = 200;  // private --> is not visible 에러.  데이터 은닉. 데이터를 볼 수가 없다. 존재하긴 하는데, 볼 수없다.
		//n1.name = 400;  // cannot be resolved  이런 이름 몰라요  // 이름 없음.
		
		System.out.println(n1.getNum());
		n1.setNum(200);
		System.out.println(n1.getNum());
		n1.setNum(-1);
		System.out.println(n1.getNum());  // num 값 바뀌지 않음

		System.out.println("프로그램 종료");
	} // end main()
} // end class Class03Main














