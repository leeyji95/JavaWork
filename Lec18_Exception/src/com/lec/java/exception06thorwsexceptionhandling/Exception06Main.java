package com.lec.java.exception06thorwsexceptionhandling;

/* throws
	 메소드 설계를 할 때 예외 처리를 직접 하지 않는 경우:
	 메소드 이름 뒤에 throws Exception을 추가하면,
	 예외가 발생한 경우에는 메소드를 호출한 곳으로 exception이 던져짐.
	 'Exception' 및 이를 '직접 상속받은' Exception 을 throws 하는 메소드의 경우,
	 이 메소를 호출하는 쪽에서 반.드.시 예외 처리 (handling) 해야 한다. 안하면 에러!
	 
	 
	반면 'RuntimeException' 및 이를 상속받은 예외를 throws 하는 메소드는
	굳이 호출하는 쪽에서 매번 예외 처리 할 필요는 없다

 */
public class Exception06Main {

	public static void main(String[] args) throws Exception /* TODO */ {
		System.out.println("throws");
		
		System.out.println();
		TestClass test = new TestClass();
		int result = test.divide(123, 0);
		System.out.println("result = " + result);
		
		
		System.out.println();
		try {
			test.divide2(123, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// divide2 메소드는  호출한 쪽에서 반. 드. 시  핸들링 해줘야함. 
		// 그러니까 divide2() 에서 익셉션 던졌으니까, divdide2 호출한 메인에서 try~catch 해줘야함.
		// Surround try catch  클릭(suggestion)
		
		// exception 은 throw 하면 반드시 호출한 쪽에서 핸들링 해줘야 하는데,
		// runtime exception 은 핸들링 해줄 필요가 없다. 
		
		test.divide2(111, 0);  // 메인도 자기를 호출한 쪽으로 떠넘길래. 메인메소드 우측에 throws Exception 던짐.
		
		
		
		
		
		
//		test.divide3(222, 0);  // 얘는 빨간줄이 안나. 왜? 런타입익셉션 받았으모. 
		
		// 반드시 try~catch 처리 해줘야 하는 것
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // 1000ms 지연
		//  InterruptedException  -> 나 이거 모르지만, Exception 쓰로우(throws) 했다는 건 알 수 있지. 그러니까 빨간줄이 났지.
		
		
		
		System.out.println("프로그램 종료...");

	} // end main()

} // end class Exception06Main












