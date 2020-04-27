package com.lec.java.collection11hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* Map<K, V>, HashMap<K, V>
	 Collection<E>
	  |__ List<E>, Set<E>
	
	 List<E>
	  |__ ArrayList<E>, LinkedList<E>
	
	 Set<E>
	  |__ HashSet<E>, TreeSet<E>
	
	 Map<K, V>
	  |__ HashMap<K, V>, TreeMap<K, V>
	
	 Map: key-value 저장 방식의 자료 구조
	  1. key는 중복되지 않는 값만 허용
	  2. value는 같더라도 key 값이 다르면 저장 가능
	  3. 검색, 수정, 삭제를 할 때 key를 사용
*/

import javax.naming.InitialContext;

import org.omg.CORBA.OMGVMCID;


public class Collection11Main {

	public static void main(String[] args) {
		System.out.println("HashMap 클래스");
		
		// HashMap 인스턴스 생성
		// Key - Integer 타입
		// Value - String 타입
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		
		
		// 데이터 저장: put() 메소드 사용
		// 새로운 key 값이면 null 리턴    --> 없었던 key 값엔 null 리턴. 
		// 기존 key 값이면 기존의 값이 리턴됨 
		System.out.println(hmap.put(1, "장수영"));
		System.out.println(hmap.put(2, "김광진"));
		System.out.println(hmap.put(3, "주낙경"));
		System.out.println(hmap.put(4, "정세헌"));
		System.out.println(hmap.put(4, "조현주"));
		/*
		 	null	
			null
			null
			null
			정세헌
		 */
		// 수정은 해당 키값의 데이터를 바꿔주면 됨.!!!
		
		// 같은 키 값으로 데이터를 put하게 되면, 기존 값이 수정(replace)이 됨.
		// 저장된 데이터 개수 확인 : size()
		System.out.println("데이터 개수: " + hmap.size());
		
		System.out.println();
		
		
		// 데이터 읽기
		// get(key) 사용해서 읽기
		System.out.println(hmap.get(1));
		System.out.println(hmap.get(2));
		System.out.println(hmap.get(5)); // 없는 key 값은 null 리턴  (죽지는 않음0

		
		// 데이터 삭제
		// remove(key) : 삭제된 value 리턴
		System.out.println("삭제: " + hmap.remove(2));  // 2 라는 key 값을 가리킴  --->  2번 키밸류 값은 사라짐. 
		
//------------------------------------------------------------------------------------------------------------		
		// 방법1 HashMap에서 Iterator 사용
		// 1. HashMap의 keySet() 메소드를 사용해서
		// 저장된 키(key)값들로만 이루어진 Set을 만듦.   -> 키만 셋으로 뽀아내고  그것만으로 이터레ㅌ이터 돌려서 값 뽑아냄
		// 2. 1에서 만들어진 Set에 있는 iterator() 메소드를 사용해서
		// Iterator를 생성
		
		Set<Integer> keySet = hmap.keySet(); // 키들로만 이루어진  set 을 뽑아냄
		Iterator<Integer> itr = keySet.iterator();  // set 이 나왔기 때문에 iterator 돌리면 됨.
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + " : " + hmap.get(key));
			
			System.out.println(itr.next() + " : " + hmap.get(itr.next()));
			
			// 한줄로 입력시...   두번을 뽑게 된다.  이 순환문에서 itr.next  두번 호출하게 되는 것    
		}
		
		
		
		System.out.println();
		
		// 방법2 : Map.Entry 사용
		// entrySet() 은 Set<Entry<Integer, String>> 리턴함  키와 밸류로 이루어져 있음. 제너릭 엔트리를 구성하는 셋.... 
		
		// 키와 밸류를 한꺼번에 뽑아내는 방법ㅂ..>!!!
		for(Map.Entry<Integer, String> m : hmap.entrySet()) {  // set 을 리턴, tp셋안에 있는 엔트리 타입. 근데 엔트리 안에는 키와 벨류가 있으므로, 그 값들을 뽑아내는 겟키, 겟밸류 쓴다.       엔트리의 객체를 가지고 있음   {
			System.out.println(m.getKey() + " : ㅡ" + m.getValue());
		}
			
		
		
		
		System.out.println();
		
		// 도전과제                                     // Map 에서 가장 기초적인 알고리즘.....
		// arr[] = {2, 4, 5, 4, 3, 3, 4}           
		// 주어진 배열이 위와 같을때 다음과 같이 발생회수 나타내기 
		// 2 : 1개 
		// 3 : 2개 
		// 4 : 3개 
		// 5 : 1개
		
		// 등장숫자는 키, 등장한 회수는 밸류 
		
		System.out.println("HashMap 응용: 배열에서 발생빈도 구하기");
		int arr[] = {2, 4, 5, 4, 3, 3, 4};
		printFereq(arr);
		System.out.println("\n프로그램 종료");
	} // end main()

	static void printFereq(int arr[]) {
		HashMap<Integer, Integer> hmap= new HashMap<Integer, Integer>();
		
		// 발생빈도
		for (int i = 0; i < arr.length; i++) {
			Integer v = hmap.get(arr[i]); // arr[i] 가 key
			// 처음에 2 키 들어오고, 그러면 처음엔 null로 리턴
			if(v == null) // 기존에 해당 key 값 없었다면 (즉! 첫 등장이면 )
				hmap.put(arr[i], 1); // 등장횟수 1
			else
				hmap.put(arr[i], v + 1); // 기존에 등장했었다. 최소한 한 번 등장했다.   기존에 등장했던 횟수는 v 가 가지고 있으므로....
		}		
		
		// 결과 출력
		for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
			System.out.println("숫자 " + e.getKey() + " : " + e.getValue() + "개");
		}
		
	}
	
} // end class















