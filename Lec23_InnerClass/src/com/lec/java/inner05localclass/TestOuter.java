package com.lec.java.inner05localclass;

public class TestOuter {
	// TestOuter 클래스의 멤버 변수
	private int num1 = 100;
	
	// TestOuter 클래스의 멤버 메소드
	public void localMethod(final int num4) {

		int num2 = 200; // localMethod() 의 지역변
		
//		num4 = 500; // 값 변경됨.-> 에러? 왜? 이펙티브 파이널  동작 안함.  그래서 처음부터 매개변수에  final 붙인다. -> 애시당초 final 을 걸어놓는다.
		
		// Local inner class 
		class TestLocal{ // 얘는 수식어 없다
			// 멤버변수
			private int num3 = 300; 
			
			// 멤버메소드
			public void showNumbers() {
				System.out.println("num1 = " + num1); // 외부클래스의 멤버
				System.out.println("num2 = " + num2); // class 와 같은 local 의 지역변수
				System.out.println("num3 = " + num3); // 자기자신의 멤버변수
				System.out.println("num4 = " + num4);
			}
			
		}
		
		TestLocal local = new TestLocal(); // 로컬 클래스는 바로 인스턴스 생성한다  //  ㅣ local class 객체 만듦....    
		//num2 = 400;   //  객체 만들었어. 이미 정의 내렸는데, 정의내린걸 바꾸?     변경되는 순간 이펙티브 파이널 꺠짐.  ->  must be final or effectively final
		// num2 값을 변경하면.. 아래 showNumbers()에선
		// 200 이 찍혀야 하나? 400이 찍혀야 하나?
		// 그래서 로컬내부클래스에서 사용 가능한 지역의 변수는 
		// 반드시 effectively final 이어야 한다
		// 	  즉 한번 초기화 된후 값이 변경되지 않거나, final 이어야 한다.
		local.showNumbers();
		
	} // end localMethod()
	

} // end class TestOuter













