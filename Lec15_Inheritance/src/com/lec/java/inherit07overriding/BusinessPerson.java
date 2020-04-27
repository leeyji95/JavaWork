package com.lec.java.inherit07overriding;

public class BusinessPerson extends Person {
	
	private String company;

	// getter & setter
	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	
	
	// 메소드 재정의(Overriding)
	@Override  // 컴파일러쪽에 동작 알려주는 기호   '어노테이션' 이라함
	public void showInfo() {
		super.showInfo();
		super.showInfo();  // 부모 쪽에 있는 showInfo() 호출하고
		System.out.println("회사: " + company); // 나(자식)는 company 만 찍을게.
	}
	
	// 메소드 오버로딩(Overloading)
	public void showInfo(int id) {
		System.out.println("id: " + id);
		showInfo();
	}
	
	
	// 이클립스 단축키   
	// Alt + Shift + S.  V   
	
//	@Override
//	public void whoAreYou() {
//		super.whoAreYou();
//	}

	
	@Override
	public String toString() {   // 어떤 객체를 문자열로 리턴하는 메소드
		return "BusinessPerson:" + getName()  + " " + company;
	}

	

}
