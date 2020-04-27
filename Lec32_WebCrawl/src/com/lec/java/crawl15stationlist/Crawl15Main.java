package com.lec.java.crawl15stationlist;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

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

public class Crawl15Main {
	
	public static final String API_KEY = "717077554f6c65653231554e5a6672";
	
	public static void main(String[] args) throws IOException, IOException {
		System.out.println("jackson");
	
		ObjectMapper mapper = new ObjectMapper();
	
		int startIndex = 1;
		int endIndex = 5;
		String statnNm = "서울";
		String url_address;
		URL url = new URL(buildUrlAddress("json", startIndex, endIndex, statnNm));
		
		Subway subway = mapper.readValue(url, Subway.class);
		
		for(Station e : subway.getStationList()) {
			System.out.printf("%5s역 : %8s %5s\n",
					e.getStatnNm(),
					e.getSubwayId(),
					e.getSubwayNm());
			}
		
		System.out.println("\n프로그램 종료");
	} // end main()



	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String statnNm) throws IOException {
		
		String url_address = String.format("http://swopenapi.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s", 
			API_KEY, reqType, startIndex, endIndex, URLEncoder.encode(statnNm, "utf-8"));
		
		return url_address;
		}
	
	} // end class



@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {   // 인스턴스 
	
	private List<Station> stationList;  // 이름을 같게!!!

	public Subway() {}
	
	public Subway(List<Station> stationList) {this.stationList = stationList;}
	
	public List<Station> getStationList() {return stationList;}
	public void setStationList(List<Station> stationList) {this.stationList = stationList;}

	
}



@JsonIgnoreProperties(ignoreUnknown = true) 
class Station{
	private String statnNm;
	private String subwayId;
	private String subwayNm;

	
	public Station() {
		super();
	}
	
	
	public Station(String statnNm, String subwayId, String subwayNm) {
		super();
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}
	
	
	
	public String getStatnNm() {
		return statnNm;
	}
	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}
	public String getSubwayId() {
		return subwayId;
	}
	public void setSubwayId(String subwayId) {
		this.subwayId = subwayId;
	}
	public String getSubwayNm() {
		return subwayNm;
	}
	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
} // end Station








