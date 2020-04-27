package com.lec.java.exception08practicecreateexceptionclass;

// TODO : Exception 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception {
	
	// 생성자
	public AgeInputException() {
		super("나이입력오류~");
	}
	
	public AgeInputException(String msg) {
		super(msg);
	}
	
	
} // end class AgeInputException
