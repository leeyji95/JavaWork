package com.lec.java.oop01polymorphism;

public class Car extends Vehicle {
	
	private int oil;

	public int getOil() {return oil;}
	public void setOil(int oil) {this.oil = oil;}
	
	@Override
	public void displayInfo() {
		System.out.println("--- Car 정보 ---");
		System.out.println("speed: " + getSpeed());   // 그냥 speed 안되는거 알지?  private 이니까 getSpeed 로 가져온다.
		System.out.println("oil: " + oil);
	}
	

}
