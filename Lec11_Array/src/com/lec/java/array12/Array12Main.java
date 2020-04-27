package com.lec.java.array12;
/*
 프로그램 실행할 때 명령 실행 인자를 받아옴.
자바에서는 String[] args 로 받아온다. 
 */
/* main() 의 매개변수 String[] args
 */
public class Array12Main {

	// 윈도우 환경에서 path 설정이 되어 있으면 커맨드 창 에서 
	// bin>java com.lec.java.array12.Array12Main ~~ ~~  
	// 이클립스 환경에선 Run-Run configuration 에서 [Argument] 를 설정해주면 된다.
	
	public static void main(String[] args) {
		System.out.println("main 메소드 매개변수: String[] args");
		
		System.out.println("args.length = " + args.length);
		
		for(String arg: args) {
			System.out.println("--> " + arg); // 옵션들 중 하나라도 있으면 출력될 것. 
		}
		  
		// command 창 띄우기 
		
		/*
자동 명령 인자 입력
명령인자 arg String[] 로 들어온다.
Run -> Arguments -> program arguments에서 인자 입력 -> apply  -> close
		 */
		
		
		
	} // end main

} // end class Array12Main








