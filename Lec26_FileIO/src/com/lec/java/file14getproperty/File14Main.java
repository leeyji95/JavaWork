package com.lec.java.file14getproperty;

import java.nio.charset.Charset;

public class File14Main {

	public static void main(String[] args) {
		System.out.println("시스템 정보 확인");
		
		System.out.println();
		System.out.println(System.getProperty("os.name")); // 현재 운영체제 출력
		
		System.out.println(System.getProperty("os.arch")); // 64비트 라는 말
		System.out.println(System.getProperty("os.version")); 
		
		System.out.println();
		System.out.println(System.getProperty("java.home")); // JRE 경로 : Java Runtime Environment <-- JVM    C:\Program Files\Java\jdk1.8.0_241\jre 경로나옴. 
		System.out.println(System.getProperty("java.version")); // 버전이 8, 241번째 업데이트하고 있따.
		
		
		System.out.println();
		// current working directory
		System.out.println(System.getProperty("user.dir"));  // 현재 이 프로그램이 돌아가고 있는 작업 경로 // D:\JavaApp1\Dropbox\Java23\JavaWork\Lec26_FileIO
		
		// user home directory("내 문서"가 있는 폴더)
		System.out.println(System.getProperty("user.home")); // 현재 내 계정, 내 문서가 있는 경로
		
		System.out.println();
		System.out.println(System.getProperty("file.separator"));  // 디렉토리마다 파일구분하는  seperator 문자 다 다름. 윈도우는 역슬래시 


		
		// OS 기본 인코딩 값! 
		System.out.println("Default Charset = "  + Charset.defaultCharset()); // Default Charset = UTF-8  
		System.out.println("file.encoding = " + System.getProperty("file.encoding")); // file.encoding = UTF-8   ---> File13 패키지에서 한번 나왔음

		System.out.println("\n프로그램 종료");
//		
	} // end main()

} // end class














