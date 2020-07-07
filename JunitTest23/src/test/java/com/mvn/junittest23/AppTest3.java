package com.mvn.junittest23;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AppTest3 {
	
	private String expected;
	private String str;
	
	@Parameters
	public static Collection<String[]> getTestParameters(){
		return Arrays.asList(new String[][] {
			{"01012345678", "010-1234-5678"},
			{"01089786756", "010-8978-6756"},
			{"01088389898", "010-8838-9898"}
		});
	}
	
	public AppTest3(String expected, String str) {
		super();
		System.out.println("AppTest3() 생성!");
		this.expected = expected;
		this.str = str;
	}
	
	// 실습 3
	@Test
	public void test3() {
		App app = new App();
		assertEquals(expected, app.toNumber(str));
		System.out.println("테스트 통과: " + expected + ", " + str);
	} // end test3()
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}

} // end AppTest3
