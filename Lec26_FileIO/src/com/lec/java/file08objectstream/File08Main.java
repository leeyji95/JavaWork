package com.lec.java.file08objectstream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* Object Filter Stream
 Program <=== ObjectInputStream <=== FileInputStream <=== File
 Program ===> ObjectOutputStream ===> FileOutputStream ===> File

java.lang.Object
 └─ java.io.OutputStream
    └─ java.io.ObjectOutputStream
 
java.lang.Object
 └─ java.io.InputStream
     └─ java.io.ObjectInputStream


 Object Stream: 객체의 입출력을 위한 스트림
 사용법은 다른 Filter Stream(Buffered I/O, Data I/O)과 비슷
 Object 스트림의 입출력 대상이 되는 클래스는 Serializable 인터페이스를 구현
 클래스의 일부 멤버 변수를 직렬화(Serialization)의 대상에서 제외시키려면,
 transient 키워드를 사용
 
 
 파일로 저장하기 위해서는 시리얼라이저블 되어 있어야 한다. ! 
*/
public class File08Main {
	
	public static final String FILEPATH  = "temp/member.dat";  // 파일 준비 (상수)

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				
				InputStream in  = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in);
						
				){
			
			Member m1 = new Member("ff", "dddd");
			Member m2 = new Member("vvvv", "dddhgkd");
			Member m3 = new Member("www", "ddwqqwdd");
			
			oout.writeObject(m1);
			oout.writeObject(m2);
			oout.writeObject(m3);
			
			// 파일에서 Object 타입으로 읽기
			Member dataRead;
			
			// 읽는 방법1 : 매번 readObject() 호출 
//			dataRead = (Member)oin.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member)oin.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member)oin.readObject();
//			dataRead.displayInfo();
			
			// 읽는 방법2 : 무한루프로 readObject() 호출...
			// EOFException 으로 잡기
			// EOF : End Of File   다 읽었다는 말
			
			while(true){
				dataRead = (Member)oin.readObject();
				dataRead.displayInfo();
			}
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) { // EOFException 이 IOException 을 상속 받음. 
			System.out.println("파일 끝까지 읽었습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		/*
		 * epdlxj ㄷ이터
		 * 데이터 저장할 때 직렬로  저장이 되어야 한다.
		 * 
		 * 몇 번부터 내보낼 것인지,
		 * 
		 * 주는쪽과 받ㄴ 쪽의 순서가 맞아야 한다.
		 * 
		 * 직렬화하는 순서를 정해서 내보낸다는 말. 
		 * String 을 byte 로 어떻게 내보낼 것인가
		 * 
		 * 네트ㅁ워크나 파일 저장할 때  객체간에 데이터 저장할때 
		 * 
		 * 시리얼 되어 있는 것끼리  저장이 되어야 한다! 
		 * little endian  big endian   이 순서가 맞아야함. 
		 * 
		 * 
		 */
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















