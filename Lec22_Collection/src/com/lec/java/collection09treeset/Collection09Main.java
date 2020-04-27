package com.lec.java.collection09treeset;

import java.util.Iterator;
import java.util.TreeSet;

/* TreeSet

 Collection<E>
  |__ Set<E>
       |__ HashSet<E>, TreeSet<E>

 TreeSet: 데이터가 정렬된 상태로 저장(오름차순, 내림차순) ____   Tree~~  형태의 자료구조 만났다면, 정렬에 특화. hash~~ 는 검색에 특화 
 
 	(※ TreeXXX ← 주로 '정렬'에 특화된 자료구조 입니다)
*/
public class Collection09Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 클래스");
		
		// Integer 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		// 데이터 저장 : add()
		tset.add(11);
		tset.add(2);
		tset.add(14);
		tset.add(1);
		tset.add(7);
		tset.add(15);
		tset.add(5);
		tset.add(8);


		
		// 데이터 검색 - Iterator 사용
		// TreeSet인 경우에 iterator() 메소드 오름차순 정렬
		System.out.println("오름차순:");
		Iterator<Integer> itr = tset.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// set 은 순서 상관 없음
		// 트리셋은 애초에 저장될 때마다 차곡차곡  정렬된 상태로 저장이 된다.
		
		
		System.out.println();
		System.out.println("내림차순:");
		// 내림차순 Iterator : descendingIterator() 사용
		Iterator<Integer> itr2 = tset.descendingIterator();  // 애는 역순으로 줄을 세움 
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		// enhanced for
		System.out.println();
		System.out.println("enhanced for");
		for(Integer e : tset) {
			System.out.println(e);
		} // enhanced for는 기본적으로 오름차순으로 나옴 
		
		
		
		
		
		
		
	//-------------------------------------------------------복습 요망 ------------------------------------------------------------------------------------------------	
		// 정렬된 트리셋에서 원하는 구간만 뽑아내기
		
		// subset() 메소드
		// 시작값과 끝값을 매개변수로 받아, 그것을 범위로, 부분 Set 추출
		System.out.println("\nsubset()");
		TreeSet<Integer> subSet = (TreeSet<Integer>)tset.subSet(5, 14); // Sorted Treeset 으로 리턴되므로, TressSet<Integer> 타입으로 형변환 해주자
//		for(Integer e: subSet) {
//			System.out.println(e);  // 5에서 14 전까지  만 뽑아냄. 
//		}							// 정렬되어 있기 때문에 특정구간만 뽑을 수 있다.
		System.out.println(subSet);  // 기본적으로 toString 오버라이딩 되어 있기 때문에 -> 굳이 for 문이나 iterator 안 써도 된다. 
		
		subSet = (TreeSet<Integer>)tset.subSet(5, true, 14, true); // 5를 포함하겠다, 14 를 포함하곘다는 뜻.  포함해서 출력된다. 
		System.out.println(subSet);
		
		
		subSet = (TreeSet<Integer>)tset.subSet(3, 10); // 꼭 있는 데이터로만 뽑을 수 있는 건 아니다.   3과 10이라는 데이터가 없어도, 대소비교를 해서 3다음 큰 수, 10전까지의 수 그러니까 9까지. 9보다 작은 수 안에서 출력한다. 
		System.out.println(subSet);					 // 두 객체의 비교 정의 내릴 수 있음 나중에..
												   // 기본적으로 정렬되어 있다는 건 대소비교를 할 수 있다는 뜻이므로 
				
		//-------------------------------------------------------복습 요망 ------------------------------------------------------------------------------------------------	
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












