package com.lec.java.file06dataiostream;

import java.awt.Dimension;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream
*/

public class File06Main {

	public static void main(String[] args) {
		System.out.println("Data Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream("temp/data.bin");
				DataOutputStream dout = new DataOutputStream(out); // 기존 아웃풋 스트림에다가 DataOutputStream  장착
				
				InputStream in = new FileInputStream("temp/data.bin");
				DataInputStream din = new DataInputStream(in);
				
				){
			// 자바의 데이터를 파일에 저장할 수 있다.  
			dout.writeBoolean(true); // 1 byte
			dout.writeInt(100);  // 4 byte
			dout.writeDouble(3.14); // 8 byte
			dout.writeChar('A'); // 2byte
			
			// 작성한 걸(즉 저장한대로) 읽어들이자  -> 이때는 저장한 타입별로 변수에 담아서 출력..
			
			boolean b = din.readBoolean();
			System.out.println("bolean: " + b);
			
			int num = din.readInt();
			System.out.println("num = " + num);
			
			double num2 = din.readDouble();
			System.out.println("num2 = " + num2);
			
			char ch = din.readChar();
			System.out.println("char :  " + ch);
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















