package com.lec.java.file16dirfile;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";
	
	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		System.out.println();
		
		String path = System.getProperty("user.dir") 
				+ File.separator 
				+ TEST_DIRECTORY; // "test" 
		 System.out.println("절대경로: " + path); 
		 
		 // File 객체 생성.  --> 디스크에 물리적인 파일/ 디렉토리가 만들어진것은 아니다!!!
		 File f = new File(path);
		
		
		 // 물리적으로 만들어보자.
		// 폴더 생성: mkdir()
		// 저 파일이 일단 있는지부터 체크
		if(!f.exists()) { // 디렉토리가 존재하는지 체크
			// 디렉토리가 존재하지 않는다면 생성!
			if(f.mkdir()) {
				System.out.println("폴더 생성 성공!");
			} else {
				System.out.println("폴더 생성 실패..");  // 이건 언제? 생성하고자 하는 디렉토리 만들 권한이 없을 떄, 디스크상 오류가 생겼을떄 발생. 용량문제 등으로 폴더 생성할 수 없을 때 발생.
			}
		} else {
			System.out.println("폴더가 이미 존재합니다!");
		}
		
		
		// 파일객체가 파일을 표현할 때 이 메소드 생성
		System.out.println();
		// 파일 생성 : createNewFile()
		File f2 = new File(f, TEST_FILE);  // f: "test"라는  디렉토리 표현하는 File객체,  즉 -> "test/dummy.txt" 를 표현하는 객체  " 특정 디렉토리 밑에 있는 어떤 파일" 표현할 때 이렇게함. File(디렉토리 File, 파일명)
		System.out.println(f2.getAbsolutePath());
		
		if(!f2.exists()) { // 파일이 존재하는지부터 체크
			// 파일이 존재한지 않으면 생성
			try {
				if(f2.createNewFile()) { // Exception 발생 -> try catch 잡아주기
					System.out.println("파일 생성 성공!");
				}else {
					System.out.println("파일 생성 실패..");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// 파일이 존재한다면
			System.out.println("파일이 이미 존재합니다");
		}
		
		
		System.out.println();
		// 파일뿐만 아니라 폴더 이름도 변경할 수 있다. 
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		File f3 = new File(f, TEST_RENAME); // "test/re_dummy.txt" 를 이렇게 표현. 여기서 f 는 test 라는 폴터 표현해주고, 그 폴더 기준 밑에 TEST_RENAME 둘 거다.  
		System.out.println(f3.getAbsolutePath());
		
		if(f2.exists()) { // "test/dummy.txt" 가 존재하는지 체크
			// 변경
			
			if(f2.renameTo(f3)) { // f2 를 f3 로 바꾸겠다
				System.out.println("파일 이름 변경 성공!");
			} else {
				System.out.println("파일 이름 변경 실패.."); // re_dummy.txt 가 이미 있었으면 실패하는 경우다.
			}
			
		} else {
			System.out.println("변경할 파일이 없습니다");
		}
		
		
		
		
		System.out.println();
		// 파일 삭제: delete()
		File f4 = new File(f, TEST_RENAME); // "re_dummy.txt" 
		System.out.println(f4.getAbsolutePath());
		if(f4.exists()) {
			// '파일 존재하면 삭제
			if(f4.delete()) {
				System.out.println("파일 삭제 성공!");
			}else {
				System.out.println("파일 삭제 실패..");
			}
			
		} else {
			System.out.println("삭제할 파일이 없습니다");
		}
		
	

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class














