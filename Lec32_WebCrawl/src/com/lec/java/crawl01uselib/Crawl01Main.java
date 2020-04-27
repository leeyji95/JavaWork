package com.lec.java.crawl01uselib;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/*
 * 외부 라이브러리를 사용한 자바 프로젝트
 * 1. 라이브러리 다운로드
 * 2. 프로젝트내 (혹은 특정경로)에 라이브러리 저장
 * 3. 프로젝트의 BuildPath 설정
 */
// 프로그래밍에서 라이브러리란 뭐냐?  사람들이 많이 쓰는 객체를 모아놓은 것. 확장자가 jar   java archiive 의 약자..   

/*
 * 1. https://jsoup.org/ 에서 다운로드 
 * 2. 프로젝트에 폴더 만들고(ex: libs) 라이브러리 복사 (컨트롤 씨 컨트롤 브이)
 * 3.  프로젝트 우클릭 - Configure Build Path - Library탭 - Add Jars (혹은 라이브러리 추가) - 추가할 라이브러리 선택
 */

public class Crawl01Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");
		
		String url; // 크롤링할 주소 url
		Response response; // response 객체   jsoup import  
		Document doc; // Jsoup 의 document  object model 객체
		Element element; // HTML 의  element 표현 객체   // 특정 엘리먼트들을 나타내는 겍체 (크롤링도 엘리먼트 단위로 이루어지기 때문에)
		
		url = "https://www.naver.com/";
		response = Jsoup.connect(url).execute(); // connection 객체 생성하고, request 수행함.  throws IOException 하기.  이게 reponse 타입으로 리턴함으로 -> response 에 담기.
					// GET 방식 request 는 다음과 같이 해도 된다. 
					// Jsoup.connect(url).get();
		
		System.out.println(response.statusCode()); // 200 ? -> OK 
//		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
		System.out.println(response.statusMessage()); // statusCode() 200 에 대한 메시지 
		
		doc = response.parse();  // response 타입을 doc 객체로 바꿈.  doc-> 전체 html 을 뽑아낸 것. 
		
		System.out.println(doc.title()); // <title> element 의 Content 를 가져옴.  얘는 화면에 보이는 것이 아니고, 브라우저 탭에 보이는 텍스트. 
		System.out.println(doc.location()); // 현재 웹문서의 url 
		
		String outerHtml = doc.outerHtml(); // 현재 node 의 outer html 텍스트 
		//System.out.println(outerHtml);
		System.out.println(outerHtml.substring(0, 200) + "...");
		
		
		// DOcument 나 Element 객체의
		// select(), selectFirst() 메소드로 특정 element(들)을 추출
		System.out.println("[네이버 뉴수 캐스트]");
		
		element = doc.selectFirst("#news_cast");  // 검색된 Element  들 중 최초 1개만 Element 로 리턴 
		//System.out.println(element.outerHtml());
		 
		Elements newsElements = doc.select("#news_cast li.ca_item");  // 검색된 Element 들이 담겨 있는  Elements 리턴  // ___  얘는 엘리먼 츠!! 를 리턴한다~ 여러개의 엘리먼트들을 리턴한다 
		
		// 복수개 목록 크롤링 할 시, 내가 원하는 '개수'만큼 크롤링 되었는지 우선 확인해보자! 
		System.out.println(newsElements.size() + " 개");
		for(Element e : newsElements) {
			//System.out.println(e.outerHtml()); // 각각의 엘리먼트 li 안에 a 엘리먼트 있다. 
			element = e.selectFirst("a"); // 각각의 엘리먼트 li 에 있는 a 엘린먼트를 뽑아내자      // 찾아낸 엘리먼트에서 또 찾아내기 
			System.out.println(element.text()); // Element 의 text() -> text 들을 묶어서 하나로 리턴 (제목)
			System.out.println(element.attr("href"));  //  링크 뽑아내기 
		}
		
		
		System.out.println("\n프로그램종료");
	} // end main

} // end class
