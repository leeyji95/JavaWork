package com.lec.java.oop05interface;

/*
 인터페이스(interface):
 1. 모든 메소드가 public abstract으로 선언되고,
 2. 모든 멤버 변수가 public static final 로 선언된  -->  모든 곳에서 쓰일 수 있으며, 한번만생성(시작할때)하고 인스턴스생성하징 않고 클래스이름. 값의 변경 불가 
 특별한 종류의 추상 클래스

 인터페이스는 interface라고 선언
 인터페이스를 구현(상속)하는 클래스에서는 implements 키워드를 사용
인터페이스를 구현(상속)할 때는 개수 제한이 없다.  ★★★★★★★★★★★★★★★★★★★★★(다중상속!)★★★★★★★★
 메소드 선언에서 public abstract는 생략 가능
 멤버 변수 선언에서 public static final은 생략 가능
*/

public class Interface01Main {

	public static void main(String[] args) {
		System.out.println("인터페이스(interface)");
		
		//TestInterface t1 = new TestInterface();  //  추상메소드를 하나라도 갖고있는 존재는 new 불가!!!
		
		TestImpl test1 = new TestImpl();
		test1.testAAA();
		test1.testBBB();
		
		TestImpl2 test2 = new TestImpl2();
		
		System.out.println(test1.MIN);
		//System.out.println(test2.MIN);  -> 자바에서 에러나는 다중상속
		// MIN 의 중복... 으로 모호함. 뭔지 모르겠따.   
		
		
		// static 은 클래스 이름 쩜 으로 접근 가능하므로~~~~!!!
		System.out.println(TestInterface.MIN);  // static 은 static 방법으로 사용하자!
		System.out.println(TestInterface2.MIN);
		

		System.out.println("\n 프로그램 종료");
	} // end main()

	
	
	
	
	
	
	
	
	
} // end class

interface TestInterface {
	// 모든 멤버변수가 public static final 이어야 하구요
	public static final int MIN = 0;   // public~ 안붙여도 interface 이므로 자동.   생략가능
	int MAX = 100;  // public static final 생략가능
	public static final String JAVA_STRING = "Java";
	String KOTLIN_STRING = "Kotlin";
	
	// 모든 메소드는 public abstract                  // d추상메소드 2개 니까 아래 상속받은 클래스에서는 두 개 오버라이딩됨
	public abstract void testAAA();
	void testBBB(); // public abstract 생략 가능
}





interface TestInterface2{
	public static final int MIN = 1;
	public abstract void testAAA();
	public abstract void testCCC();
}






// interface 로는 인스턴스를 생성할 수 없고, 
// 다른 클래스에서 구현 (implement) 해야 함.
class TestImpl implements TestInterface{

	@Override
	public void testAAA() {
		System.out.println("AAA");
	}

	@Override
	public void testBBB() {
		System.out.println("BBB");
	}
}





// 인터페이스는 다중 상속이 가능하다
class TestImpl2 implements TestInterface, TestInterface2{

	@Override
	public void testCCC() {
		System.out.println("CCC");
	}

	@Override
	public void testAAA() {
		System.out.println("AAA");
	}

	@Override
	public void testBBB() {
		System.out.println("BBB");
	}
	
}







































