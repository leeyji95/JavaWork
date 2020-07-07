package com.mvn.javaproj2;

import static org.junit.Assert.*;

import org.junit.Test;
/*
1
void assertEquals(boolean expected, boolean actual)
2
void assertFalse(boolean condition)    // false 인지 체크
3
void assertNotNull(Object object)   // Object 가 null 이 아닌지 체크
4
void assertNull(Object object)   // Object 가 null 인지 체크
5
void assertTrue(boolean condition)  // true 인지 체크
6
void fail()   // 무조건 fail
*/

public class TestJunit1 {

	@Test
	public void test() {
		int num = 5;
		String temp = null;
		String str = "안녕하세요";
		
		assertEquals("안녕하세요", str); 
		assertFalse(num > 6);
		// assertFalse(num > 2);
		
		// assertNotNull(temp);
		assertNull(temp); // null이어야 통과
		
		System.out.println(12.3 / 4.1); // double 실수값은 정밀도의 문제가 있다.
		
		// double / float 실수 연산 결과값의 오차범위 delta 값 
		// assertEquals(3.0, 12.3/4.1); // FAIL
		assertEquals(3.0, 12.3/4.1, 0.00001); // PASS  
									// 그래서 내가 정한 오차 이정도까지는 같은 걸로 인정하겠다 -> 세번째 매개변수로 주기
									// 델타 값 : 즉 0.0001 의 오차값까지 인정하겠다.
		
		
	}

}
