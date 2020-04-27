package com.lec.java.crawl05inputsearchcrawlingyes24;

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
public class Crawl05Main {
	
	private static final String PATH = "books"; // 썸네일 저장할 경로 생성

	public static void main(String[] args) throws IOException {
		System.out.println("yes24.com 검색결과 페이지");
		
		// 3.호출 부 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		String serach = sc.nextLine();
		sc.close();
		
		Crawl05Main app = new Crawl05Main(); // 메인 인스턴스 만들기  
		ArrayList<InfoBook> list = app.crawlYes24(serach);   // 밑에 메소드가 static 안했으므로, 직접호출 불가.  app 인스턴스로 호출하고 ArrayList<InfoBook> 타입으로 리턴함으로 거기다 담기.  
		
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
	private ArrayList<InfoBook> crawlYes24(String search) throws IOException{ // 2. 메소드 만들기, 검색어를 받아서 크롤링한 결과를 InfoBook 배열 리스트에 담아보겠다.
		
		ArrayList<InfoBook> list = new ArrayList<InfoBook>(); // 리스트 생성
		
		String url ; 
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query=" + URLEncoder.encode(search, "euc-kr");
		//System.out.println(url); // 확인용
		doc = Jsoup.connect(url).execute().parse();
		
		// selector
		// #schMid_wrap > div:nth-child(3)
		
		
		elements = doc.select("#schMid_wrap > div.goods_list_wrap.mgt30").get(0).select("tr:nth-child(odd)"); // 두개의 클래스를 동시에 가지고 있는 div 클래스들 중, 첫번째꺼 (get(0))   의~ 또 연쇄 selector  뽑아내기. tr 의 홀수번째 자식들 뽑곘다.
		
		//System.out.println(elements.size() + "개"); // 확인용
		
		for(Element e : elements) {
			
			String imgUrl = e.selectFirst("td.goods_img > a > img").attr("src").trim();
			//System.out.println(imgUrl);
			
			//"td.goods_infogrp a > strong"(내가 생각한 selector)
			Element infoElement = e.selectFirst("td.goods_infogrp > p.goods_name > a");
			
			String bookTitle = infoElement.text().trim();
			String linkUrl = "http://www.yes24.com" + infoElement.attr("href").trim();   //   "http://www.yes24.com" 없이 하면 yes24.com 기준으로 상대경로가 나옴. 그러므로  앞에 이렇게 붙여줘야 함.
			
			System.out.println(bookTitle + " : " + linkUrl); // 확인용
			
			
			double price = Double.parseDouble(  
			e.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b").text().trim().replace(",", ""));  // 셀렉터해주고, 텍스트로 뽑아서, 콤마를 없애줌 -> 결과는 String 문자열 나오겠지?  그걸 Double 쩜. parseDouble 해줌. 그리고 double price 에 담아라!
			
			//System.out.println(price + "원"); // 확인용
			
			//--------------------------여기까지 내가 뽑고 싶은거 뽑았으므로, 이제 InfoBook 객체 생성----------------------------------------------
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		
		
		
		
		
		
		return list;
	}
	

} // end class
