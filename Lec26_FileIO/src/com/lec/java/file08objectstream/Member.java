package com.lec.java.file08objectstream;

import java.io.Serializable;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564811082080172359L; // 노란줄 커서 => generated wserialb~ version id
	private String id;
	private String pw;
	transient private int num;    // 굳이 저장할 필요가 없는 변수는 ->  trasient 키워드 사용 -> 시리얼 되지 않음. 
	transient private boolean isExist;
	
	// transient로 선언된 변수는 serialization(직렬화) 대상에서 제외됨.
	// (파일에 write되지 않는다)
	// de-serializtion(역직렬화, 파일에서 읽기)를 할 때는 
	// 해당 타입의 기본값(0, false, null)으로 초기화됨 ->  처음 읽어들이는 값은 초기화된 값으로저장 됨.  
	
	public Member() {}
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.num = 123;
		this.isExist = true;
	}
	
	public void displayInfo() {
		System.out.println("--- 회원 정보 ---");
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		System.out.println("번호: " + num);
		System.out.println("Exist? " + isExist);
	}
	
} // end class Member 






