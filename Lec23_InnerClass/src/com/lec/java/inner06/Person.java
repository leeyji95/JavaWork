package com.lec.java.inner06;

public class Person {
	// Person 외부 클래스의 멤버 변수
	private String name;
	
	// Person 외부 클래스의 생성자
	public Person(String name) {
		this.name = name;
	}
/*	
	public void createInstance(int age) {
		
		// Local inner class
		class PersonAge{
			public void readInfo() {
				System.out.println("이름 " + name);
				System.out.println("나이 " + age);
			}
		}// end PersonAge()
		
		PersonAge p = new PersonAge();
//		p.readInfo();  이걸  return 한 쪽에서 호출하고 싶다면
		return p;  // 그래서 return p; person ㅏ타입으로 리턴 하려는데 에러.   이미 수행하였으므로, 수명을 다함.  사라진 클래스 타입임.  -> 없는 데 어떻게 리턴하?
		
		
	} // end createInstance()
	
*/	
	/*
	 지역 클래스는 메소드 실행이 끝나게 되면 정의 자체가 사라지게 되는 클래스임.
	 메소드 내부에 정의된 지역 클래스 타입을 리턴하는 메소드는 만들 수 없다.
	 경우에 따라서는, 지역 클래스에 정의된 메소드를
	 외부에서 직접 사용하고자 하는 경우가 발생할 수도 있습니다.
	 그걸 가능하게 하는 방법이 
	
	 인터페이스(interface) + 다형성(polymorphism):    로 해결
	 
	 1. 외부에서 사용하고 싶은 메소드를 선언한 인터페이스를 작성
	 2. 메소드의 리턴타입은 정의한 인터페이스 타입으로 정의
	 3. 로컬 클래스는 인터페이스를 구현(implements)하도록 정의
	 4. 로컬 클래스의 인스턴스를 생성하고 리턴해줌
	*/
	
	//2. 저 Readable 을 리턴하는 메소드를 만듦.
	public Readable createInstance(int age) {
		
		// 3. Local 이너클래스 정의
		class PersonAge implements Readable{
			@Override
			public void readInfo() {// 추상메소드가 있는 인터페이스 상속받기 (구현)
				System.out.println("이름 " + name);
				System.out.println("나이 " + age);
			}  
		} // end personAge
		// 4.
		Readable person = new PersonAge();
		return person;
 		
	} // end createInstance()3
	
	// 이렇게 하면 메인에서 실행될 수 있다. 
	
	// personAge ... new 만 하기 위해 만들어진 것. 
	// 어떤 특정한 기능을 하는 메소드가 필요한데,  반드시 어떤 클래스에 담아서 정의 해줘야해.
	// 그래서 이름이 없는 클래스 -> 익명클래스를 만든다. 

	

	
	
} // end class Person


// 1.    Readable 이라는 인터페이스 만들기
interface Readable{
	public abstract void readInfo();
}







