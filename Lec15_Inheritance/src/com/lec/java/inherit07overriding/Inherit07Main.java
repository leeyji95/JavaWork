package com.lec.java.inherit07overriding;

/* 메소드 재정의(Overriding)
 * '상속'관계에서 '부모 클래스에 있던 메소드'를 '재정의'하는 것.
 *  부모 클래스에 있는 메소드와 매개변수 리스트가 동일해야 함
 *  부모 클래스에 있는 메소드와 접근권한 수식어가 동일할 필요는 없지만,
 *  접근권한의 범위가 축소될 수는 없다.
 *  즉, 접근권한은 같거나 더 넓은 수식어를 사용해야 함.
 *  
 *    ! 메소드 오버로딩(Overloading)과 혼돈하지 말자!
 *     
 * final 메소드 : 더이상 오버라이딩 불가
 * final 클래스 : 더이상 상속 불가 
 */
public class Inherit07Main {

	public static void main(String[] args) {
		System.out.println("상속: Method Overriding(재정의)");
		
		System.out.println();
		// Person 클래스의 인스턴스 생성
		Person p1 = new Person();
		p1.setName("abc");
		p1.showInfo(); // Person 클라스의 showInfo()
		
		System.out.println();
		// BusinessPerson 클래스의 인스턴스를 생성
		BusinessPerson p2 = new BusinessPerson();
		p2.setName("아이언맨");
		p2.setCompany("스타크인더스트리");
		p2.showInfo();  // BusinessPerson 에서 Overriding 한 showInfo() 수행   // 자식쪽에서 재정의한 showInfo() 호출되어 수행됨.
		
		
		System.out.println();
		p2.whoAreYou();
		
		System.out.println();
		System.out.println(p2);  // p2.toString()  // 어떤 객체를 문자열로 출력하고 싶을 떄 tostring() 오버라이딩해라. 
		
	
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class




















