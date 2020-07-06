package com.mvn.javaproj2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
// JUnit 으로 테스트 동작시킬 클래스와 메소드는 모두 public 으로 

public class AppTest {

	private App app = new App();
	
	@Test
	public void test1() {
//		if("welcome".equals(app.getWelcome())) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
		
		// assertXXX() 메소드 사용 <-- 결과값 검증할 때 많이 사용하는 메소드이다.
		// 통과하는지 안하는지에 대한 여부를 판단할 떄
		// JUnit 패키지 안에 assert~() 메소드가 많다. 검증할 때 거의 이걸 사용한다
		assertEquals("welcome", app.getWelcome());  // 결과값을 비교. 첫번째 매개변수 결과값과, 두번째 매개변수의 결과값이 같아야함. 
													// 통과되면 그린바 나옴.
		assertEquals("hello", app.getHello());
		assertEquals("bye", app.getBye());
	}
		
	@Test  // 골뱅이 test 붙으면 테스트 메소드 이다.	
	public void test2() {
		assertEquals("Bye", app.getBye());
	}
		
	@Test   // 이 메소드만(특정 메소드만 test 수행하고 싶다면 )===> 메소드 위에 커서 대고 F11 또는 Run on Server 에서 junit test 실행  
	public void test3() {
		assertEquals("hello", app.getHello());
	}

	
	
	

}
