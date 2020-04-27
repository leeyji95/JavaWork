package com.lec.java.file03trywithcatchbuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 java.io.InputStream
  |__ java.io.FileInputStream
 java.io.OutputStream
  |__ java.io.FileOutputStream
*/

public class File03Main {

	public static void main(String[] args) {
		System.out.println("File IO 2");
		
		// Java 7부터 도입된 try-with-resource
		// try (리소스 생성) { ... }
		// catch (exception ) { ... }
		// 리소스를 close하는 코드가 없어도 자동으로 close가 실행
		//
		// java.lang.AutoCloseable 나 
		//  └─ java.io.Closeable 을 상속받은 어떠한 객체라도 
		//  try(리소스 생성) 안에 '선언' 되어 있으면
		//  try~catch 가 끝나기 전에 close() 됨.
		
		// InputStream, OutputStream 둘다 Closeable 을 상속(implements) 한다
		
	
		try(    // try 괄호안에 나중에 클로즈 해줘야할 객체를 안에다가 넣음
				InputStream in = new FileInputStream("temp/big_text.txt");
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				){
			
			byte[] buff = new byte[1024]; // 버퍼 준비   최대 1024 바이트 씩 읽어들이고, 씀
			int lengthRead = 0; //버퍼에 읽어들인 바이트 수
			int bytesCopied = 0; // 
			
			long startTime = System.currentTimeMillis();
			//파일복사
			while(true) {
				// 데이터 읽기
				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 리턴,  읽어들인게 없으면 -1 리턴.  // 아까는 1 바이트씩 리턴 햿음. 차이점 알기
				lengthRead = in.read(buff); // 차이점 : buff 를 매개변수로 넣음!  -> 얘는  읽어들인 바이트 수를 리턴.  // lenghRead 에 담기. 한번에 최대 1024 까지 읽어들일 수 있다는 말
				if(lengthRead == -1 ) break; // 더이상 읽어들일 것이 없으면 종료
				
				// read(buf) : actually(실제로) 읽어들인 바이트의 수를 리턴 -> 그리고 그 수를 배열에 저장.
				
				// 읽어들인 데이터는 버퍼에 담겨 있고,! 
				// 이걸 화면에 써보겠다. -> write() 메소드 이용!
				// 데이터 쓰기!
				out.write(buff, 0, lengthRead);  // 항상 버퍼가 1024 바이트로 꽉꽉 차있다는 보장은 없음.// 0 번째 데이터부터 lengthRead 직전 만큼 읽어들인데이터 만큼 write 하겠다. 
				bytesCopied += lengthRead; // 몊 바이트 읽었는지 
				
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

} // end class
















