package com.lec.java.oop03difficluty;

public class Polymorphism03Main {

	public static void main(String[] args) {
		System.out.println("다형성의 어려움");
		
		
		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();
		
		car2.setSpeed(10);
		//car2.setOil(100);  // 컴파일 에러!!  car2 는 인스턴스 Car() 타입 
		 // 실제로는 car 인스턴스가 메모리상에 만들어졌으나. car2 는 Vehicle 타입이므로 Vehicle 상속받는 영역 밖에 볼 수 없다.
		// car2는 Vehicle 타입으로 선언되어 있으므로,
		// Vehicle이 아니 다른 클래스(심지어 자식 클래스이더라도)에 정의된
		// 메소드는 사용할 수 없다.
		// 따라서, 실제로는 Car 타입 인스턴스로 생성되긴 했지만,
		// Vehicle 타입 참조변수로는 Car 클래스에 있는 메소드를 사용할 수 없다

		((Car)car2).setOil(100);
		// car2는 Vehicle 타입으로 선언되어 있으므로,
		// Vehicle이 아니 다른 클래스(심지어 자식 클래스이더라도)에 정의된
		// 메소드는 사용할 수 없다.
		// 따라서, 실제로는 Car 타입 인스턴스로 생성되긴 했지만,
		// Vehicle 타입 참조변수로는 Car 클래스에 있는 메소드를 사용할 수 없다

		
		((Car)car1).setOil(10);   // ClassCastException  클래스 형변환에서 뻗음
		// 만들어진 영역보다 늘리려는데... 실체가 없어유.
		// 그래서 형변환하는 과정에서 Exception 발생 !!!
		// 구문, 문법적으로 오류는 없으나 발생
		
		// ClassCastException 발생:
		// 실제로 Vehicle 클래스의 인스턴스로 생성된 car1을 
		// 자식 클래스인 Car로 강제 형변환을 하게 되면 문제가 발생할 수 있다.
		// 예외는 setOil() 을 호출하는 과정이 아니라, 형변환 하는 과정에서 발생된다


		
		// 고로, 마음대로 클래스 형변환 해서는 안된다 라는 말. 
		



		
		
		
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class













































