package com.lec.java.crawl11practicewithjsonorg;

// 패키지11
// 패캐지 10 연습(XML parser & json.org 라이브러리 사용)

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;  // DOM 객체 파싱하는 객체임
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* XML, Json 파싱2
 * 
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/717077554f6c65653231554e5a6672/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/717077554f6c65653231554e5a6672/json/stationInfo/1/5/서울



 */

public class Crawl11Main {
	
	public static final String REQ_SERVICE = "stationInfo";  // TODO
	public static final String API_KEY = "717077554f6c65653231554e5a6672"; 

	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사(station) 정보");
		
		// TODO : API url 에 필요한 parameter 들
		int startIndex = 1;
		int endIndex = 5;
		String statnNm = "서울";
		
		String url_address;
		StringBuffer sb; // response 받은 덱스트 담을 StringBuffer
		
		
		System.out.println("--- XML 파싱 ---");
		//TODO
		url_address = buildUrlAddress("xml", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address); 		// url 에서 읽어들인걸 StringBuffer 로 읽어들이겠다.
		parseXML(sb.toString()); // url 로 읽어들인 걸 -> XML로 파싱하겠다. 
		
		
		
		System.out.println("--- JSON 파싱 ---");
//		TODO
		url_address = buildUrlAddress("json", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString()); // 제이슨 호출!
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	
//----------------------------url 규격대로 만드는 메소드 ----------------------------------------------------------
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String statnNm) throws IOException {
		
		String url_address = String.format("http://swopenapi.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s", 
				API_KEY, reqType, startIndex, endIndex, URLEncoder.encode(statnNm, "utf-8"));
		
		return url_address;
	}
	
	//TODO
	
//----------------------------FileIO 17번 패키지 메소드 ----------------------------------------------------------	
	
	/**
	 * 
	 * @param urlAddress : 주어진  url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML)를 StringBuffer 타입으로 리턴
	 */
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
				
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
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
	
	public static void parseXML(String xmlText) {
		
		// TODO
		
		//XML 파싱
				// DOM 로 XML 파싱하려면 이러한 객체를 사용해야 한다.
				DocumentBuilderFactory dbFactory; // DOM 객체 파싱하는 객체임
				DocumentBuilder dBuilder;  // 팩토리 객체 경유해서 만들어야 함.
				
				//DOM parser 객체 생성
				try {
					dbFactory = DocumentBuilderFactory.newInstance(); // 생성자 없음
					dBuilder = dbFactory.newDocumentBuilder();
					
					// String 로 받은 걸 -> InputStream (꽂음 )변환하고
					InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));
					
					// InputStream 으로 ->  DOM 객체 생성 한다.
					Document dom = dBuilder.parse(in);  // DocumentBuilder 로부터 in 을 파싱해서 DOM 객체로 만들기 //  org.w3c import
					
					// 정상적으로 엘리먼트 찾아가기... DOM의 Document 겍체 뽑아냈으므로,. 그거 따라서 내가 찾고자 하는 엘리먼트 찾아가는거임
					// DOM 최상위 document element 추출 (최상위 객체부터 끄집어 내야 함)
					Element docElement = dom.getDocumentElement();// 다큐먼트 객체로부터 뽑아옴. // DOM 의 최상위 Element인 'Document' 를 뽑아낸것.   org.w3c import
					
					// 파싱하기 전 normalize()
					docElement.normalize(); // 흩어진 text node 들을 정렬하는 등의 절차, 			
											// XML 파싱하기 전에 꼭 normalize() 부터 해주자.  특정노드가 흩어져 있을떄 정렬시켜주고 한데 모아주는 동작. (내부적 동작)
					
					// DOM 내의 데이터 파싱 
					NodeList nList = docElement.getElementsByTagName("row");  // <row> ... </row> element 들로 구성된 NodeList 를 리턴함.     긍까 하나하나의ㅡ데이터를 담는 거를 node 라고 부르는데, node 들을 담은 건 nodeList 타입으로 리턴한다...  
					
