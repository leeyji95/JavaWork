package com.lec.java.crawl02nate;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args) throws Exception {
		System.out.println("네이트 인기 검색어");
		
		String url = "https://www.nate.com/"; // 크롤링할 주소
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		response = Jsoup.connect(url).execute(); // connection 객체 생성하고, request 요청
		System.out.println(response.statusCode()); // 200 확인
		System.out.println(response.statusMessage());// OK 메시지 확인
		
		doc = response.parse(); // response 객체를 Document 객체로 변환
		
//		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#header .search_keyword dd a");
		System.out.println(elements.size() + "개"); // 5개
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		
		System.out.println("\n프로그램 종료");
	}

}
