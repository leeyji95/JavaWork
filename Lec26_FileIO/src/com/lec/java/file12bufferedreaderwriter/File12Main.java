package com.lec.java.file12bufferedreaderwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {
	
	private static final String BIG_TEXT = "temp/big_eng.txt"; 
	
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		FileWriter fw = null;
		FileReader fr = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		int charRead = 0; // 읽어들인 문자
		int charsCopied = 0; // 복사한 문자 개수
		long startTime, endTime, elapsedTime;
		
		System.out.println("FileReader/Writer 만 사용");
		try {
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy1.txt");
			
			startTime = System.currentTimeMillis();
			// read() 는 한글자씩 읽어서 리턴. 더이상 읽을 것이 없으면 -1 리턴
			while( (charRead = fr.read()) != -1) {  // 이런식의 구문 많이 볼 것.   읽어들인 문자를 charRead 에 담기. 그게 -1이 아니면, 즉 다 읽어들인게 아니라면(더 읽을게 있다면)
				fw.write(charRead);
				charsCopied++;
			}
			fw.flush(); // 잊지 말고  문자 출력시 마지막에 꼭 flush() 를 하자!				
						// flush() 를 하지 않으면 정상적으로 파일 출력이 끝나지 않는다. 
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			
			System.out.println("읽고 쓴 문자수 : " + charsCopied);
			System.out.println("경과시간(ms) : " + elapsedTime);
			
		//-------------------------------------------------------------------------------------------	
			fw.close();
			fr.close();
		//-------------------------------------------------------------------------------------------	
			
			System.out.println();
			System.out.println("BufferedReader/Writer  + 버퍼사용");
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy2.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			
			// 사용자 버퍼 준비  -> 1024 개씩 문자 읽어들일 것이다.
			char[] buf = new char[1024];
			
			// 몇 글자 읽어들였는지 담는 변수
			int charsRead = 0; // 버퍼에 몊 글자 읽어들었나?
			charsCopied = 0;
			
			startTime = System.currentTimeMillis();
			
			// while 문 1번 돌 때마다 1024 개의 문자를 담을 수 있는 buf 사용!
			while((charsRead = br.read(buf)) != -1) { // charsRead = 1024(buf 길이) -> 즉 버퍼에다가 문자 1024개씩 읽어들임
				// 핵심 : BufferedReader 통해서 읽어들이고 있다는 점!
				
				// 우리가 제공한 버퍼를 사용하고 있다는 것.
				bw.write(buf, 0, charsRead); // (1024개 문자만큼 읽어들인) buf에서  인덱스 0번부터 1023번까지의 문자를  지정된 파일경로에 저장하겠다.     
				charsCopied += charsRead; // 그리고 charsCopied 는 1024 씩 증가함(while문 한 번 돌때마다 읽어들인 문자는 1024이므로!)
				
			}
			
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("읽고 쓴 문자수 : " + charsCopied);
			System.out.println("경과시간(ms) : " + elapsedTime);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		/*
		 * 문자 기반으로 일고 쓸때는 
		 * 성능위해서 버퍼드 리더 롸이터 플러스  버퍼까지 깥이 쓰고
		 * 스트림에서도 버퍼드스트림이랑 버퍼 같이
		 */
		
		
		System.out.println("\n프로그램 종료");		
		
	} // end main()
} // end class
