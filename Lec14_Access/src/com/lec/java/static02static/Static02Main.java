package com.lec.java.static02static;

//클래스 변수 / 메소드 특징 (static)
//1. 메모리의 '메소드 영역'에 클래스가 로드 될때(프로그램 시작될때) '한번만' 생긴다
//2. 인스턴스가 생성되지 않아도 사용할 수 있다.
//		- 클래스이름.static변수,  클래스이름.static메소드()  <-- 요렇게 사용한다
//3. 모든 인스턴스는 하나의 static 변수/메소드를 '공유'한다.


public class Static02Main {

	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드");

		// static 변수도 기본값으로 자동 초기화됨.
		System.out.println(Test.sNum); // 0  // static 은 무조건 클래스이름 쩜으로 사용.  -> 프로그램 시작할 때 이미 메소드에리어에 인스턴스를 만들어 놓았기 때문에 이렇게만 사용할 수 있다.. 
		Test.show2();  // 클래스 이름 쩜 메소드 호출
		
		Test.sNum = 123;
		Test.show2();
		
		//Test.num;  ㅇ에러
		
		Test t = new Test(); // 인스턴스 생성
		t.num = 100;
		t.show();  // 예측  num = 100. sNum 은 123 (-> 모든 인스턴스는 하나의 static 변수와 메소드를 공규하기 때문)
		
		Test t2 = new Test();
		t2.num = 200;
		t2.show();
		
		Test.sNum = 999;
		t2.show();
		t2.sNum = 500;  // 계속 덮어씀 (딱 하나만 존재하므로)
		t.show();
		
		Test.sNum = 100;
		t.sNum = 500;
		t2.sNum = 700;
		System.out.println(Test.sNum);
		System.out.println(t.sNum);
		System.out.println(t2.sNum);
		
		
		// 클래스 이름쩜  클래스변수 사용.   인스턴스 생성 없이 클래스 이름 쩜 으로 사용한다~~
		
		
		
	} // end main()

} // end class Static02Main







