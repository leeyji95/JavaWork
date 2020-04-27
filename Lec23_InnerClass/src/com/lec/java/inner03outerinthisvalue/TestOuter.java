package com.lec.java.inner03outerinthisvalue;

public class TestOuter {
	private int value;
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	
	// 멤버 내부 클래스 
	public class TestInner {
		private int value;
		
		public TestInner(int value) {
			this.value = value;
		}
		
		public void printValue() {
//			System.out.println("value = " + value);  // 가까운 inner value
			
			int value = 10; // 3. 지역변수 value
			System.out.println("value = " + value);
			System.out.println("this.value = " + this.value); // <- this 는 TestInner 객체    // 여기서 말하는 value 는 this. 으로 뽑아낸다. 
			System.out.println("TestOuter.this.value = " + TestOuter.this.value); // Testouter 인스턴스에 있는 this 쩜 value값 
			
		}
		
		
	} // end class TestInner
	
} // end class TestOuter














