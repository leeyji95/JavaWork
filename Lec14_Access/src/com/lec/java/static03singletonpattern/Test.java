package com.lec.java.static03singletonpattern;

public class Test {
	private int num;
	
	static int count = 0;
	
	// 기본 생성자
	private Test() {  // pub;lic 을 private 으로 생성자 막기.
		count++;  // 인스턴스 하나 만들때마다 copunt 값 증가시킴
		System.out.println(count + "번째  인스턴스 생성");
	}
	
	private static Test instance = null; 
	                      
	// 하나만 생성할 수 있는 ㅁ소드
	//public static 인스턴스 생성 없이 진행할 거니까 static으로
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test(); // 인스턴스 생성
		}
		return instance;
		
		
		// 1 public 울 private 으로
		// get 인스턴스 메소드 만들어서 인스턴스 한개만 만들 수 있게 해준다.
	}
	
	
	
	// getter & setter
	public int getNum() {return num;}

	public void setNum(int num) {this.num = num;}

	
}
