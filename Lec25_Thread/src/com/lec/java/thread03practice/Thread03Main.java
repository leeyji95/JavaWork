package com.lec.java.thread03practice;

/* 쓰레드와 익명클래스
 */
public class Thread03Main {

	public static void main(String[] args) {
		System.out.println("쓰레드와 익명 클래스");
		
		// 이미 정의된 MyRunnable 클래스의 인스턴스 사용
		new Thread(new MyRunnable()).start();
		
		// 익명 클래스를 사용해서 Runnable 인스턴스를 생성
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("3 X " + i + " = " + (3 * i));
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		// 특히 안드로이드에서 많이 볼 구문
		
		
		for(int i  = 0 ; i < 10; i++) {
			System.out.println("4 X " + i + " = " + (4 * i));
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Thread03Main


class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("2 x " + i + " = " +  (2 * i));
			
			// 한 줄 출력할 때마다 딜레이되도록
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
			
	}
	
} // end class MyRunnable

























