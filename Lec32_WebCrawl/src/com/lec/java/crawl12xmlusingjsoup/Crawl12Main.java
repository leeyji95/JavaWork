package com.lec.java.crawl12xmlusingjsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/*
 * Jsoup 을 이용한 xml 파싱
 * 
 * 
 * 데이터 주고 받을 떄 많이 쓰는 파싱 방법들이 많다.
 * Jsoup 이용하여 파싱하는 방법도 괜찮다. 
 * 이말은 즉?  더 더 더 괜찮은 방법이 많다는 것!  그만큼 많이들 쓰고 있다는 것!
 * 
 * 다양한 방법 알아두고, 알맞게 이용하자
 * 
 */

public class Crawl12Main {

	public static final String REQ_SERVICE = "stationInfo";  
	public static final String API_KEY = "717077554f6c65653231554e5a6672"; 
	
	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철호서별 역별 승하차 인원 정보");
		String url = buildUrlAddress("xml", 1, 20, "20200325");
		
		// XML 파싱할때는 xml parser 를 사용한다
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();  //    XML 파싱 Jsoup 으로 하는 방법!
		Elements elements =  doc.select("row");
		
		for(Element e : elements) {
			String LINE_NUM = e.selectFirst("LINE_NUM").text().trim();
			String SUB_STA_NM = e.selectFirst("SUB_STA_NM").text().trim();
			String RIDE_PASGR_NUM =	e.selectFirst("RIDE_PASGR_NUM").text().trim();
			String ALIGHT_PASGR_NUM = e.selectFirst("ALIGHT_PASGR_NUM").text().trim();
			
			System.out.printf("%5s : %8s역[승차:%6s 하차:%6s]\n",
					LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
		}
		
//		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
//		Elements elements = doc.select("row");
//		for(Element e : elements) {
//			System.out.println(
//					e.selectFirst("LINE_NUM").text().trim() +
//					e.selectFirst("SUB_STA_NM").text().trim() +
//					e.selectFirst("RIDE_PASGR_NUM").text().trim() +
//					e.selectFirst("ALIGHT_PASGR_NUM").text().trim());
//		}
//		
		
		

	} // end main()

	
	
	public static String buildUrlAddress(String reqType, int startIndex,
				int endIndex, String date) {
	
	String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/CardSubwayStatsNew/%d/%d/%s", 
	API_KEY, reqType, startIndex, endIndex, date);  // 공공데이터 요청인자가지고 -> API url 규격대로 만든 것임!
	
	return url_address;
	} 	// end buildUrlAddress()
}
