package com.lec.java.class03gettersetter;

public class Number {
	
	// 멤버변수
	private int num;
	private char ch;
	
	// 생성자
	// 디폴트 생성자
	public Number() {}  // 아무것도 안하는 디폴트 생성자
	
	// 매개변수 있는 생성자
	public Number(int num, char ch) {
		this.num = num;     // this : 자기 자신(인스턴스)을 가리킴.    이름이 똑같은 경우 this. 라는 키워드 사용!
		this.ch = ch;
	}  
	
	
	
	
	// 매소두   --> 게터 세터 왜 써?      메인에서 private 변수 쓰고 싶어서.
	// getter: 멤버 변수의 값을 리턴해 주는 메소드
	// setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드
	
	// 일반적인 작명 관례
	// get변수이름()
	// set변수이름()
	// Camel notation 적용
	
	public int getNum() {  // 자기 자신 값 리턴
		return this.num; 
	}
	public void setNum(int num) {  // private 멤버 변수 수정하고 싶을 떄.
		if(num >= 0)
		this.num = num; 
	}
	// 그럼 이렇게 쓸거면 굳이.. 왜 private 만들었을까?
	// 접근할 수 있는 수단을 제공해주었기 때문에 통제할 수 있다.
	// 예를 들어, setnum 에다가 num 이 0 보다 크거나 같을때 ,   --> setnum에서 멤버변수의  조건 걸 수 있음. 
	// 어떤 유효한 값에서만 변경 가능.
	// 데이터 보호 가능.    멤버변수 값의 통제 가능!!
	
	// ch 에 대한 getter, setter 작성
	public int getCh() {
		return this.ch = ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	
	

} //  end class






