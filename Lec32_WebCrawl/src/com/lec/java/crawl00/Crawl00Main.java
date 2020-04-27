package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jsoup");
		
		Element element;
		Elements elements;
		
		File f = new File("data/hello.html"); // \ 한개로 seperator 할 경우 이스케이프 문자로 인식되어 에러. 역슬래쉬 쓰고 싶으면 \\ 써야함
		Document doc = Jsoup.parse(f, "UTF-8"); // 파일을 다큐먼트 오브젝트로 변환한다. 는 의미 parse()가.
												// 파일에서 -> Document 변환(DOM구조 변환)
// 확인	System.out.println(doc.outerHtml()); // 전체 HTML 문서 뽑음!
		
		// DOcument 나 Element 객체의
		// select(), selectFirst() 메소드로 특정 element(들)을 추출
		
		element = doc.selectFirst("div");
//		System.out.println(element.outerHtml()); // 첫번째 div 엘리먼트 영역 html 문서 출력
		
		elements = doc.select("div");
		System.out.println(elements.size() + " 개");
		
		// Elements 의 get(n) -> n번째 Element 리턴
//		element = elements.get(3);
//		System.out.println(element.outerHtml());
//		
//		for(Element e : elements) {
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}
		
		element = doc.selectFirst("div#addr");
//		System.out.println(element.outerHtml());
		
		elements = element.select("ul.favorite a"); // 어느 엘리먼트에서 select 하는가.   favorite 클래스이름을 가진 ul 엘리먼트의 자손 a 엘리먼트
		System.out.println(elements.size() + "개");
		
		for(Element e : elements) {
// 확인	System.out.println(e.outerHtml());
			System.out.println(e.text().trim());  // 엘리먼트 안에 있는 글자(text)만 뽑아냄(content),  기본적으로 좌우공백 제거 하고 뽑기
			System.out.println(e.attr("href"));
		}
		
		System.out.println();
//------------------------ 실 습------------------------------------------------------------
		elements = doc.select("div.article img");
		for(Element e : elements) {
			System.out.println(e.attr("src"));
		}
		
		
		System.out.println();
//-------------------------- 쌤이 하신거... --> 한 번에 하기..-----------------------------------
		for(Element img : doc.select("img")) {
			System.out.println(img.attr("src").trim());
		}
		
		
		
		System.out.println("\n프로그램종료");
	} // end main()
	
} // end class
