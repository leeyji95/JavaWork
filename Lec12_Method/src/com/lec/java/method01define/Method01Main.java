package com.lec.java.method01define;

/* 메소드 (Method):
 		반복되는 코드, 내용, 재사용해야할 코드들을 한 뭉치로 묶어서
 		따로 메소드로 만들은 다음(정의) 이를 필요할때마다 사용(호출)한다. 
 		
 		※ 자바는 '함수(function)' 가 따로 없습니다
 		  그러나 교육하면서 편의상, 혼용하여 말하겠습니다.
 		
	 메소드 정의:
	 	메소드는 main 메소드 바깥에서!!, class 안에서 정의!!

	 메소드 정의구문:
		수식어        리턴타입              메소드이름(매개변수, ...) { ... }
	    modifier return_type  method_name(parameter, ...) { ... }
	
		수식어(modifier) : public, static, private, ... (생략 가능)
	   
		매개변수 (parameter) : 메소드 호출시 넘겨주는 값.

		리턴타입 (return type) : 메소드 종료후 호출한 쪽에 돌려주는 값
			void, int, double, String ...
			(리턴타입 void의 의미는 되돌려주는 값(return 값)이 없다는 의미)
	
	메소드 signature 란?:
		메소드 이름 + 매개변수 리스트 (매개변수 타입, 순서, 개수)
			sayAge(int)
			sayHello3(String, int)
			
*/

/*
 * Addd bbb; 변수 선언
 * Addd(ddd, dd);  Adddd메소드 호출구문
 * 
 * 수행구문이 메소드 만나면 멈추고 메소드 구문으로 넘어감.
 * 메소드 호출이 끝난 후 호출한 쪽으로 돌아감.    
 * 
 * 리턴 : 끝나고 호출한 쪽으로 돌아오는 것을 말함.
 * 
 * main 메소드가 sayHello 메소드를 호출한 것
 * 
 */
public class Method01Main {
	
	public static void main(String[] args) {
		System.out.println("메소드(함수) Method(Function)");
		
		System.out.println("안녕하세요");
		System.out.println("제 이름은 윤종섭 입니다");
		
		System.out.println("안녕하세요");
		System.out.println("제 이름은 이강혁입니다");
		
		System.out.println();
		System.out.println("메소드 사용(호출)");
		
		// 메소드 호출구문
		// 메소드 이름(매개변수 값(들...)
		sayHello("장수영");  // String 타입의 매개변수를 넣어준다.
		sayHello("고유성");
		
		System.out.println();
		sayAge(16);
		sayAge(20);
		
		System.out.println();
		sayHello2("김우경", 25);
		// 정의되어 있는 매개변수 리스트
		//sayHello2(100, 100); // not applicable for the arguments 에서 (정의 되지 않은 메소드 입니다)

		
		System.out.println();
		sayHello3("방석민", 26);
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
//-------------------------------------[메소드 정의]-------------------------------------------------------- 
// **** 메소드 정의는, class 안에, main 바깥에 !!!!!     
//자바는 메소드 안에 메소드 정의 하지 않는다. ****
	
	// 메소드 이름 :  sayHello
	// 매개변수 : name  (매개변수가 필요  없는 경우는 생략가능)
	
	// 메소드 위에 아래와 같이 javadoc 타입 주석 달 수 있다. (내가 만들어 놓은 메소드 설명하기 위한)
	/**
	 *        (주석은 주석인데, 특별한 주석
	 * 메소드 이름 : sayHello 
	 * 주어진 이름을 출력합니다. 
	 * @param name 이름
	 */
	public static void sayHello(String name) {
		// 메소드 수행본체
		System.out.println("안녕하세요");
		System.out.println("제 이름은 " + name + " 입니다" );
	} // end sayHello
	
	// 메소드 이름: sayAge
	// 매개변수 : int 타입의 age
	// 리턴타입 : void(리턴값이 없다)
	public static void sayAge(int age) {
		System.out.println("hi~");
		System.out.println("제 나이는 " + age + " 입니다.");
	} // end sayAge()
	
	// 메소드 이름: sayHello2
	// 매개변수:
	//	1) String name
	// 	2) int age
	// 리턴타입 : void
	public static void sayHello2(String name, int age) {
		System.out.println("안녕!");
		System.out.println("내 이름은 " + name + " 입니다");
		System.out.println("내 나이는 " + age + " 살 입니다");
	} // end sayHello2
	
	
	public static void sayHello3(String name, int age) {
		sayHello(name);
		sayAge(age);
	} // end sayello3
	
	
	

} // end class

/*
 * 이클립스 단축키 : 메소드 이름위에서
 * 	F3 : Open Declaration  (이 메소드 는 어디서 정의?)
 * 	CTRL + ALT + H : Open Call Hierarchy (이 메소드는 어디서 호출되나?)  
 * 
 * 디버깅 :
 *   step into : 현재 디버깅 위치의 메소드 호출 내부 코드 진입
 *   step out (step return) : 현재 디버깅 진행중인 메소드 return 까지 진행후 호출한 측으로 돌아감
 *   resume : 다음 breakpoint 까지 쭈욱 진행 
 */


/*
 * 
step into  -> 호출한 메소드 안으로 들어감
step over -> 메인에서 한줄한줄 수행

디버깅 좌측 보면,  메인이 메소드 호출한 것을 볼 수 있음.

step out -> 리턴 한 곳으로 이동(현재 내가 머물러 있는 메소드 탈출)

좌측상단 : 어느 메소드가 어느 매소드  호출했는지 
그 관계를 알 수 있음.


디버깅을 자유자재로 할 수 있도록!
디버깅 실력이 곧 프밍실력!

F3 -> 어디서 정의되어 있는 메소드 인지 찾을 때
정의되어 있는 메소드

 */





