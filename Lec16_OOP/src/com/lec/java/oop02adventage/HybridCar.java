package com.lec.java.oop02adventage;

public class HybridCar extends Car{
	
	private int electircity;

	public int getElectircity() {return electircity;}
	public void setElectircity(int electircity) {this.electircity = electircity;}
		
	@Override
	public void displayInfo() {
		System.out.println("--- HybridCar 정보 ---");
		System.out.println("speed: " + getSpeed());
		System.out.println("oil: "  + getOil() );
		System.out.println("electricity: " + electircity );
	}
	
	

}
