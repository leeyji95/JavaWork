package com.lec.java.file05bufferedstreamandbuffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 버퍼드 스트림이랑 사용자가 제공한 버퍼 둘 다 쓰면 시간이 얼마나 빨라지는가 

/* Buffered Stream + Buffer 예제
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
*/

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");
		
		// TODO:
		// file03 패키지 참조
		// try with resource 구문으로 작성
		// in.read(buff) --> bin.read(buff);
		// out.write( , , ) --> bout.write( , , ); 사용
		// finally 필요 없슴
		
		
		try(   
				InputStream in = new FileInputStream("temp/big_text.txt");
				BufferedInputStream bin = new BufferedInputStream(in); // 장착
				
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				BufferedOutputStream bout = new BufferedOutputStream(out); // 장착
				
				
				){
			
			byte[] buff = new byte[1024]; // 버퍼 준비   최대 1024 바이트 씩 읽어들이고, 씀
			int lengthRead = 0; //버퍼에 읽어들인 바이트 수
			int bytesCopied = 0; // 
			
			long startTime = System.currentTimeMillis();
			//파일복사
			while(true) {
				lengthRead = bin.read(buff); 
				if(lengthRead == -1 ) break; 
				
				bout.write(buff, 0, lengthRead);   
				bytesCopied += lengthRead; // 직전에 읽어들인 데이터만큼 write  
				
			}
		
			long endTime = System.currentTimeMillis();
			long elapseTime = endTime - startTime;
			
			System.out.println("전체 복사한 바이트 : " + bytesCopied);
			System.out.println("경과시간(ms) : " + elapseTime);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // finally 사용해서 close() 안 해줘도 됨!
		
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class File05Main
















