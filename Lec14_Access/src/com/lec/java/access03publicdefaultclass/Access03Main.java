package com.lec.java.access03publicdefaultclass;

import com.lec.java.access04with03test.TestPublic2;

// 다른 패키지의 (default) 클래스는 import 불가   --> default 는 import 자체가 안된다느 사실.
//import com.lec.java.access04.MyDefault2;  // import 자체에서 문제 발생. 같은 패키지에 없어서 에러 뜨는 것이 아니라. 

//import com.lec.java.access04.TestPublic;  // 패키지 4번에 있는 동일한 이름의  TestPublic 클래스 사용시 03 메인에서 04메인의 TestPublic 을 쓴다


// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		TestPublic t1 = new TestPublic();
		
		// 같은 패키지에 있는 클래스에서는 인스턴스 생성(사용) 가능
		MyDefault t2 =  new MyDefault();
				
		// 다른 패키지에 있는 public 클래스
		// --> 인스턴스 생성 가능!
		TestPublic2 t3 = new TestPublic2();  // import
		
		// 다른 패키지에 있는 (default) 클래스
		// --> 인스턴스 생성 불가!
	//	MyDefault2 t4;
		
		// 다른 패키지의 클래스와 동일 이륾의 클래스가 충돌된다면?  -->   풀네임 써야함.(에지간하면 이런 상황 만들지 말자)
		com.lec.java.access04with03test.TestPublic t11 =
				new com.lec.java.access04with03test.TestPublic();
		

		
	} // end main()

} // end class Access05Main