//					System.out.println("<row> 개수: " + nList.getLength());
					
					// 이 노드( row) 안에서 원하는 엘리먼트들 찾아야함.
					System.out.println();
					for (int i = 0; i < nList.getLength(); i++) {
						Node node = nList.item(i);  // row 5개      // 엘리먼트 노드, 텍스트 노드, 애트리뷰트 노드 .. 각각의 노드 타입이 있음. 이걸 체크하면서 가야함.  
						
//						System.out.println("node type: " + node.getNodeType());  // 정수값 리턴  '1' 은 엘리먼트 노드 타입을 의미.
						// 하나짜리 리스..  텍스트는 차일드로 가지고 있다. 
//				엘리먼트의 새끼가 텍스트를 가지고 있기 때문에. 
						// element node 인 경우만 파싱 진행
						if(node.getNodeType() != Node.ELEMENT_NODE) continue; // 1 이 아니면 제낌. ELEMENT_NODE 상수값  1
						
						Element rowElement = (Element)node; // 부모상속관계...   명시하는관계가 뭐냐?  오른쪽이 부모이기떄문에 강제형변환이 필요한 것. element extends node. node가 부모!!
						
						
//						각 row 에서 LINIE_NUM 엘리먼트의 텍스트들만 뽑아내보자!
//						System.out.println(rowElement.getTextContent()); // row 의 text()만 나옴.
						String statnId = rowElement.getElementsByTagName("statnId").item(0).getChildNodes().item(0).getNodeValue().trim(); // 애를 가지고 있는 엘리먼트들을 받음. 즉 엘리먼트 들을 가지고 있고, nodeList 타입을 리턴함. 	걔의 첫번째 노드 중	
						// 엘리먼트의 새끼를 찾아내서 걔의 text를 끄집어 내야 함. 
						// 새끼노드가 여러개 있을것 -> node들(s)로 나옴. 걔의 첫번쨰. 가 텍스트 노드임.
						// 걔가 가지고 있는 문자열!  우리가 찾아내려는 것이 바로 이 문자열 .
						// 이걸 String 타입의 LINE_NUM 에 담아보자. 
						String statnNm =	rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue().trim(); // 애를 가지고 있는 엘리먼트들을 받음. 즉 엘리먼트 들을 가지고 있고, nodeList 타입을 리턴함. 	걔의 첫번째 노드 중	
						String subwayNm =	rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue().trim(); // 애를 가지고 있는 엘리먼트들을 받음. 즉 엘리먼트 들을 가지고 있고, nodeList 타입을 리턴함. 	걔의 첫번째 노드 중	
						
						System.out.printf("%5s역 : %8s %5s\n",
								 statnNm, statnId, subwayNm);
					}
					
					/*
					 * 엘리먼트 하나만 리턴해도 list 배열에 담김.  
					 * 엘리먼트로 텍스트를 뽑아낼 수 없으므로,
					 * getChildnode() 로 순수 문자열을 뽑아내야한다. 
					 * nomalize()
						-> 숨어있는 텍스트랑 좌우공백 모두 한쪽으로 
						몰아 넣음! 
						
						item(0) -> 어차피 한개밖에 없는거 알고있으니까
						getChildnodeFirst() 이런거 없음! 
					 */
					
					
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) { // 인코딩 틀렸을 경우
					e.printStackTrace();
				} catch (SAXException e) { // 파싱 중 에러 생길 떄
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
	
	}// end parseXML()
	
	public static void parseJSON(String jsonText) {
		
		// TODO
		
		JSONObject jobj = new JSONObject(jsonText); // JSON 파싱 : JSONObject <- jsonText /   우리가 response  받은게 오브젝트이기때문에  매개변수로 받은 jsonText String 타입을  JSONObject로 변환. 
		JSONArray row = jobj.getJSONArray("stationList");  // 오브젝트를 가져욤. 에다가  row를 가져와야 함으로  제이슨배열로 접근
		
		System.out.println("row 의 개수 : " + row.length());
		System.out.println();
		
		for(int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i);
			
			String statnNm = station.getString("statnNm");
			String subwayNm = station.getString("subwayNm");
			String subwayId = station.getString("subwayId");
		
		
			System.out.printf("%5s역 : %8s %5s\n",
					 statnNm, subwayId, subwayNm);
		}
	} // end parseJSON()
	
} // end class
























