package com.lec.java.file17urlhrrpurlconnection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// 인터넷상에 있는 데이터를 읽어오는 걸 배워보자!

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1. URL : 웹 상의 주소, 
 * 	2. HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");
		
		String url = "https://www.naver.com/"; 
		
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb);
		System.out.println(sb.toString().substring(0, 200));
		
		// www~ 에서 읽어와서 StringBuffer 에 담아서 그걸 리턴해주면 됨.
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	/**
	 * 
	 * @param urlAddress : 주어진  url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML)를 StringBuffer 타입으로 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {
		
		StringBuffer sb = new StringBuffer(); // response  받는 데이터 담을 객체
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection
		
		InputStream in = null;
		InputStreamReader reader = null; // 바이트 단위로 읽어들이는 inputstream 을  문자단위로 읽어들이게끔  inputstreamreader 만든다.
		BufferedReader br = null;
		
		char[] buf = new char[512]; // 문자타입의 사용자 버퍼 준비
		
		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection  
		// HttpURLConnection 으로 인터넷과 연결시도, 웹에다가 InputStream 빨대꽂고, 거기다가 InputStreamReader 꽂고, 마지막으로 BufferedReader 객체로 읽어들일 것! 
		
		try {
			url = new URL(urlAddress); // url 객체 생성
			conn = (HttpURLConnection)url.openConnection(); // Connection 객체 생성
			
			if(conn != null) { // Connection 이 null 이 아닌 경우에만 수행되도록. 없는 url 이면 어째?   존재한다하더라도, 서버와 클라이언트의 데이터 주고받는 시간이 걸림.
				// 이 시간이 너무 오래 마냥 기다릴 수 없으므로,(프로그램 먹통되지 않도록 하기 위해서)
				conn.setConnectTimeout(2000); // 2초 이내에 '연결' 이 수립안되면 
											// java.net.SoketTimoutException 발생 하도록  핸들링
											
				
				conn.setRequestMethod("GET"); // GET 방식 request 
				// "GET", "POST" ...  request 하는 여러가지 방식이 있다.
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); 
				conn.setUseCaches(false); // request 할 때 cache 사용 안하겠다.  cache -> 서버가 기억해두고 있다는 것. 
				
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");
				
				
				// response 이후 가장 먼저 해야할 것이 -> response 에 담겨있는 코드값 확인 !!
				int responseCode = conn.getResponseCode();
				System.out.println("response code: " + responseCode);
				
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status              
				// 서버는 코드값을 담아오는데, 200 만이 정상적으로 response 가 처리.  // 404 Not Found
				// 정상적일떄만 처리하면 되기 때문에.
				if(responseCode == HttpURLConnection.HTTP_OK) {
					// B < - A  A에서 B 뽑아옴.
					in = conn.getInputStream(); // InputStream <- HttpURLConnection  
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader);  //  BufferedReader <- InputStreamReader
					
					int count = 0; // 읽은 글자 개수
					while((count = br.read(buf)) != -1) {  //버퍼에 담긴 내용을 StringBuffer 에 append!
						sb.append(buf, 0, count);  // 버퍼의 0번째 부터 읽은 곳 -1 까지  StringBuffer 에 추가   // response 받은 텍스트를 StringBuffer 에 추가 하는 동작 
					}
					
				} else {
					System.out.println("response 실패");
					return null;
				}
			}else {
				System.out.println("conn null");
				return null;
			}
			
			
			
			
			
			
		} catch (MalformedURLException e) { // 제대로 된 형식이 아닌 url 이라면  MalformedURLException
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect(); // 작업 끝나고 Connection  해제(Connection 도 자원이므로)
		}
		
		
		
		return sb;
	}

} // end class
