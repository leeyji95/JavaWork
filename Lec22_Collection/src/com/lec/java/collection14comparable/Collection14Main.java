package com.lec.java.collection14comparable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* java.util.Collections 클래스
	 Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
	 대부분 클래스메소드 (static) 형태로 제공됨
	 
	 정렬(sort)
	 섞기(shuffle)
	 탐색(search)
 */

public class Collection14Main {

	public static void main(String[] args) throws ParseException  {
		System.out.println("Collections 메소드");

		List<String> list1 = new LinkedList<String>();  // List 는 LinkedList 의 부모(다형성)
		
		list1.add("장수영");
		list1.add("김진영");
		list1.add("고유성");
		
		System.out.println(list1); // List 의 toString() 결과 형태 출력 
		
		
		System.out.println("sort()");
		// sort()
		// 기본적으로 속도가 비교적 빠르고 안전성이 보장되는 Merge Sort 사용
		Collections.sort(list1);
		System.out.println(list1); // 정렬 후 결과! 
		
		System.out.println();
		List<Date> list2 = new LinkedList<Date>();   // util.Date  import 
		//"201-02-16" --> Date 객체 로 변환
		// 일단 내가 입력할 문자열이 이러한 형식입니다를 알려주고, 이거를 parse 해준다.   전체가 DAte 객체 로 리턴. 이거를  list2 에 저장(추가)
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-16"));
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2017-05-21"));
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-03"));   
		System.out.println(list2);  // 기본적으로 toString() 되어 있음(좀 드럽게 나옴) 이게 중요한게 아님
		
		Collections.sort(list2); // 날짜 오름차순 정렬 -> sort() 메소드 역할
		System.out.println(list2);
		
		
		// String 타입이면 알파벳 순으로 정렬된다.
		// Date 타입이면 날짜순으로 정렬된다
		// ★ String 과 Date 는 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문.
		// ※ String 온라인 도움말 확인해보자
	
		System.out.println();
		List<Student> list3 = new LinkedList<Student>();
		list3.add(new Student("Susie", 50)); // 저장할 때 동시에 Student  객체 생성해서  저장해둠 - > Student 클래스의 멤버변수에 접근.
		list3.add(new Student("James", 80));
		list3.add(new Student("Kevin", 30));
		System.out.println(list3);  // 모두 list3에 담겨짐.
		
		System.out.println("Comparable 구현, sort() 적용");
		//  정렬을 하려면 대소관계가 있어야 함. 근데 문자열의 경우 대소비교가 어떻게 가능한가? 
		// 기본적으로 Comparable<T> 이 기본적으로 구현이 되어 있어야 한다.  ------------> String 객체와 Date 객체에 모두 comparable 이 impliments 되어 있다. (온라인) 		
		// 아래 Student 에 comparable implements  오버라이딩 하기. 
		Collections.sort(list3);  // Student 에 Comparable<> 구현 안 되어 있으면 에러!
		// Comparable<> 구현 1후0 실행해야 함.
		System.out.println(list3);   // 정렬 후 출력
		
		
		
		// 역순 정렬
		System.out.println("reverseOrder() 적용");
		Collections.sort(list3, Collections.reverseOrder());  // Student 타입을 가진 comparator 를 리턴함.  
		System.out.println(list3);
		
		// comparable 비교 말고도 추가적으로 정렬조건을 제공하고 싶을 떄는 comparator 를 사용한다. 
		
		// TreeMap 은 기본적으로 key 에 대해 정렬. 그럼 value 값 정렬은 ?
		// Map에서 value값에 대한  정렬 만들때 이걸 사용해야 함. 
		
		
		
		System.out.println("reverse() 적용");
		Collections.reverse(list3);
		System.out.println(list3);
		
		//============================= 위에는 점수들로 정렬한 것. 이때 나는 이름순으로 정렬하고 싶을 떄 아래 comparator 를 사용하한다
		
		// Comparator<> 적용
		// Collections.sort 메소드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 해놓았습니다.
		// Comparator 인터페이스의 compare 메소드를 오버라이드 하면 됩니다.
		System.out.println("Comparator<> 적용");
		Collections.sort(list3, new Asc()); // '이름' 오름차순으로 정렬됨
		System.out.println(list3);
		
		// '이름' 내림차순
		Collections.sort(list3, new Desc());
		System.out.println(list3);
		
		
		
		
		
		// Collections 에서 많이 쓰이는 인터페이스임
		// Comparable 은 클래스 자체에 구현하는 인터페이스  compareTo(자기사진 vs 매개변수)
		// Comparator 는 두개의 객체 비교하는 기능제공 인터페이스  compare(매개변수1 vs 매개변수2)
		//      구현된 객체가 매개변수 등에 넘겨지는 형태로 많이 쓰임
		
		// Shuffling 하기 (섞기)
		System.out.println();
		System.out.println("shuffle()");
		Collections.shuffle(list1);
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);
		
