package com.lec.java.file09objectwithcollection;

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

import com.lec.java.file08objectstream.Member;

// Object Filter Stream + Collection

// Program <=== ObjectInputStream <=== FileInputStream <=== File
// Program ===> ObjectOutputStream ===> FileOutputStream ===> File

// ArrayList<> 와 같은 Collection 에서,
// 모든 데이터들이 Serializable 되어 있으면 ObjectInputStream / ObjectOutputStream 으로
// read/write 가능.

public class File09Main {
	
	public static final String FILEPATH  = "temp/member2.dat"; 

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");
		
		
		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				
				InputStream in  = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in);
						
				){
			
			ArrayList<Member> list = new ArrayList<Member>(); // 어레이리스트에 멤버 타입 담기
			
			Member m1 = new Member("ff", "dddd");
			Member m2 = new Member("vvvv", "dddhgkd");
			Member m3 = new Member("www", "ddwqqwdd");
			
			list.add(m1);
			list.add(m2);
			list.add(m3);
			// 3 개의 멤버 객체가 list 에 저장
			
			// 리스트에 한번에 저장
			oout.writeObject(list); // List 를 한번에 저장!
			
			// 저장한 걸 다시 읽어오기
			
			list = null; // 메모리 날리기( 제대로 읽어오기 위해)
			
			list = (ArrayList<Member>)oin.readObject();
//			System.out.println(list); // 파일에서 읽어들인 것이 찍힐 것 
			for(Member m : list) {
				m.displayInfo();
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
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class File08Main
















