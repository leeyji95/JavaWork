package test;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

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
		System.out.println(elements.size() + "개"); // 5개
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
		}
		

	}

}
