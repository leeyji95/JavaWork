package com.lec.java.file04filterstreambufferediostream;
/*
 * 스트림 내부적으로 버퍼 사용. 
 * 기존 인풋 스트임에 장착함. 기능 추가라고 생각하면 됨. 
 */
/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림       ---> 자체적으로 버터 제공
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null; // InputStream 변수 선언
		BufferedInputStream bin = null;
		OutputStream out = null; // outputStream 변수 선언
		BufferedOutputStream bout = null;
		
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in); // 기존의 인풋 스트림에 버퍼인풋스트림 장착한 것!!
			
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out); // 기존의 아웃풋 스트림에다가 버퍼 장착!!
			
			int dataRead;  
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis(); // 현재시간 저장
			// 파일 복사  : 읽기 -> 쓰기
			while(true) {
				dataRead = bin.read(); // 버퍼드 인풋 스트림에서 읽고
				if(dataRead == -1) break; 
				
				bout.write(dataRead); // 버퍼드 아웃풋 스트림에다가 쓰면된다!  -->  내가 읽은 데이터를 담은 dataRead 를 write 로 읽겠다.
				bytesCopied++;
			}
			long endTime = System.currentTimeMillis(); // 끝나는 시간 저장
			long elapseTime = endTime - startTime;  // 경과시간 
			
			
			System.out.println("읽고 쓴 바이트 : " + bytesCopied);
			System.out.println("경과시간(ms) : " + elapseTime);
			
			
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bout != null) out.close();
				if(bin !=null) in.close();
				// bin 을 close 하면, bin 을 만든 in 도 같이 close 됨
				// bout 울 close 하면, bout 을 만든 out 도 같이 close 됨
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		// 필터 스트림 !  여전히 한 바이트씩 옮기나, 중간에 저장창고가 있다고 생각하면 됨.
		
		
	
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














