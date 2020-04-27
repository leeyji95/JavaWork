package com.lec.java.lambda01annoylambdacomparasion;

/* 람다 표현식: lambda-expression
 	Java8 부터 도입:
		(매개변수 리스트) -> 리턴값
		(매개변수 리스트) -> {...}  수행코드

	추상메소드가 하나인 인터페이스 구현, 즉 익명클래스사용 더 간략화한 표현식
 */
public class Lambda01Main {

	public static void main(String[] args) {
		System.out.println("인터페이스, 익명 클래스, 람다 표현식");
		
		System.out.println();
		System.out.println("[1] 인터페이스를 구현하는 클래스");
		Addable myAdder = new AdderImple();
		double result = myAdder.add(1.11, 2.22);
		System.out.println("result = " + result);
		
//-----------------------------------------------------------------------				
		System.out.println();
		System.out.println("[2] 익명 클래스 사용");
		Addable myAdder2 = new Addable() {
			
			@Override
			public double add(double x, double y) {
				return x + y;
			}
		};
		System.out.println("result = " + myAdder2.add(1.11, 2.22));
		
		
		System.out.println("result = " + new Addable() {
			
			@Override
			public double add(double x, double y) {
				return x + y;
			}
		}.add(1.11, 2.22));
		
		
		
//-----------------------------------------------------------------------
		System.out.println();
		System.out.println("[3] 람다 표현식(lambda expression) 사용");
		Addable myAdder3 = (x, y) -> x + y;
		result = myAdder3.add(1.11, 2.22);
		System.out.println("result = " + result);
		// 람다의 의미 ; 추상메소드를 표현한 것.  추상메소드에 있는 매개변수의 개수! 타입 안중요. 
		// 매개변수  개수 적어주고, 리턴타입에 해당하는 값을 화살표 옆에 
		// 익명클래스를 더 간단하게 만드는 구문
		// 타이핑은 편한데, 가독성은 어렵다...
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class

//인터페이스 정의
interface Addable {
	public abstract double add(double x, double y);
	// 주인공은 add () 메소드! Addable 이 아녀! 
}

//인터페이스를 구현하는 클래스를 정의
class AdderImple implements Addable{
	@Override
	public double add(double x, double y) {
		return x + y;
	}
}









