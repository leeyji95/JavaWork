package com.lec.java.inner04staticinnerclass;

public class TestOuter {

	// 멤버변수
	private int value;  // 인스턴스 변수
	private static int count = 100; // 클래스 변수 (static)
	
	// 생성자
	public TestOuter(int value) {
		this.value = value;
		
	}
	
	// Nested class (static inner class)
	public static class TestNested	{
			
		public void dispalyInfo() {
			//System.out.println("value = " + value); // 그냥 인스턴스 변수는 사용 불가!    static 은 static 하고만 사용!
			// static 클래스 에서는 외부클래스의 
			// non-static 멤버 사용 불가 
			
			System.out.println("count = " + count); // count 는 static 이므로 사용 가능!
		}
		
	}// end  TestNested
	
	
	
	
} // end class TestOuter


// TestOuter: 외부 클래스(outer class, enclosing class)
// TestNested: 중첩 클래스(nested class, static inner class)




















