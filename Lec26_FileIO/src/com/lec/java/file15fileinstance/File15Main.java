package com.lec.java.file15fileinstance;

import java.io.File;  // 주로 디렉토리 관련 작업.  대문자 F 로 시작하는 File 객체에 대해서 배울 것. 

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 폴더: " + curWorkingDir);
		
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir);  // 현재 작업 디렉토리 객체   디렉토리 : 파일들을 담는 공간, 디렉토리와 파일 구분 
		// 이 파일객체가 파일을 나타내는지, 디렉토리 나타내는지  항상 예의 주시ㅣ 해야함.     
		// 지금 이거는 디렉토리를 표현하는 파일객체다!!    이름이 파일이어가주구 디렉토리객체를 만든건지, 파일을 나타내는 객체를 만든건지 항상 헷갈린다.
		File [] list = curDir.listFiles(); // listFiles() :  디렉토리 안에 있는 '파일' 과 '디렉토리' 를 File 배열로 리턴!
		
		// <정리> : 파일 인스턴스인 curDir 는 파일을 나타낼수도, 디렉토리를 나타낼 수도 있다. 지금 여기서 curDir 는 뭐다? 디렉토리를 나타내는 객체이다!
		// listFiles() 는 디렉토리 안에 있는 파일 또는 디렉토리를 File 배열형 타입으로 리턴한다.
		// 그러므로 File[] 변수 list 에 담자! 
		System.out.println(list.length); // '파일' 과 '디렉토리' 의 개수 
		
//		for (int i = 0; i < list.length; i++) {
//			System.out.println(list[i].getName());
//		}
		/*	.classpath
			.dbeaver
			.project
			.settings
			bin
			src
			temp */
		// 파일 이름만 뽑아낸거고, 뭐가 파일인지, 디렉토리인지 구분되어 있지 않다.
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				System.out.print("DIR\t");
			}else {
				System.out.print("FILE\t");
			}
			System.out.print(list[i].getName() + "\t");
			System.out.println(list[i].length()); // length() '파일' 의 크기(byte)
												// '디렉토리' 인 경우는 의미 없다  
		}
		
		// 파일 객체 만들고, 인스턴스의 listFile() 메소드로 이 안에 있는 파일과 디렉토리들을 배열에 담음. 
		// 배열로부터 디렉토리인지 파일인지 
	
		System.out.println("\n");
		// 디렉토리의 내용 출력, enhanced for 문 이용
//		File tempDir = new File("temp");  // 상대경로 이용한 File 객체 생성 // 현재 curDir 디렉토리 밑에 temp 디렉토리 있음.  // 현재 작업중인 경로 밑에 있는 "temp" 이런 디렉토리나 파일을 찾겠다. 의미. --> 이런걸 '상대경로'라고 함. (현재 경로를 기준으로 그 밑에 있는 temp 를 찾겠다
		
//		 '절대경로(absolute path)' 를 이용한 File 객체 생성
		String tempDirPath = System.getProperty("user.dir") 
				+ File.separator  // 윈도우(\), LIONUX, Mac(/)
				+ "temp"; 
		System.out.println("절대경로: " + tempDirPath);
		
		File tempDir = new File(tempDirPath); // '절대경로' 를 이용한 File 객체 생성
		
		
		
		File [] list2 = tempDir.listFiles();
		for (int i = 0; i < list2.length; i++) {
			if(list2[i].isDirectory()) {
				System.out.print("DIR\t");
			}else {
				System.out.print("FILE\t");
			}
			System.out.print(list2[i].getName() + "\t\t");
			System.out.println(list2[i].length());
		}

		
		
		System.out.println();
		// 파일 하나에 대한 정보
//		String path = "dummy.txt";
		File f = new File("dummy.txt"); // 파일 객체 생성. 상대경로를 이용한 새로운 File 객체 생성!
								// ★ File 객체를 생성(new) 했다고 해서 
								// 물리적인 파일/디렉토리가 만들어지는게 아니다!!!!!!(단지 자바의 인스턴스가 만들어진 것)
		System.out.println("파일이름 : " + f.getName()); // dummy.txt 출력 -> 정확히 상대경로가 뽑히는 것
		System.out.println("절대경로 : " + f.getAbsolutePath()); // 절대경로명 -> 문자열로 뽑은 것!
		
		// 이렇게 뽑아낸 걸,  진짜 존재하는지 아닌지 알아보기 위해 다음과 같은 코드 사용
		System.out.println("있냐?  : " + f.exists()); // boolean 타입 => false
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File11Main

















