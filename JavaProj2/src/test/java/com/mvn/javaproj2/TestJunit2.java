package com.mvn.javaproj2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestJunit2 extends TestCase {
	
	
	@Before   // 테스트 메소드 실행전에 수행할 메소드
	public void before() {
		System.out.println("[before()]");
	}
	
	@After  // 테스트 메소드 실행후에 수행할 메소드 
	public void after() {
		System.out.println("[after()]");
	}
	
	// static : 인스턴스 생성 하기 전에 딱 한 번 실행된다. 
	@BeforeClass   
	public static void BeforeClass() {
		System.out.println("<<BeforeClass()>>");
	}
	@AfterClass   
	public static void AfterClass() {
		System.out.println("<<AfterClass()>>");
	}
	
	// countTestCases() : 해당 메소드를 여러번 수행할 때, 몇 번째 수행되는지 출력할 수 있다.
	@Test
	public void testA() {
		System.out.println("testA() 실행");
		System.out.println("No. of Test Case = " + this.countTestCases());
		setName("B테스트 입니다.");
		System.out.println("Test Case Name = " + this.getName());
	}	
	@Test
	public void testB() {
		System.out.println("testB() 실행");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}	
	@Test
	public void testC() {
		System.out.println("testC() 실행");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}	
	@Test
	public void testD() {
		System.out.println("testD() 실행");
		System.out.println("No. of Test Case = " + this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	

}