		System.out.println();
		String [] arr = {"aaa", "bbb", "ccc", "ddd", "gggg", "eeee", "wwww", "ttt", "yyy"};   
		// 배열을 shuffle 이 없으므로 컬렉션의 배열리스트로 만들자
		List<String> arrList = Arrays.asList(arr); // 배열을 --> List<> 변환 해줌 asList() 메소드   (List<> 의 toArray() 의 반대)
		Collections.shuffle(arrList);
		arrList = arrList.subList(0, 3);  // index  0 부터 3 전까지의 List<> 생성  // 랜덤으로 3개 뽑힘
		System.out.println(arrList);
//		Arrays.(type[]) collection.toArray(new type[collection.size()])
		
	
		
		
		// min(), max()
		// Comparable 메소드 영향 받음
		System.out.println();
		System.out.println("min(), max()");
		System.out.println(Collections.min(list1));  // 고유성
		System.out.println(Collections.max(list1));  // 장수영
		System.out.println(Collections.min(list3));
		System.out.println(Collections.max(list3));

		
		
		
		
		
		// copy()
		System.out.println();
		List<Student> list4 = new LinkedList<Student>();
		list4.add(new Student("aaa", 10));
		list4.add(new Student("bbb", 20));
		list4.add(new Student("ccc", 30));
		
		System.out.println("copy() 전");
		System.out.println(list4);   // [aaa:10.0점, bbb:20.0점, ccc:30.0점]
		System.out.println("copy() 후");
		Collections.copy(list4, list3); // 뒤에 있는 애가 앞에 있는 애한테로 카피됨. 
		System.out.println(list4);   // [Susie:50.0점, Kevin:30.0점, James:80.0점]
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

// 우선은 Comparable 구현 없이 해보자
class Student implements Comparable<Student> {    //  comparable 을 implements 하자. 
	String name;
	double point;
	
	public Student(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.point + "점";
	}

	// compareTo() 메소드는 매개변수 객체를 '자신' 과 비교하여 
	// 작으면 음수, 같으면 0, 크면 양수를 리턴한다.
	@Override
	public int compareTo(Student o) {  // Add unimplemented // 구현된 객체를 매개변수로 받아 넘겨줌. 그래서 객체타입 쩜. 매개변수에 접근할 수 있는것   //   Ctrl + H -> File Search -> compareTo, .*java
		// 점수 오름차순   --> 순서에 대한 얘기, 누가 앞에 올것인가. 
//		if(o.point > this.point) return -1; // 내가 더 작으면 음수 
//		if(this.point > o.point) return 1; // 내가 더 크면 양수
//		return 0;  // 같으면 0

		// 점수 내림차순(80-> 50 -> 30)
		if(o.point < this.point) return -1; // 내가 더 작으면 음수 
		if(this.point < o.point) return 1; // 내가 더 크면 양수
		return 0;  // 같으면 0
		
	}
	
	
	
} // end class


// Student 를 이름 (name)으로 정렬해줄 수 있는 Comparator<> 제공 
class Asc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {  // 두개의 Student  타입의 매개변수를 받아 그 둘을 비교함 
		 // comparator 만들어 보자   comparator 도 인터페이스 이므로   구현하자.
		// 이름
//		int result = o1.name.compareTo(o2.name); 
		return o1.name.compareTo(o2.name); 
	}
} // end Asc


class Desc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.name.compareTo(o1.name);
	}
} // end Asc

