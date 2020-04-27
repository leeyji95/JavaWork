




package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는(저장하는) 통로
*/

public class File02Main {
	
	public static void main(String[] args) {
		System.out.println("File IO");

		
		InputStream in = null; // InputStream 변수 선언
		OutputStream out = null; // outputStream 변수 선언
		
		try {
			// FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");
			
			// FileOutputStream  인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.txt");
			
			
			int dataRead;  // read() 메소드가 byte 로 읽어들이고, int 로 담아서 리턴함으로.
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis(); // 현재시간 저장
			// 파일 복사  : 읽기 -> 쓰기
			while(true) {
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다  
				// [ ... ][ ... ][ ... ][ 1byte ]  // 왜 이렇게 할까? 데이터 뿐만 아니라 부가적인 정보를 담기 위해서 여유공간이 필요하기 때문에 int 로 담아 리턴한다.    만약에 더이상 읽어들일 것이 없다면? 그 정보는 어디에  담아서 전달할 것인가?  상위 비트가 -1이ㅣ면 더이상 익을 것이 없다는 정보를 준다. 바로 이러한 -1 이라는 정보를 전달해주기 위해 굳이 int 로 담아 리턴하는 
				dataRead = in.read(); // 인풋 스트림의 read() 메소드로 읽어들임.
				if(dataRead == -1) break; // 더이상 읽어들일 것이 없으면 read() 는 -1 flxjs
				
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]
				out.write(dataRead); // 아우숫 스트림의 Write() 메소드로 /   한바이트씩 담아서 int 로 내보냄... 
				bytesCopied++;
				// 위 파일이 없으면 새로 생성하고
				//        있으면 기존 파일 삭제 후 새로 생성! 
			}
			long endTime = System.currentTimeMillis(); // 끝나는 시간 저장
			long elapseTime = endTime - startTime;  // 경과시간 
			
			
			System.out.println("읽고 쓴 바이트 : " + bytesCopied);
			System.out.println("경과시간(ms) : " + elapseTime);
			
			
			
		} catch (FileNotFoundException e) { // -> 만약에  temp~ 어쩌고가 없으면 이런 익셉션이 날 것.
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제  -> out, in 모두 자원이므로 close 해주고, try~catch 잡아주기.  
			try {
				// out.close, in.close 가 만약 null 이면 NPE 나옴!! 그러므로 null 이 아니면! 을 잡아줘야 함!!!!!!!!!!!!!!!!!ㄴ
				if(out != null) out.close();
				if(in !=null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

