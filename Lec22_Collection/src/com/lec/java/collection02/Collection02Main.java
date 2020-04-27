package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator

//		ArrayList<String> strList = new ArrayList<String>();
//		strList.add("안녕하세요 ");
//		strList.add("이예지 ");
//		strList.add("삭제될 것");
//		strList.add("입니다!");
//		strList.add("2");
//			
//		strList.set(1, "저의 ");
//		strList.set(2, "이름은 ");
//		strList.set(4, "삭제");
//		
//		strList.remove(4); //
//	
//		for (int i = 0; i < strList.size(); i++) {
//			System.out.println(strList.get(i));
//		}
//		
//		System.out.println();
//		for(String e : strList) {
//			System.out.println(e);
//		}
//		
//		
//		System.out.println();
//		Iterator<String> itr = strList.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		// 쌤
		ArrayList<String> list = new ArrayList<String>();
		
		// 데이터 저장: add()
//		list.add("Java");
//		list.add("C++");
//		list.add("C#");
//		list.add("Swift");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("5개 문자열을 입력해주세요");
		for(int i = 0; i < 5; i++) {
			list.add(sc.nextLine());
		}
		sc.close();
		
		
		System.out.println("삽입(insertion) 도 add(i, 데이타) ");
		list.add(2, "Python");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 데이터 검색: get(), size()
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 데이터 삭제: remove()
		list.remove(1);
		System.out.println("삭제:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 데이터 수정: set()
		list.set(2, "Object-C");
		System.out.println("수정:");
		
		// enhanced for
		for (String lang : list) {
			System.out.println(lang);
		}
		
		System.out.println("for 를 사용한 출력");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("Enhanced-for 를 사용한 출력");
		for(String i : list) {
			System.out.println(i);
		}
		
		// Iterator 사용
		// ArrayList에 있는 iterator() 메소드를 사용해서 인스턴스 생성
		System.out.println("Iterator 사용:");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












