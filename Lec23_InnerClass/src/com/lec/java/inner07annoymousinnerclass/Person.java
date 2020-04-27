package com.lec.java.inner07annoymousinnerclass;

public class Person {
	// Person 외부 클래스의 멤버 변수
	private String name;
	
	// Person 외부 클래스의 생성자
	public Person(String name) {
		this.name = name;
	}

	public Readable createInstance(int age) {
		
		// 익명 내부 클래스:
		// 인스턴스 생성과 동시에 클래스가 정의됨.
		// new 인터페이스() { 익명 클래스 내부 작성 }; 
		// new 부모클래스() { 익명 클래스 내부 작성 };

		return new Readable() {  // new 생성자 곧바로 { ~오버라이드~}  -===> 아 익명클래스구나!! 
			@Override
			public void readInfo() {
				System.out.println("이름 " + name);
				System.out.println("나이 " + age);
			}
		};
	} // end createInstance()3
	
} // end class Person


// Readable 이라는 인터페이스 만들기
interface Readable{
	public abstract void readInfo();
}

/*
 * readInfo  를 위해.  
 * 자바는 객체지향 언어이므로, 반드시 클래스를 만들고 메소드 젖ㅇ의 해주어야 한다. 
 * 그래서 그래. 
 * 
 * 인터페이스 만들고, 
 * 그 인터페이스로 리턴하는 메소드 만들고
 * 리턴에서 new 인터페이스 생성해주고, 곧바로 오버라이딩. 해줌 
 * 
 * 
 */








