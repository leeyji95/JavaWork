package com.lec.java.urlgetpath;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlMain {

	public static void main(String[] args) {
		
		/* URL (Uniform Resource Locator) 객체
		 *  java.net.URL 객체를 통해  인터넷 관련 리소스 접근.
		 *  
		 *  URL 객체의 메소드를 통해  URL을 분해해볼수 있다. 
		 *  
		 *  가령 : https://aaa.bbb.com:88/abc/def/zzz.ddd?name=uu&age=12 의 경우
		 * 	getProtocol(): https
		 *	getHost(): aaa.bbb.com
		 *	getPath(): /abc/def/zzz.ddd
		 *	getPort(): 88
		 *	getFile(): /abc/def/zzz.ddd?name=uu&age=12
		 *	getQuery(): name=uu&age=12
		 *
		 *  단, 파일 이름의 경우 따로 추출해야 하는 번거로움 있다.
		 *  
		 *  URI (Uniform Resource Identifier) 는 URL 의 상위 개념
		 */
		
		
		System.out.println("URL 객체");

		String[] urls = new String[] { 
				"https://aaa.bbb.com:88/abc/def/zzz.ddd?name=uu&age=12",
				"http://www.example.com/some/path/to/a/file.xml?foo=bar#test",
				"hhh://asdf",
				"ftp://asdf",
				"http://",
				"aaa.bb.com"
		};
		
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]);
			URL url = null;
			
			try {
				url = new URL(urls[i]);
			} catch (MalformedURLException e) {
				System.out.println("\t 잘못된 url 입니다 " + e.getMessage());
				continue;
			}
			
			System.out.println("\tgetProtocol(): " + url.getProtocol());
			System.out.println("\tgetHost(): " + url.getHost());
			System.out.println("\tgetPath(): " + url.getPath()); // 찍어내려면? -> 찢어내서 문자열 조합해야함.
			System.out.println("\tgetPort(): " + url.getPort());
			System.out.println("\tgetFile(): " + url.getFile());
			System.out.println("\tgetQuery(): " + url.getQuery());	

			
			// 파일명, 확장자
			// 마지막 쩜의 우측이 확장자임. aaa.bbb.txt -> txt 가 확장자
			if(url.getPath().length() > 0) {
				String filename = url.getPath().substring(url.getPath().lastIndexOf('/') + 1); // 마지막으로 발견한 슬래시의 인덱스 번호(8) +1 (<-9)이므로 우측을 가리킴. substring(9) 하면 인덱스번호 9번부터 끝까지 출력하라.
//				System.out.println(url.getPath().lastIndexOf('/')); // int 값 8 출력. (lastIndexOf() 설명참조)
				String fileBaseName = filename.substring(0, filename.lastIndexOf('.')); // 파일 명에서 쩜의 왼쪽부분이 파일베이스네임
				String fileExt = filename.substring(filename.lastIndexOf('.') + 1); // 파일 명에서 쩜의 오른쪽부분이 파일확장자명 
				
				System.out.println("\t파일명: " + filename);
				System.out.println("\t파일base명: " + fileBaseName);
				System.out.println("\t파일확장자: " + fileExt);
			}
			
/*
 * url.getPath().lastIndexOf('/')  이거자체가 '8' 출력됨.


public int lastIndexOf(int ch) {
     return lastIndexOf(ch, value.length - 1);
    }

 @return  the index of the last occurrence of the character in the
 *          character sequence represented by this object

==> 마지막 그 ch 문자의 인덱스번호를 리턴함. (return type int)

 */
		

		} // end for
		
	}

}
