package com.lec.java.oop01polymorphism;

public class Vehicle {
	
	// 멤버변수
	private int speed;

	// getter & setter
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	
	public void displayInfo() {
		System.out.println("----Vehicle 정보 ----");
		System.out.println("speed: " +  speed);
	}
	
	
	
	
}
