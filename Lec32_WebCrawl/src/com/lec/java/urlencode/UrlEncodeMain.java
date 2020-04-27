package com.lec.java.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.activation.URLDataSource;

/*  URLEncoder(코드화 한다), URLDecoder(코드된 걸 원래 사람이 읽을 수 있는 문자열로 바꿈)
 * 
 * URL 은  한글, 특수기호, 공백등의 문자를 담을수 없다.
 * 따라서 위와 같은 문자를 URL에 담으려면 URL 인코딩 을 하여야 한다.
 *  
 * O : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC
 * X : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=파이썬
 * 
 * 인코딩-디코딩 온라인 테스트 사이트
 * 	http://coderstoolbox.net/string/#!encoding=xml&action=encode&charset=us_ascii
 * 
 */


public class UrlEncodeMain {

	public static void main(String[] args) {
		
		
		System.out.println("URLEncoder, URLDecoder");

		String str = "해리포터너무좋아";
		
		// 한글관련 자주 사용되는 인코딩
		String charset[] = { // 딱 두가지 보면 된다. euc-kr, UTF-8! 
			"euc-kr", "ksc5601", "cp949", "ms949", // 한글 표현 -> 2byte
			"iso-8859-1", "8859_1", "ascii",   // 한글 불가     1바이트는 총 256(2의 8슬)개까지 최대  표현. 근데 한글은 절대 256개로 표현 불가.
			"UTF-8",   // 한글표현 -> 3byte
		};
		
		for (int i = 0; i < charset.length; i++) {
			
			try {
				// 문자열을 -> URL 인코딩 해보겠습니당
			System.out.printf("%11s → %s\n", charset[i], 
					URLEncoder.encode(str, charset[i])); // 두번째 매개변수에 -> 인코딩할 방법  (나중에 한글을 인코딩 할때 이 방법 써야함으로 기억!)
			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}   
		}

		
		System.out.println();
		String enc_utf8 = " %ED%8C%8C%EC%9D%B4%EC%8D%AC";  // utf-8  -> 인코딩된 걸 디코딩..
		
		try {
			System.out.println(URLDecoder.decode(enc_utf8, "UTF-8"));
 			System.out.println(URLDecoder.decode(enc_utf8, "euc-kr")); // 글자 꺠짐
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		
		
		
		

	} // end main()

} // end class
