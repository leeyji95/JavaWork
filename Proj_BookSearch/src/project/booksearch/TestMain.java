  
package project.booksearch;

import java.util.Date;

public class TestMain {

	Crawler cr = null;
	SearchResult result = null;
	
	public static void main(String[] args) {
		TestMain app = new TestMain();
		app.init();
		app.run();
	}
	
	public void init() {
		cr = Crawler.getInstance();
	}
	
	public void run() {
		String search = "파이썬";  // 검색어
		
		result = new SearchResult();
		result.setSearch(search);
		result.setDate(new Date());
		
		
		InfoStore store;
		
		store = cr.crawlStore(search, C.YES24, null);
		result.setStoreYes24(store);
		
		store = cr.crawlStore(search, C.ALADDIN, null);
		result.setStoreAladdin(store);
		
		store = cr.crawlStore(search, C.INTERPARK, null);
		result.setStoreInterpark(store);
		
		
		
		
		System.out.println(result);
		
		// 크롤링 결과 -> 파일 저장
		cr.saveData("data/test.data", result);
		
		result = null;   // 기존 데이터 삭제
		
		// 파일 -> 읽어오기
		
		result = cr.loadData("data/test.data");
		System.out.println(result);
		
		
		
	}
	
	
	

}






