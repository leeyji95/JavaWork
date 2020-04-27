package com.lec.java.inherit07overriding;

// final 클래스는 더이상 상속 불가 
// public final class Person
public class Person {
// 멤버 5개
	private String name;

	// getter & setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public void showInfo() {
		System.out.println("이름: "  + name);
	}
	
	// final 메서드 :  더이상 오버라이딩 불가
	public final void whoAreYou() {   // 리턴타입 앞에 final 붙이면 더이상 오버라이딩 불가 
		System.out.println("이름: "  + name);
	}
	
	
	
	
}
