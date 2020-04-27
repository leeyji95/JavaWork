package com.lec.java.file11filereaderwriter;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/*
문자(character) 단위 입출력 스트림 클래스
 java.io.Reader: 프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
  └─ java.io.InputStreamReader
      └─ java.io.FileReader

 java.io.Writer: 프로그램이 '문자 단위' 데이터를 쓰는(write) 통로
  └─ java.io.OutputStreamWriter
      └─ java.io.FileWriter

 FileReader / FileWriter 객체는 '텍스트파일, 즉 문자 단위' 데이터를 읽고/쓰기 할때
 사용하는 기반 스트립 입니다.   따라서 텍스트가 아닌 오디오, 비디오, 등의 파일을 다룰수 없습니다.
 주로 String 이나 char [] 내용을 입/출력 할때 사용합니다.

 텍스트 파일 (Text File) 이란
   사람이 읽을수 있는 글자들이 저장된 파일
   암호화 되지 않은 평범한 텍스트

 이진파일 (Binary File) 이란
   사람이 직접 읽을수는 없슴.

   ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★  // 출력시****
*/

// 리더랑 라잇 => 문자단위로 읽어들임!!
public class File11Main {
	
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		String src = "temp/FileData.txt";
		String dst = src;
		
		try(
				FileWriter fw = new FileWriter(dst);
				FileReader fr = new FileReader(src);  // 텍스트를 리더객체로 저장
			   ){
//			String str = "안녕하세요"; //  한글 5글자
			char[] charArr = {'J', 'A', 'B', 'a'}; // 영문 4글자
			
			fw.write("안녕하세요"); // 저장은 시스템 인코딩 상테에 따라 저장됨.
			fw.write(charArr); // UTF-8 인코딩의 경우, 한글은 한글자당 3byte, 영문은 1byte 로 저장됨.
			fw.flush();// wirite() 호출 후에는 flush() 하여 출력 버퍼의 데이터가 완전히 출력되도록 한다.
			
//-------------------------- 여기까지 데이터 저장 ----------------------------------------------
			
			// 읽을 때에는 char 버퍼로 읽어 들인다.
			// 읽기
			char[] buff = new char [100]; // 
			int charsRead = 0; // 읽어들인 문자의 개수
			charsRead = fr.read(buff); // 읽어들인 문자 개수  리턴(100개 데이터 담을 수 있는 buf 에 실제 9개의 글자만 읽어들이고, 나머지 91 개 공간은 빈공간으로 냅둠. 
			for(int i = 0; i < charsRead; i++) { // 배열 길이만큼 for 문 돌려서  버퍼에 저장된  문자들을 출력함.
				System.out.println(i + " : " + buff[i]);
			}
			System.out.println();
			System.out.println("읽은 문자개수: " + charsRead); // 왜 9가 나올까? 
			
			
			
			/*
			 * 여기서 fr.read(buff) 는 저장한 파일에서 한글자씩 읽어서 버퍼에 저장.  
			 * --> 여기서 Reader 객체의 read() 메소드는 내부적으로 for문이 돌아가는 건가요? 
			 * 
			 * read(buf, 0, buf.length) 의 의미 : buf 의 인덱스 0번부터  length -1까지 읽어들임. 결국 버퍼 길이 값을 리턴하는 거 아녀? 
			 * 
			 *  
			 *  원래 질문하려고 했던 것
				read(buf, 0, charsRead)
				-> char []형  버퍼에 있는 문자 한글자씩 charsRead 직전까지 읽겠다는 말.
				내부적으로 for문이 돌아가는 것인가? 
				
				내부적으로 for문이 돌아가는 것이 아니고,
				while 문 한 번 돌 때  100 개의 데이터를 담을 공간이 생기고(배열생성) 
				그 공간에 한글자씩 읽어서 buf[0] 안, buf[1] 녕, buf[2] 하 ... 이런식으로 담음
				근데 여기서 몰랐던 부분은 
				... buf[99] 까지 만들어진다는 것.
				그러니까  읽어들인 문자는 안~ a 까지 총 9 글자 읽어들이고, 나머지 공간은 빈문자(공백)로 남겨둠.
				
				결과적으로 읽어들인 문자 수만 계산되서 리턴함. (노트와 디버깅 참조)
				
				
    		  
			 */
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class
