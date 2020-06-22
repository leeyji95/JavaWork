package com.lec.beans;

public  abstract class Service { //추상메소드가 하나라도 있으므로 추상클래스가 된다. 
	public abstract void doAction(); // 추상메소드 
	
	// 어느 클래스에 어느 메소드가 호출되는지  
	// 테스트용 : 메소드 호출정보 출력
	public void printInfo() {
		String className = this.getClass().getSimpleName(); // 현재 수행되고 있는 클래스 이름 
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();  // 현재 수행되고 있는 메소드들을 쫘악 출력함
		String methodName = stackTrace[1].getMethodName();  // 1번째하면 -> printInfo() 를 누가 호출했는지. 호출한 녀석의 메소드 이름을 찍겠다
		System.out.println(className + " 클래스의 " + methodName + "()메소드호출");
	}
	
}
