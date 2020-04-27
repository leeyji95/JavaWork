package com.lec.java.collection12treemap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

// Hash: 검색을 빠르게 하기 위한 용도
// Tree: 데이터 정렬을 하기 위한 용도

public class Collection12Main {

	public static void main(String[] args) {  // 키에 대해서 정렬되어 있음 
		System.out.println("TreeMap 클래스");
		
		// TreeMap<Integer, String> 타입 인스턴스 생성
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		
		// 데이터 저장: put(key, value) 메소드 사용
		tmap.put(1, "aaa");
		tmap.put(4, "wqery");
		tmap.put(3, "asdfg");
		tmap.put(2, "rtiiyj");
		// 키로 이루어진것만 뽑아 낸 건 kset 이었다. 키는 중복되지 않기 때문에 set으로 뽑을 수 있었다. 
		// 그러면 이번엔 밸류들로만 이루어진 애들만 뽑아보자.
		
		// values() : value 들로 이루어진 Collection 리턴
		System.out.println("values()");
		for(String value: tmap.values()) {
			System.out.println(value);
		}
		
		// 데이터 검색: get(key) 메소드를 사용
		// 1. 키값들로만 이루어진 Set을 만듬
		Set<Integer> kset = tmap.keySet();
		Iterator<Integer> itr = kset.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + " : " + tmap.get(key));
		}
		
		// 2. keySet을 가지고 iterator를 만듬
		
		
		System.out.println();
		
		
		// TreeMap에만 있는 KeySet을 만들어 내는 메소드
		NavigableSet<Integer> navi = tmap.navigableKeySet(); // set 은 set 인데... 
		Iterator<Integer> itr2 = navi.descendingIterator();
		while(itr.hasNext()) {
			int key = itr2.next();
			System.out.println(key + " : " + tmap.get(key));
		}
		
		// HashMap --> TreeMap 전환하기
		System.out.println("HashMap() -> TreeMap() ");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();	
		hmap.put("세종대왕", 10000);
		hmap.put("신사임당", 50000);
		hmap.put("퇴계이황", 1000);
		hmap.put("이순신", 100);
		
		
		System.out.println(hmap);
		
		TreeMap<String, Integer> tmap2 = new TreeMap<String, Integer>(hmap); 
		
		System.out.println(tmap2);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class


















