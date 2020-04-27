package com.lec.java.inherit02ex;

// BasicTV
// 	ㄴ SmartTV
public class SmartTV extends BasicTV{
	String ip;
	
	public void dispalyInfo() {
		super.displayInfo();
		System.out.println("IP 주소: " +  ip);
	}
}
