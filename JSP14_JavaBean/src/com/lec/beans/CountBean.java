package com.lec.beans;

public class CountBean {
	private int cntNumber;
	
	public CountBean() {
		System.out.println("CountBean 생성!!");
		
	}
	
	public void setCount(int  n) {
		cntNumber += n; // 기존의 값에 더해진다!!
	}
	

	public int getCount() {
		return cntNumber;
	}
	
	// getter setter  를 멤버변수와 다르게 설정했다.
	// jsp 에서는 어떤 걸로 불러야 할까? 
	// setCount(0  getCount() 로 불러야 한다.
	// 게터세터가 별거아닌것 같아도 참 대단한 기술
	
	
} // end class
