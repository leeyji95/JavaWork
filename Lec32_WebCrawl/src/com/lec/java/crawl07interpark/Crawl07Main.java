package com.lec.java.crawl07interpark;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 크롤링 할 것 : 책제목, url, 가격, 썸네일의 url(이미지주소)

/*
 * '검색어' 입력받아서 
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 * 	 팩이름 / 책가격 / 상세페이지 url / 썸네일 url    가져와보쟈!
 * 
 * yes24.com 검색페이지는 euc-kr 로 URL 인코딩되어 있다. 
 * 		한글 1글자당 2byte 인코딩(된걸 보고 알 수 있음)
 *  
 */
/*
<url 분석>
http://www.yes24.com/searchcorner/Search
?
keywordAd=&
keyword=&
domain=ALL&
qdomain=%C0%FC%C3%BC&
Wcode=001_005&
query=%C6%C4%C0%CC%BD%E3  --> 2바이트씩 인코딩되어 있으므로 -> euc-kr 



// Q: 어쩔 땐 메인부 인스턴스 생성하고, 어떤땐  static.. 이렇게 하고.. 설계를 어떻게 함?
 * --> 밑에 메소드를 static으로 만들면 static 변수 와 메소드로만 사용해야 함으로, 복붙의 어려움? 이 있다. 
 * 예전에  크롤링할 때 알라딘에 붙여 넣고, 또 인터파크에 붙여넣고 할 때 용이하기 때문에..?



 */
public class Crawl07Main {
	
	private static final String PATH = "books"; // 썸네일 저장할 경로 생성

	public static void main(String[] args) throws IOException {
		System.out.println("book.interpark.com 검색결과 페이지");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		String serach = sc.nextLine();
		sc.close();
		
		Crawl07Main app = new Crawl07Main(); // 메인 인스턴스 생성
		ArrayList<InfoBook> list = app.crawlInterPark(serach);  
		
		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg ~ thumb020.jpg ...
		int fileIndex = 1;
		for(InfoBook e : list) {
			System.out.println(e); // 크롤링 정보 출력
			
			// 썸네일 이미지 다운로드 
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgUrl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);
			
			System.out.println(fileName + " 이 저장되었습니다!");
			fileIndex++;
		}
		
	} // end main()
	
//-----------------메소드---------------------------------------------------------------------------------------------------------------------------------------------------------------	
	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException{ // 2. 메소드 만들기, 검색어를 받아서 크롤링한 결과를 InfoBook 배열 리스트에 담아보겠다.
		
		ArrayList<InfoBook> list = new ArrayList<InfoBook>(); // 리스트 생성
		
		String url ; 
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		// TODO
		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=" + URLEncoder.encode(search, "euc-kr");
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#bookresult div.list_wrap");
//		System.out.println(elements.size());
		
		for(Element e : elements) {
			
			String imgUrl = e.select("img.bd").attr("src").trim() ;
//			System.out.println(imgUrl);
			
			Element infoElement = e.selectFirst("div.info b a");
			String bookTitle = infoElement.text().trim();
			
			String linkUrl = infoElement.attr("href").trim();
			
//			System.out.println(bookTitle + " : " + linkUrl);
			
			double price = Double.parseDouble(
			e.selectFirst("div.price > p.FnowCoupon > span.nowMoney").text().trim().split("원")[0].replace(",", ""));
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		
		return list;
	}
	

} // end class
