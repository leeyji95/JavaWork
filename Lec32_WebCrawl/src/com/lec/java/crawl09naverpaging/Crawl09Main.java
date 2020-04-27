package com.lec.java.crawl09naverpaging;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 연습
// 네이버 ' 검색어'
// 블로그
// 목록에서 크롤링할 목록들 
// post title 
// post url 
// blog title 

// 페이징 구현!!


public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 검색, 페이징");
		
		for(int i = 1; i <=10; i++) {
				crawlNaverBlog("파이썬", i);
				System.out.println();
		}
		
		System.out.println("\n프로그램 종료");
		
	}// end main()
	
	public static void crawlNaverBlog(String search, int page) throws IOException {
		
		// 매개변수 검증
		if(search == null || search.trim().length() == 0 || page < 1 ) return;
		
		String url ; 
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		System.out.println(page + " 페이지]");
		
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d", 
				URLEncoder.encode(search, "utf-8"), (page-1) * 10 + 1);  // 핵심 ~~
//		System.out.println(url);
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("ul#elThumbnailResultArea .sh_blog_top");
//		System.out.println(elements.size());
		
		
		for(Element e : elements) {
			
			String postTitle = e.selectFirst("dt > a").text().trim();  // a 태그의 첫번째 
			String blogTitle = e.selectFirst("dd a").text().trim();
			String postUrl = e.selectFirst("a").attr("href").trim();
			System.out.println(postTitle + " : 	"  +  blogTitle  + " : "  + postUrl);
			
		} // end for
	
		
		
		
	} // end crawlNaverBlog()

} // end class
