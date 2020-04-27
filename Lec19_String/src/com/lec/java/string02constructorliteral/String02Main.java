package com.lec.java.string02constructorliteral;
/*
 * Ada Lovelace  최초 여성 프로그래머

1교시

자바의 단점 중 하나가 익셉션. 타 언어에 비해 복잡성이 좀 있음 

String 02
literal - 코드상에 직접 입력한 문자 
String  은 프리미티브 타입이 아닌데에도, 쌍따옴표 안에 입력하면, String literal 임

메모리 그림으로 이해 (노트 참고)  스트링 비교
intern() compareTo() 


스트링 클래스의 뮤터블,  이뮤터블
	
2 교시
스트링 객체가 내부적으로 2개가 생김.
긍까 “Hello” 라는 스트링객체가 생기고 그걸 레퍼런싱하고 있는 스트링 객체가 또하나생김.
-> 어디에? M`A 
 

스트링객체 안에 있는 리터럴이 변할 수 없음. (immutable)


concat 은 무조건 계속 소멸 다시 생성 반복해야해.
append 는 안에 내용만 계속 바뀜.
속도가 더 빠름. 


 * 
 */
/* String 생성자, String literal(상수)
 */
public class String02Main {

	public static void main(String[] args) {
		System.out.println("String 생성자, literal(상수)");
		
		int num1 = 1;
		int num2 = 1;
		
		if (num1 == num2) {
			System.out.println("같은 숫자");
		} else {
			System.out.println("다른 숫자");
		}
		
		System.out.println();
		System.out.println("[1] String literal 사용");
		// "Hello"는 literal이기 때문에, 한 번 만들어지면 재사용됨
		// 그래서, str1과 str2는 같은 곳(주소)에 있는 문자열 "Hello"를 가리키게 됨
		// 즉, str1과 str2에는 같은 값이 저장되게 됨
		String str1 = "Hello";   
		String str2 = "Hello";

		
		if(str1 == str2) {
			System.out.println("동일한 곳(문자열) 참조");
		} else {
			System.out.println("다른 곳(문자열) 참조");
		}
		// -> 이건 주소를 비교한 것. 
		
		
		System.out.println();
		System.out.println("[2] String 생성자 사용");
		// 생성자는 호출될 때마다 새로운 인스턴스를 힙에 생성하게 됨
		// str3과 str4는 서로 다른 인스턴스를 가리키게 됨
		// 즉, str3과 str4에는 서로 다른 값이 저장되게 됨
		String str3 = new String("Hello");
		String str4 = new String("Hello");

		if(str3 == str4) {
			System.out.println("동일한 곳(문자열) 참조");
		} else {
			System.out.println("다른 곳(문자열) 참조");
		}
		
		System.out.println();
		System.out.println("[2-2] String intern() 결과 비교");  // str 1 2 3 4  내부적으로 동일한 메소드에리어의 동일한 스트링 리터럴을 참조 하고 있음을 보여줌. 그러나 실무에서는 거의 안쓰임. 이런게 있구나 정도로 알고 있기. 
		// intern() String 객체가 실제로 참조하는 문자열 리턴
		if(str3.intern() == str4.intern()) {
			System.out.println("intern() 동일한(문자열) 참조");
		} else {
			System.out.println("intern() 다른(문자열) 참조");
		}
		
		if(str1.intern() == str4.intern()) {
			System.out.println("intern() 동일한(문자열) 참조");
		} else {
			System.out.println("intern() 다른(문자열) 참조");
		}
		
		
		
		// == 연산자는 실제 문자열이 같은 지 다른 지를 비교하는 것이 아니고,
		// 참조 변수(지역 변수) str3과 str4에 저장된 값(주소)가  같은 지 다른 지를 비교하는 것임.
		// 문자열 비교를 == 으로 하지 말것!!!!
				
		
		System.out.println();
		System.out.println("[3] String equals() 메소드");
		// 문자열 비교는 equals() 사용하자.  참고로 equals() 는 Object 의 메소드다.   
		
		if(str3.equals(str4)) {
			System.out.println("equals() 같은 문자열");
		} else {
			System.out.println("equals() 다른 문자열");
		}
		
		
		
		
		System.out.println();
		System.out.println("[4] String compareTo() 메소드");
		// compareTo() 는 두 문자열의 문자코드량 의 비교 (lexicographical comparison based on the Unicode value)
		// 이경우 유니코드 값을 비교하게 됨.
		
		System.out.println("compareTo: " + str3.compareTo(str4));		// 같으면 0 
		String str5 = "A";
		String str6 = "C";
		System.out.println("compareTo: " + str5.compareTo(str6));		// A - C 뺀 값
		// 코드값의 변량값이 출력됨.
		// 중요한 핵심 :  같으면 0  왼쪽이 더 작으면  음수가 나오고,  쩜 왼쪽 값이 더 크면 양수가 나온다.  ->   
		
		str5 = "xaAa";
		str6 = "xAaA";
		System.out.println("compareTo: " + str5.compareTo(str6));  // -32
		System.out.println("compareTo: " + str6.compareTo(str5));  // 32
		
		// 같으면 넘어가고, 달리진 결과값이 출력된다.   
		

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











