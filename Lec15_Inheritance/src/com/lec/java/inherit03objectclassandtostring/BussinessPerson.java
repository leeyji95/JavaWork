package com.lec.java.inherit03objectclassandtostring;

public class BussinessPerson extends Person { // 하나의 부모로부터만 상속 핟는다. (다중상속 허용되지 않눈다,0
	String company;
	
	public void showInfo() {
		whoAmI();
		System.out.println("회사는 " + company + " 압나더,");
	}
}
