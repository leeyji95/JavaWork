package com.lec.java.inner01innerclass;

/*
 Inner Class(내부 클래스)
 1. Member inner class(멤버 내부 클래스): 다른 클래스 내부에서 선언된 클래스
 2. Static inner class(static 내부 클래스): 다른 클래스의 내부에서 static으로 선언된 클래스
 3. Local class(지역 클래스)
   1) Local inner class(지역 내부 클래스): 메소드 내부에서 선언된 클래스
   2) Anonymous inner class(익명 내부 클래스): 이름이 없는 local class
*/

public class Inner01Main {

	public static void main(String[] args) {
		System.out.println("Member Inner Class(멤버 내부 클래스)");
		
		// 외부 클래스의 인스턴스 생성
		TestOuter out = new TestOuter(100);
		
		
		// 멤버 내부 클래스의 인스턴스 생성
		// 멤버 내부 클래스의 이름: [외부클래스 이름].[멤버 내부클래스 이름]
		// [외부클래스 이름].[내부클래스 이름] 참조변수 =
		//      [외부클래스 인스턴스].new 내부클래스 생성자();
		TestOuter.TestInner in = out.new TestInner(111);  // --> 이거 자체가 타입.
		in.printOuterValue();  // 100 츌력
		in.printInnerValue();
		
		// 아우터 객체 없이 이너 객체 못 만듦
		// 하나의 외부 클래스 인스턴스를 이용해서
		// 멤버내부 클래스의 인스턴스는 여러개 생성 가능하다.
		TestOuter.TestInner in2 = out.new TestInner(123);
		in2.printOuterValue();
		in2.printInnerValue();
		
		
		// 새로운 외부클래스 인스턴스 생성
		// out2 외부클래스 인스턴스 생성
		// out2 로부터 in4, in5 라는 이름으로 내부 클래스 객체 만드세요.
		System.out.println();
		System.out.println();
		
		TestOuter out2 = new TestOuter(200);
		
		TestOuter.TestInner in4 = out2.new TestInner(500);
		in4.printOuterValue();
		in4.printInnerValue();
		
		TestOuter.TestInner in5 = out2.new TestInner(600);
		in5.printOuterValue();
		in5.printInnerValue();
		
		
		// 핵심 :   아우터 인스턴스가 생성되어야지만!!!! inner 클래스 객체 생성할 수 있다.
		System.out.println();
		TestOuter.TestInner in7 = new TestOuter(30).new TestInner(330);
		in7.printOuterValue();
		in7.printInnerValue();
		
		
/*
   <------------------- 필기 ----------------------->
이즈어 관계, 해즈어 관계 

무엇을 멤버변수로 할 것이며, 무엇을 멤버 클래스로 만들 것인가

햄버거 세트 : 햄버거, 콜라, 감자튀김
햄버거 세트는 햄버거 가지고 있어유, 감튀도 가지고 잇고, 콜라도 가지고 있음

여기서 중요한 건,
햄버거, 콜라, 감튀  각각 독립적으로 가치가 있는가.
"독립적으로 존재할 가치가 있을 때" --->  '멤버 변수'로 설계하자


자동차와 타이어.
자동차 업이  타이어의 존재 가치가 없다. -> 그러면 자동차의 이너클래스로 만든다. '의존적 일때' -> '멤버 이너클래스'로 설계한다























 
 */
		
		
		
		
		
		
		
		
	} // end main()

} // end class Inner01Main

















