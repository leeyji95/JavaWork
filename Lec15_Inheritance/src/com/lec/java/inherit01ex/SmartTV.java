package com.lec.java.inherit01ex;

public class SmartTV {

	// 멤버변수
	boolean isPowerOn;
	int channel;
	int volume;
	String ip;  // SmartTV 에서 새로이 추가된 필드 
	
	//메소드
	public void displayInfo() {
		System.out.println("---- TV 현재상태 ----");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel	);
		System.out.println("볼륨: " + volume);
		System.out.println("ip주소: " + ip);  // SmartTV 에서 추가된 코드 
	}
	
	// 기존 코드의 재활용. 신규코드의 생산성을 높이고자. 그 생산성이 바로 상속. 
	// 추가, 변경되는 것만 손을 보도록
	
	
	
}
