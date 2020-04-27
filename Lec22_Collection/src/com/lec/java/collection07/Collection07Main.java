package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기   --------> for문 사용할 수 없다. 왜?순서가 없으므로
		
		HashSet<String> set = new HashSet<String>();
		
		System.out.println("add 결과: " + set.add("One"));
		System.out.println("add 결과: " + set.add("Two"));
		System.out.println("add 결과: " + set.add("Three"));
		System.out.println("add 결과: " + set.add("Four"));
		System.out.println("add 결과: " + set.add("Five"));
		System.out.println("add 결과: " + set.add("Two"));
		System.out.println("add 결과: " + set.add("Three"));
		
		System.out.println();
		System.out.println("데이터 저장");
		System.out.println("데이터 개수: " + set.size());
		
		
		
		
		
		for(String e : set) {
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















