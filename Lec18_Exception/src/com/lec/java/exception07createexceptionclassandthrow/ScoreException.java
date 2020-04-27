package com.lec.java.exception07createexceptionclassandthrow;

// 우리가 만드는 예외 클래스
// Exception 또는 RuntimeException 클래스를 상속 받아서 만듬

// TODO : Excettion 을 상속받아 예외 클래스 정의하기
public class ScoreException extends Exception {

	// 생성자
	public ScoreException() {
		super("점수 입력 오류"); // 예외 메시지 설정 
	} 			// Exception(String message) 생성자 호출
	
	public ScoreException(String msg) {
		super(msg);
	}
	
	
	
} // end class ScoreException


//내가 만든 익셉션 클래스 만들어 주고, 
//적절한 메시지 적고
//그걸 메인에서 객체 생성해서 호출한다.
//
//그리고  트라이캐치문 이용해서 사용

