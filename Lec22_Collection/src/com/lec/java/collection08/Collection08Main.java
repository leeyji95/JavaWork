package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enhanced-for 등을 
		// 사용하여 출력해보기
		HashSet<MyClass> set = new HashSet<MyClass>();
		
		// 데이터 3개 저장
		MyClass mc1 = new MyClass(1, "Abc");
		MyClass mc2 = new MyClass(2, "fgre");
		MyClass mc3 = new MyClass(1, "Abc");
		set.add(mc1);
		set.add(mc2);
		set.add(mc3);
		System.out.println("size: "  + set.size());
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		System.out.println("enhanced for");
		for(MyClass e : set) {
			System.out.println(e);
		}

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		/*
		 * Myclass 에서 
		 * 세번째는 첫번째거랑 동일하게 돔. 
		 * 내가 만든 클래스에 대해서 동등성에 대해서 이퀄스랑 해시코드값으로 만들어 줄 수 있다. 
		 * 
		 * 만약에 대소문자 안가리게 하려면. equalsIgnoreCase ()  하면 된다. 
		 * 
		 * 해시코드라는게 이 객체에서 표현하는 사바이트짜리 정수값.
		 * 
		 * 
		 * 아무튼 내가 만든 클래스에서 동등성에 있게 출력하려면, 
		 * equals 와 hashcode 를 오버라이딩 해주면 된다. 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		System.out.println("\n프로그램 종료");
		
		
		
		
	} // end main()
	
	
	
	
} // end class

