package com.lec.java.class04methodchaining;
/*
   클래스 안에서 this : 
	객체 내에서 자기자신(인스턴스)을 가리킴

   메소드 체이닝 (method chaining)
 	자기자신을 리턴하여, 연이어 메소드
 	호출 가능케 하는 메소드 설계
 	보통 setter 와 이와 같은 동작을 수행하는 메소드들에 적용하면 좋다
*/
public class Class04Main {

	public static void main(String[] args) {
		System.out.println("this & 메소드 체이닝");
		
		Number n1 = new Number();
		System.out.println("n1.num = " + n1.getNum()); 
		
		Number n2 = new Number(123);
		n1.add(n2);  // n1 -> 223     n1의 메소드 add 이므로 n1 값의 변화
		System.out.println("n1.num = " + n1.getNum()); 
		
		Number n3 = new Number(10);
		n1.sub(n3); // n1 -> 213
		System.out.println("n1.num = " + n1.getNum()); 
		
		n1.sub(new Number(100));  // n1 -> 113
		System.out.println("n1.num = " + n1.getNum()); 
		
		/*
		 * n1의 뭐.
		 * ~의 뭐. 명사의 뭐.
		 * 
		 * 지금 보면 n1에서 동작해.
		 * 
		 * 여러줄 작성해야 하므로, 한번에 작성하자.   -> // 리턴 타입을 Number 타입으로하고 자기자신을 리턴.
		 */
			
		System.out.println();
		n1.setNum(100);
		
		// string  메소드에서 우리는 이미 사용~
		n1.add(n2).sub(n3).sub(new Number(100)); // -> n1 의 메소드 체이닝. 자기자신을 리턴하여 연이어 자기자신을 리턴. 자바에서는 이런걸 제공.
		// 계속 n1  자기자신을 리턴.
		System.out.println("n1.num = " + n1.getNum()); 

		
		//
		Number n4 = new Number();
		n4.setNum1(10);
		n4.setNum2(20);
		n4.setNum3(30);
		n4.setNum4(40);
		n4.setNum5(50);
		n4.setNum6(60);
		
		// 메소드 체이닝
		n4.setNum1(10)
			.setNum2(20)
			.setNum3(30)
			.setNum4(40)
			.setNum5(50)
			.setNum6(6);
	// 안드로이드에서 이런거 많이 볼 수 있다. 편리하게 사용 가능	
		
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class04Main










