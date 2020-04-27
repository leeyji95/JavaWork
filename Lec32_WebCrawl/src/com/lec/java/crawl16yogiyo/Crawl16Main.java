package com.lec.java.crawl16yogiyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=
// 도대체 뭘로 막았놨을까?  
// 애녜는  헤더값에 특정 값을 집어넣었다...
public class Crawl16Main {

	public static void main(String[] args) throws IOException, IOException {
		System.out.println("요기요 맛집정보: header 추가");
		
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=";
		
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb);  // -> 400 나옴 
		
		ObjectMapper mapper = new  ObjectMapper();
//		mapper.readValue(sb.toString(), /*TODO*/);    // 클래스 만들어야 함.
		//맛집이름과 평점
		
		Yogiyo goodRes = mapper.readValue(sb.toString(), Yogiyo.class);
//		System.out.println(goodRes.getRestaurants());
		
		for(Restaurant e : goodRes.getRestaurants()) {
			System.out.printf("%s %.2f\n", e.getSlug(), e.getReview_avg());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public static StringBuffer readFromUrl(String urlAddress) {
		
		StringBuffer sb = new StringBuffer(); // response  받는 데이터 담을 객체
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection
		
		InputStream in = null;
		InputStreamReader reader = null; // 바이트 단위로 읽어들이는 inputstream 을  문자단위로 읽어들이게끔  inputstreamreader 만든다.
		BufferedReader br = null;
		
		char[] buf = new char[512]; // 문자타입의 사용자 버퍼 준비
		
		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection  
		// HttpURLConnection 으로 인터넷과 연결시도, 웹에다가 InputStream 빨대꽂고, 거기다가 InputStreamReader 꽂고, 마지막으로 BufferedReader 객체로 읽어들일 것! 
		
		try {
			url = new URL(urlAddress); // url 객체 생성
			conn = (HttpURLConnection)url.openConnection(); // Connection 객체 생성
			
			if(conn != null) { // Connection 이 null 이 아닌 경우에만 수행되도록. 없는 url 이면 어째?   존재한다하더라도, 서버와 클라이언트의 데이터 주고받는 시간이 걸림.
				// 이 시간이 너무 오래 마냥 기다릴 수 없으므로,(프로그램 먹통되지 않도록 하기 위해서)
				conn.setConnectTimeout(2000); // 2초 이내에 '연결' 이 수립안되면 
											// java.net.SoketTimoutException 발생 하도록  핸들링
											
				
				conn.setRequestMethod("GET"); // GET 방식 request 
				// "GET", "POST" ...  request 하는 여러가지 방식이 있다.
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); 
				conn.setUseCaches(false); // request 할 때 cache 사용 안하겠다.  cache -> 서버가 기억해두고 있다는 것. 
				
				
				
				
// 추가작성		// 헤더 정보 추가
				conn.setRequestProperty("x-apikey", "iphoneap");
				conn.setRequestProperty("x-apisecret", "fe5183cc3dea12bd0ce299cf110a75a2");
				
				
				
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay               // -> 실제 request 발생 여기서 함으로, --> 그 전에 헤더 정보 추가 하기.
				System.out.println("response 완료");
				
				
				// response 이후 가장 먼저 해야할 것이 -> response 에 담겨있는 코드값 확인 !!
				int responseCode = conn.getResponseCode();
				System.out.println("response code: " + responseCode);
				
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status              
				// 서버는 코드값을 담아오는데, 200 만이 정상적으로 response 가 처리.  // 404 Not Found
				// 정상적일떄만 처리하면 되기 때문에.
				if(responseCode == HttpURLConnection.HTTP_OK) {
					// B < - A  A에서 B 뽑아옴.
					in = conn.getInputStream(); // InputStream <- HttpURLConnection  
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader);  //  BufferedReader <- InputStreamReader
					
					int count = 0; // 읽은 글자 개수
					while((count = br.read(buf)) != -1) {  //버퍼에 담긴 내용을 StringBuffer 에 append!
						sb.append(buf, 0, count);  // 버퍼의 0번째 부터 읽은 곳 -1 까지  StringBuffer 에 추가   // response 받은 텍스트를 StringBuffer 에 추가 하는 동작 
					}
					
				} else {
					System.out.println("response 실패");
					return null;
				}
			}else {
				System.out.println("conn null");
				return null;
			}
			
			
			
		} catch (MalformedURLException e) { // 제대로 된 형식이 아닌 url 이라면  MalformedURLException
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect(); // 작업 끝나고 Connection  해제(Connection 도 자원이므로)
		}
		
		
		
		return sb;
}

	
	
} // end class



@JsonIgnoreProperties(ignoreUnknown = true) 
class Yogiyo{  // 배열 원소 담고 있는 오브젝트 전체  클래스 
	
	private List<Restaurant> restaurants = new ArrayList<Restaurant>();

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	

}



@JsonIgnoreProperties(ignoreUnknown = true) 
class Restaurant{
	
	private String slug;
	private double review_avg;
	
	
	public Restaurant() {
		super();
	}
	public Restaurant(String slug, double review_avg) {
		super();
		this.slug = slug;
		this.review_avg = review_avg;
	}
	
	
	
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public double getReview_avg() {
		return review_avg;
	}
	public void setReview_avg(double review_avg) {
		this.review_avg = review_avg;
	}
	
	
	
	
}



