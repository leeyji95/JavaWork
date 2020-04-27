package com.lec.java.crawl04naver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url ; 
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		// 내가 검색한 거를 가지고 인코딩해보자!
		
		String encoded = URLEncoder.encode(searchKeyword, "utf-8");  //  모든 페이지가 utf-8 아님,  내가 인코딩하고자 하는 페이지의 url 인코딩을 확인해야한다!  query String이 3바이트씩 읽히면 -> utf-8로, 2바이트씩이면 euc-kr로!!
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=" + encoded; 
		
		System.out.println(url); // 생성된 url 확인해보자
		
		doc = Jsoup.connect(url).execute().parse();
		
		// 연관검색어 출력하기
		elements = doc.select("#nx_related_keywords ul._related_keyword_ul li a");
		System.out.println(elements.size() + " 개");
		for(Element e : elements) {
			System.out.println(e.text().trim());
//			System.out.println(e.attr("href"));
		}
		
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	}  // end main()

} // end class
