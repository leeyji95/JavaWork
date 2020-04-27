package com.lec.java.thread02;

/* Runnable 인터페이스로 쓰레드 구현
 자바는 다중 상속을 지원하지 않음
 -> 다른 클래스를 상속받고 있는 경우에는, 
 Thread 클래스를 상속받을 수 없는 문제가 발생
 -> 인터페이스를 구현해서 쓰레드를 생성할 수 있는 방법을 제공

 쓰레드 사용 방법 2:
 1. Runnable 인터페이스를 구현하는 클래스를 정의
 2. 정의한 클래스에서 run() 메소드를 override
 3. Runnable을 구현하는 클래스의 인스턴스를 생성
 4. 만들어진 인스턴스를 Thread 생성자의 매개변수로 주면서, Thread 인스스를 생성
 5. 생턴성된 Thread 인스턴스의 start() 메소드를 호출
*/

public class Thread02Mainannomyclassmethodwiththread {

	public static void main(String[] args) {
		System.out.println("쓰레드 생성 2");
		
		// 3. Runnable을 구현하는 클래스의 인스턴스를 생성
		Runnable runnable1 = new MyRunnable("안녕, 자바 프레임웍");
		Runnable runnable2 = new MyRunnable("Hello, HTML!");
		Runnable runnable3 = new MyRunnable("멀티쓰레드");
		

		// 4. Runnable을 이용해서 Thread 인스턴스를 생성
		//runnable1.start()  이런거 없어유!
		Thread th1 = new Thread(runnable1);  // 반드시 Thread 인스턴스 만들고!
		// 별도의 쓰레드가 아직 끝나지 않았으면 프로그램 끝난 것이 아님  
		// 메인에서 뽑아낸 모든 작업들이 끝나야 메인이 종료되는 것임
		
		Thread th2 = new Thread(runnable2);
		
		
		
		// 5. Thread 인스턴스의 start() 메소드를 호출
		th1.start();   // 그러고 나서 start() 한다!!!
		th2.start();
		
		new Thread(runnable3).start(); 
		new Thread(new MyRunnable("Java Thread")).start();  // 한 번에 !
		
		
		
		// 순차적으로 쓰레드 진행되지만, 어떤 쓰레드가 먼저 끝났는지는 알 수 없다. 
		
		
		// Anonymous class 로 생성
		//System.out.println();
		//System.out.println("Anonymous class 으로 Runnable 구현");
		new Thread(new Runnable() {
			
			int count = 0;
			String msg = "풀스택과정";
			
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + " " +  count + " : " + msg);
					count++;
				}
				
			}
		}).start();
		
		
		
		
		
		
		// Runnable 인터페이스는 run() 가상메소드 하나만 가지고 있는 인터페이스 이기 때문에
		// Lambda-expression 으로도  구현 가능.                 // 람다는 추상메소드 한개만 가지고 있어야 하!
		//System.out.println();
		//System.out.println("Lambda-expression 으로 Runnable 구현");
		new Thread(() -> {
			// 수행코드
			for(int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " +  i + " : " + "쉬는시간이다!");
			}
		}).start();
		
		
		

		System.out.println("-- main() 종료  -- ");
	} // end main()

} // end class


// 1. Runnable 인터페이스를 구현하는 클래스를 정의
class MyRunnable implements Runnable{ // implements Runnable
	
	private String msg;
	private int count;
	
	public MyRunnable() {}
	
	public MyRunnable(String msg) {
		this.msg = msg;
		count = 0;
	}


	// 2. 정의한 클래스에서 run() 메소드를 override - 쓰레드 할 일
	@Override
	public void run() { // 이 메소드가 별도의 작업 쓰레드에서 돌아갈 수행코드임!!!!
		for(int i = 0; i < 100; i ++) {
			//Thread.currentThread()  얘를 써야해. 현재 이 코드를 실행중인 Thread 객체를 리턴함!    언제어디서든 현재 내가 실행중인 쓰레드 이름이 뽑힘!   Thread.currentThread()   이거 자체가Thread  이므로 이거로 . getName() 접근해서 이름 뽑아내기.
			System.out.println(Thread.currentThread().getName()+ " " + count + " : " + msg); // getName() 는 에러! 왜? 얘는 Thread 상속받은애야! 지금은 얘 상속받는 게 아녀!  그럼? Thread.currentThread()  얘를 써야해. 현재 이 코드를 실행중인 Thread 개체를 리턴함!
			count++;
		}
		
	}
	
} // end class MyRunnable





















