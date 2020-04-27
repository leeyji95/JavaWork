package com.lec.java.crawl03daum;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException  {
		System.out.println("Daum 인기 검색어");
		
		String url = "https://www.daum.net/";
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		response = Jsoup.connect(url).execute();
		System.out.println(response.statusCode());
		
		doc = response.parse();
		
		elements = doc.select("ul.list_favorsch li a");
		System.out.println(elements.size());
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href"));
		}
		
// 연습		
		elements = doc.select("ul.list_txt li a");
		for(Element e : elements) {
			System.out.println(e.text().trim());
		}
		
		
		
		System.out.println("\n프로그램 종료");
	}

}
