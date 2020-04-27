package com.lec.java.crawl08paging;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* 크롤링 검색 페이징
 * 	- '첫 페이지' url
 * 	- '두번째 페이지' 부터의 url 변화 확인:  어떤 방식? 어떤 parameter 사용?
 * 	- 검색결과 페이징의 '마지막 페이지'는 어떻게 처리하는지 확인
 *  
 */


public class Crawl08Main {

	public static void main(String[] args) throws IOException {
		System.out.println("페이징: Pagination");
		
		for(int i = 0; i <= 10; i++) {
			
			crawlDaumBlog("파이썬", i);
			System.out.println();
		}
		
		
		System.out.println("\n프로그램종료");
	} // end main()
	
	// n 번째 페이지 출력하는 메소드 
	/**
	 * 
	 * @param search 검색어
	 * @param page 검색할 결과 page 번호
	 * @throws IOException 
	 */
	public static void crawlDaumBlog(String search, int page) throws IOException {
		
		// 목록에서 크롤링할 목록들 
		// post title 
		// post link url 
		// blog title 
		
		// 매겨변수 검증!
		if(search == null || search.trim().length() == 0 || page < 1 ) return;  // 실무에서는 매번 이런식으로 체크 해주고 넘어가야함!
		
		String url ; 
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		System.out.println(page + " 페이지]");
		
		url = String.format("https://search.daum.net/search?w=blog&DA=PGD&enc=utf8&q=%s&page=%d", 
				URLEncoder.encode(search, "utf-8"), page); // 인코딩값은 %s에, 페이지 넘버는 %d 에 들어갈 것
		System.out.println(url);
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#blogColl .list_info div.wrap_cont");
//		System.out.println(elements.size());
		
		for(Element e : elements) {
			
			String postTitle = e.selectFirst("a").text().trim();  // a 태그의 첫번째 
			String blogTitle = e.selectFirst("div.info .f_nb").text().trim();
			String postUrl = e.selectFirst("a").attr("href").trim();
			System.out.println(postTitle + " : 	"  +  blogTitle  + " : "  + postUrl);
		} // end for
		
		
		
		
		
		
	} // end crawlDaumBlog()
	

} // end class
