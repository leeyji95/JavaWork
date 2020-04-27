package com.lec.java.crawl01uselib;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Navermovie {

	public static void main(String[] args) throws IOException {
System.out.println("영화 인기 검색어");
		
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn"; // 크롤링할 주소
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		response = Jsoup.connect(url).execute();
//		System.out.println(response.statusCode()); // 200
		
		doc = response.parse();
		
	
		//div:nth-child(1)   !!!!!!!
		elements = doc.select("#assistant div:nth-child(1) ul > li > a");
//		System.out.println(elements.size() + "개"); // 5개
		
		
		
		// a 엘리먼트 안에 있는 특정 엘리먼트만 뽑기
		for(Element e : elements) {
			e.selectFirst("span.blind").remove();   // remove () -> span이 부모인 a로부터 스스로 빠지는 거다. // 1위, 2위 ...  텍스트 <span> 없애려면 해당 element 삭제(remove())
			System.out.println(e.text().trim());
		}
		
		
		
		
		

	}

}
