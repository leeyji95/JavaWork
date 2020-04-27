
package project.booksearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler implements Controller {

	// 싱글톤 디자인
	private static Crawler instance = null;
	private Crawler() {}
	public static Crawler getInstance() {
		if(instance == null) {
			instance = new Crawler();
		}
		return instance;
	}
	
	@Override
	public InfoStore crawlStore(String search, String bookStore, OnCompleteListener completeListener) {
		
		InfoStore infoStore = null;
		try {			
			switch(bookStore) {
			case C.YES24:
				infoStore = crawlYes24(search);
				break;
			case C.ALADDIN:
				infoStore = crawlAladdin(search);
				break;
			case C.INTERPARK:
				infoStore = crawlInterpark(search);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 크롤링 완료후 수행해야 할 코드
		if(completeListener != null) {
			completeListener.complete(infoStore);
		}
		
		return infoStore;
	}

	@Override
	public void saveData(String path, SearchResult result) {
		try(
				OutputStream out = new FileOutputStream(path);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				){
			oout.writeObject(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public SearchResult loadData(String path) {
		SearchResult result = null;
		
		try(
				InputStream in = new FileInputStream(path);
				ObjectInputStream oin = new ObjectInputStream(in);
				){
			
			result = (SearchResult)oin.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// Yes24 크롤링
	private InfoStore crawlYes24(String search) throws IOException {
		
		InfoStore infoStore = new InfoStore();
		infoStore.setStoreName(C.YES24);
		
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query="
				+ URLEncoder.encode(search, "cp949");
		
		// System.out.println(url);  // url 정상 동작 확인
		response = Jsoup.connect(url).execute();
		doc = response.parse();
		
		elements = doc.select("#schMid_wrap > div:nth-child(4)");
		// #schMid_wrap > div:nth-child(4)
		//System.out.println(elements.size());  // 1이 나와야 하는데...
		
		rowElements = elements.get(0).select("tr:nth-child(odd)");
		//System.out.println(rowElements.size());  // 20개 나와야 함
		
		
		for(Element element : rowElements) {
			String imgUrl = 
					element.selectFirst("td.goods_img > a > img").attr("src").trim();
			
			//System.out.println(imgUrl);
			
			// 책제목 & 가격 & 상세페이지 url
			Element a = element.selectFirst("td.goods_infogrp > p.goods_name > a");
			String bookTitle = a.text().trim();
			String linkUrl = "http://www.yes24.com" + a.attr("href");
			double price = Double.parseDouble(
					element.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b")
						.text().trim().replace(",", "")  
			);
			//System.out.println(bookTitle + ", " + linkUrl + ", " + price);
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		
		infoStore.setList(list);
		
		return infoStore;	
	}
	
	
	// 알라딘 크롤링
	private InfoStore crawlAladdin(String search) throws IOException {
		
		InfoStore infoStore = new InfoStore();
		infoStore.setStoreName(C.ALADDIN);
				
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
				
				String url;
				Document doc;
				Response response;
				Elements elements;
				Elements rowElements;
				
				url = String.format("https://www.aladin.co.kr/search/wsearchresult.aspx?SearchTarget=Book&KeyRecentPublish=0&OutStock=0&ViewType=Detail&CustReviewCount=0&CustReviewRank=0&KeyFullWord=%s&KeyLastWord=%s&CategorySearch=&chkKeyTitle=&chkKeyAuthor=&chkKeyPublisher=&chkKeyISBN=&chkKeyTag=&chkKeyTOC=&chkKeySubject=&KeyWord=%s", 
						 URLEncoder.encode(search, "cp949"),
						 URLEncoder.encode(search, "cp949"),
						 URLEncoder.encode(search, "cp949")
						);
				
				// System.out.println(url);  // url 정상 동작 확인
				response = Jsoup.connect(url).execute();
				doc = response.parse();
				
				
				rowElements = doc.select("#Search3_Result .ss_book_box");
				//System.out.println(rowElements.size());  // 20개 나와야 함
				
				
				for(Element element : rowElements) {
					String imgUrl = 
							element.selectFirst("img").attr("src").trim();
					
					//System.out.println(imgUrl);
					
					// 책제목 & 가격 & 상세페이지 url
					Element a = element.selectFirst("a.bo3");
					String bookTitle = a.text().trim();
					String linkUrl = a.attr("href").trim();
					double price = Double.parseDouble(
							element.selectFirst("span.ss_p2 span")
								.text().trim().replace(",", "")  
					);
					//System.out.println(bookTitle + ", " + linkUrl + ", " + price);
					list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
				}
				
				infoStore.setList(list);
				
		
		return infoStore;
	}
	
	// 인터파크 크롤링
	private InfoStore crawlInterpark(String search) throws IOException {
		
		InfoStore infoStore = new InfoStore();
		infoStore.setStoreName(C.INTERPARK);
		
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
				
				String url;
				Document doc;
				Response response;
				Elements elements;
				Elements rowElements;
				
				url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=" // 파라미터는 query~ 6바이트. //  query= 까지 url 복사 
						+ URLEncoder.encode(search, "cp949");
				
				// System.out.println(url);  // url 정상 동작 확인
				response = Jsoup.connect(url).execute();
				doc = response.parse();
				
				rowElements = doc.select("#bookresult > form > div.list_wrap");
				//System.out.println(rowElements.size());  // 20개 나와야 함
				
				
				for(Element element : rowElements) {
					String imgUrl = 
							element.selectFirst("img.bd").attr("src").trim();
					
					//System.out.println(imgUrl);
					
					// 책제목 & 가격 & 상세페이지 url
					Element a = element.selectFirst("div.info > p.tit a");
					String bookTitle = a.text().trim();
					String linkUrl = a.attr("href").trim();
					double price = Double.parseDouble(
							element.selectFirst("div.price > p.FnowCoupon > span.nowMoney")
								.text().trim().split("원")[0].replace(",", "")      // 텍스트 꺼내고, 공백 제거해주고, '원' 으로 두덩이 잘라주고, 첫번째 에서 , 를 빈문자로  replace 해주면 됨.   // 이렇게 실무에서  문자열 자율자제할 주 ㄹ알아야.
					);
					//System.out.println(bookTitle + ", " + linkUrl + ", " + price);
					list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
				}
				
				infoStore.setList(list);
		
		
		return infoStore;
	}
	
}









