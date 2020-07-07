package com.mvn.javaproj2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
// 알아서 test 폴더에 해당 test 클래스를 만들어 준다. 그대로 finish!
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
		assertEquals("welcome", app.getWelcome()); // 결과값을 비교. 첫번째 매개변수 결과값과, 두번째 매개변수의 결과값이 같아야함.
													// 통과되면 그린바 나옴.
		assertEquals("hello", app.getHello());
		assertEquals("bye", app.getBye());
	}

	@Test // 골뱅이 test 붙으면 테스트 메소드 이다.
	public void test2() {
		assertEquals("Bye", app.getBye());
	}

	@Test // 이 메소드만(특정 메소드만 test 수행하고 싶다면 )===> 메소드 위에 커서 대고 F11 또는 Run on Server 에서 junit
			// test 실행
	public void test3() {
		assertEquals("hello", app.getHello());
	}

	/*
	 * JUNIT 에서 내가 작성한 메소드는 내가 작성한 순서대로 작동하지 않는다. 말그대로 단위테스트이므로 각각의 메소드를 독립적으로 순서없이 실행한다.
	 * 각각의 메소드는 개별적이고 독립적으로 테스트를 진행한다.


	 * 그렇기 때문에 이미 한 번 만들어 놓은 객체로 다음 메소드를 실행하게 되면 다음 메소드에 영향을 줄 수 있다. 
	 * -> 이러한 이유로 Junit 에서 객체를 멤버필드로 놓고 사용하는 것은 추천하지 않는다. 
	  
	  
	 * 테스트할 메소드들에 대한 시나리오(메소드)를 만들어 놓고, 일괄적으로 돌린다. 
	 * 내가 만드는 것의 중간과정을 확인하는 것이고, 이는 개발과정에서 매우 중요하다
	 * 
	 */

}
