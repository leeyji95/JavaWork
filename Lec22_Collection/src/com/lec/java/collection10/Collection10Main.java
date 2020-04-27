package com.lec.java.collection10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		
		TreeSet<String> tset = new TreeSet<String>();  // String 타입 저장할 수 있는 TreeSet 인스턴스 생성
		
		
		// 데이터 5개 저장
//		tset.add("ghtyeh");
//		tset.add("kkkkkkk");
//		tset.add("cccccc");
//		tset.add("iiii");
//		tset.add("opopopop");
//		
//		Iterator<String> itr = tset.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		
//		System.out.println();
//		itr = tset.descendingIterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		
		
		
		tset.add("AaAa 1"); // 1.
		tset.add("aaaa 2"); // 2.
		tset.add("aAaA 3"); // 3.
		tset.add("AAaa 4"); // 4.
		tset.add("aaAA 5"); // 5.
		// 오름 차순 결과 4 1 3 5 2
		
		// 데이터 검색 - Iterator(오름차순, 내림차순)
		Iterator<String> itr = tset.iterator();
		System.out.println("오름차순:");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		System.out.println("내림차순:");
		Iterator<String> itr2 = tset.descendingIterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















