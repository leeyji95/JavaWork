package com.lec.java.crawl14rideinfo;
/* XML, Json 파싱1
 * 
 * (컨트롤 누른상태에서 클릭 -> 넘어감)
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1  
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/717077554f6c65653231554e5a6672/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/717077554f6c65653231554e5a6672/json/CardSubwayStatsNew/1/5/20181001 
 * */

import java.io.IOException;
import java.net.URL;
import java.util.List;

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습");
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/717077554f6c65653231554e5a6672/json/CardSubwayStatsNew/1/5/20181001");
		
		Subway subway = mapper.readValue(url, Subway.class); // 변환할 자바 객체 타입으로 변환하겠다. url 로부터 데이터 읽어들여서 ->subway 객체로 변환한 걸 리턴함. 
		
		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());  // subway.getCardSubwayStatsNew() 이놈이 NPE 을 리턴...  CardSubwayStats 를 private에서 public 으로 해주면 나옴. 그 이유는?  왜 이것만 public  ?  찾아보자... 
		
		for(SubRow e : subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역[승차:%6s 하차:%6s]\n",
					e.getLineNum(),
					e.getStationName(),
					e.getRidePassenger(),
					e.getAlightPassenger());
		}
		
		System.out.println("\nㅍ로그램 종료");
	} // end main()
 
} // end class


// 변환받을 자바객체 만드는 중, 클래스 이름은 마음대로, 그러나 q변수선언은 프라퍼티 그대로. 
//기본적으로 모든 프라터피의 변수가 선언이 되어야 하는데, 내가 원하는 것만 선언하고 싶으면 -> 어노테이션 사용.    ㄱ컴파일러쪽에 알려줘서 백그라운드 동작..

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{
	public Stats CardSubwayStatsNew;  //CardSubwayStatsNew 는 list_total_count 를 가지고 있으므로  애ㅒ 타입으로 만들어준다

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		this.CardSubwayStatsNew = cardSubwayStatsNew;
	}
	
}// end Subway



@JsonIgnoreProperties(ignoreUnknown = true)
class Stats{ // 오브젝트 안에 오브젝트니까 클래스 만드는 거지. 
	private int list_total_count;
	
	private List<SubRow> row ;  //-> 제이슨에서 row 는 배열 타입이므로 

	// getter & setter
	public int getList_total_count() {return list_total_count;}
	public void setList_total_count(int list_total_count) {this.list_total_count = list_total_count;}
	public List<SubRow> getRow() {return row;}
	public void setRow(List<SubRow> row) {this.row = row;}
}// end Stats




// JSON 필드명과 매핑되는 Java 객체의 변수명을 달리 하고 싶다면  아래와 같은 방법을 쓰세요
// @jsonProperty 사용

@JsonIgnoreProperties(ignoreUnknown = true)     // 아래 클래스 멤버변수에 명시되지 않은 제이슨의 다른 프라퍼티들은 신경쓰지 않겠다
class SubRow {
	@JsonProperty("LINE_NUM") // Json 의 LINE_NUM  --> lineNum 우로 매핑 하겠다. 
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePassenger;
	
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPassenger;

	public SubRow() {super();}
	
	
	

	public SubRow(String lineNum, String stationName, int ridePassenger, int alightPassenger) {
		super();
		this.lineNum = lineNum;
		this.stationName = stationName;
		this.ridePassenger = ridePassenger;
		this.alightPassenger = alightPassenger;
	}




	public String getLineNum() {return lineNum;}
	public void setLineNum(String lineNum) {this.lineNum = lineNum;}
	public String getStationName() {return stationName;}
	public void setStationName(String stationName) {this.stationName = stationName;}
	public int getRidePassenger() {return ridePassenger;}
	public void setRidePassenger(int ridePassenger) {this.ridePassenger = ridePassenger;}
	public int getAlightPassenger() {return alightPassenger;}
	public void setAlightPassenger(int alightPassenger) {this.alightPassenger = alightPassenger;}
	
	
	
	// Retrofit
	// volley 
	
	// 얘네는 안드로이드 시간에 배우겠습니다~
	
	
	
} // end SubRow































