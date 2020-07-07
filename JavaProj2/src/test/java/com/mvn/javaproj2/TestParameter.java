package com.mvn.javaproj2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * JUnit 파라미터화 테스트(Parameterized Test)
 * 
 * 동일한 테스트를 @Parameters 컬렉션의 원소 개수만큼 반복 실행
 * Parameterized 클래스는 JUnit이 제공하는 많은 테스트 러너중 하나
 */

@RunWith(value = Parameterized.class)
public class TestParameter {

	private int expected;
	private int valueOne;
	private int valueTwo;
	
	@Parameters
	public static Collection<Integer[]> getTestParameters(){ // 파라메타라이징 하는 것 // 스태택 으로 컬렉션 타입을 넘겨주는 것이 필요 
		return Arrays.asList(new Integer[][] {
			{2, 1, 1},  // <-- 이게 parameter 세트 덩어리가 들어간다. 
			{3, 2, 1},
			{4, 3, 1},
			{5, 2, 3}
		});
	}
//	하나의 세트가 1차원, 이걸 여러개 담은 것이 2차원 배열이다. 
//	이렇게 리턴하는 겟파라미터를 스태틱으로 리턴한다..
	
	public TestParameter(int expected, int valueOne, int valueTwo) { // 생성자(매개변수)
		System.out.println("TestParameter() 생성");
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	@Test
	public void sum() {
		Calculator cal = new Calculator();
		assertEquals(expected, cal.add(valueOne, valueTwo));
		System.out.println("테스트 통과: " + expected + ", " + valueOne + ", " + valueTwo);
	}	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}
	

}
























