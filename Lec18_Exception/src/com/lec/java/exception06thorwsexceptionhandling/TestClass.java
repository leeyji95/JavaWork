package com.lec.java.exception06thorwsexceptionhandling;
/*
 핸들링 안된  나를 호출한 메인 메소드로 예외를 던져버림. 
 메인도 처리가 안됐으면, 메인을 호출한 
 자바 가상머신에서 예외 핸들링 처리함.
 핸들링될때까지 호출관계를 타고타고 올라감.   
 호출관계가 깊을수록 줄이 길어짐.
 */
public class TestClass {
	
	// 메소드를 설계를 할 때
	// 예외 처리를 메소드 내부에서 (try ~ catch) 로 처리
	public int divide(int x, int y) {
		int result = 0;

		// try ~ catch 처리하기
		try {
			result = x / y;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	} // end divide()
	
	
	// 메소드 설계를 할 때 예외 처리를 직접 하지 않는 경우:
	// 메소드 이름 뒤에 throws Exception을 추가하면,
	// 예외가 발생한 경우에는 메소드를 호출한 곳으로 exception이 던져짐.
	// Exception 및 이를 '직접 상속받은' Exception 을 throws 하는 메소드의 경우,
	// 이 메소를 호출하는 쪽에서 반.드.시 예외 처리 (handling) 해야 한다. 안하면 에러!
	
	
	// TODO : throws 사용하기
	public int divide2(int x, int y) throws Exception {  // throws Exception 추가 
		return x / y;
	} // end divide2()
	
	
	// 반면 'RuntimeException' 및 이를 상속받은 예외를 throws 하는 메소드는
	// 굳이 호출하는 쪽에서 매번 예외 처리 할 필요는 없다
	
	// TODO : throws RuntimeException 사용하기
	public int divide3(int x, int y) throws RuntimeException{
		return x / y;
	} // end divide3()

	
	
} // end class TestClass















