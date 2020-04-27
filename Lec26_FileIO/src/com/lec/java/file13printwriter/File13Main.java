package com.lec.java.file13printwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/* PrintWriter / 인코딩 
 * 
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.PrintWriter
 *  
 *  텍스트 파일 작성시는 PrintWriter 객체 편리
 *  	println(), print(), printf() ..
 *  텍스트 파일 읽을시는 BufferedReader 객체 편리
 *  	read(), read(버퍼), readLine()..
 *  
 *  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("파일명" 혹은 File)));
 *  PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("파일명" 혹은 File))));
 *  
 *  BufferedReader br = new BufferedReader(new FileReader("파일이름" 혹은 File));
 *  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("파일이름" 혹은 File))));
 *  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("파일이름" 혹은 File)));
 *  
 *  ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★
 * 
 *  인코딩 문제 
 *  	FIleReader, FileWriter 는 파일의 인코딩을 무조건 file.encoding 값으로 간주한다.
 * 		(ex: LINUX 는  UTF-8,  MacOS 는 한글상위의 경우 euc-kr, 윈도우즈는 Java 소스코드 인코딩 영향) 
 *  	
 *  인코딩 설정하기
 *  	InputStreamReader, OutputStreamWriter 를 사용해서 인코딩 변경을 해야 한다.
 *  
 *  	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("파일이름" 혹은 File),"인코딩"));
 *  	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("파일이름" 혹은 File), "인코딩"));
 *   
 *  인코딩 : "UTF8", "euc-kr"
 *   
*/

public class File13Main {
	
	private static final String FILE1 = "temp/PrintData.txt";
	private static final String FILE2 = "temp/PrintData_euckr.txt";
	
	public static void main(String[] args) {
		System.out.println("PrintWriter / 인코딩 ");
		
		FileWriter fw = null;
		FileReader fr = null;
		
		PrintWriter out = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
//			fw = new FileWriter(FILE1);
//			bw = new BufferedWriter(fw); // 장착!
//			out = new PrintWriter(bw);
			
				// 데이터 저장하기
				out = new PrintWriter(new BufferedWriter(new FileWriter(FILE1)));
				test_write(out);  // 파일에다가 텍스트 쓰고 저장하는 동작을 함. 
			
				
				// 데이터 읽기
				System.out.println();
				 br = new BufferedReader(new FileReader(FILE1));
				test_read(br);
				
			//---------------------------------------------------------------------
			out.close();
			br.close();
			//---------------------------------------------------------------------
			
			System.out.println("현재 OS 인코딩 " + System.getProperty("file.encoding")); // System 객체가 가지고 있음. 뭐를 OS 인코딩을?   특별히 지정하지 않는 이상 UTF-8 로 저장되었던 것. 지금까지.
			
			// euc=kr 로 인코딩 저장해보자
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE2), "euc-kr")));  // OutputStreamWriter 의 두번째 매개변수로 들어가야함
			// FILE 2를 출력용으로 열때 euc-kr 로 저장하는 printerwriter 객체가 만들어진 것. 
			test_write(out);
			System.out.println();
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE2), "euc-kr"));
			test_read(br);
			
			// 인코딩된 방법으로 데이터 저장시 저장했던 인코딩으로 읽어들어야 한다. 
			// 인코딩 항상 신경써줘야 한다. 
			
			
			
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
			try {
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
	
	
	public static void test_write(PrintWriter out) {//  프린터 라이터 객체 뽑아서  쓰고  파일로 저장한 것.    1. PrintWriter 객체 뽑아내기.  2. 객체(out)로 접근해서  파일에 작성하기. out.print() 메소드 사용.
		out.println("안녕하세요 Java 한글이 잘 보이나요?");
		out.print((2000 + 20) + " " + 3.14); 
		out.println();
		out.printf("%d-%d-%d\n", 2020, 3, 2);
		out.flush();  							// 까먹지 말자 !!
	}
	
	
	public static void test_read(BufferedReader br) {
		// 한 라인씩 읽어서 스트링 버퍼에 추가하기
		String line;
		StringBuffer sb = new StringBuffer(); // 저장공간 이라고 생각하면 편함!(StringBuffer 인스턴스를 만들었다는 건 -> 저장공간을 만들었다는 것)
		
		try {
			while((line = (br.readLine())) != null ){   // 한 라인 읽는 메소드 readLine()     line = (br.readLine())   String 개체로 리턴. 
					sb.append(line + "\n");   // 라인 단위로 읽는 방법이다 이게!!  --> 즉 내가 만들어놓은 저장공간에다가 한 라인씩 읽어들여서  계속 붙이는 동작. 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	
	
	
} // end class
