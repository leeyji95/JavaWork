package com.lec.java.crawl11practicewithjsonorg;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prac {
	
	public static final String API_KEY = "717077554f6c65653231554e5a6672"; 
	
	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사(station) 정보");

		int startIndex = 1;
		int endIndex = 5;
		String statnNm = "서울";
		String url_address;
		URL url = new URL(buildUrlAddress("json", startIndex, endIndex, statnNm));
		
		ObjectMapper mapper = new ObjectMapper();
		Subway subway = mapper.readValue(url, Subway.class);
		
		for(Station e : subway.getList()) {
			System.out.print("");
		}
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String statnNm) throws IOException {
		
		String url_address = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s", 
				API_KEY, reqType, startIndex, endIndex, URLEncoder.encode(statnNm, "utf-8"));
		
		return url_address;
	}
} // end class

class Subway{
	private List<Station> list;

	public List<Station> getList() {
		return list;
	}

	public void setList(List<Station> list) {
		this.list = list;
	}
}

class Station{
	private String statnNm;
	private String subwayId;
	private String subwayNm;
	private String statnNmEng;
	public Station() {
		super();
	}
	public Station(String statnNm, String subwayId, String subwayNm, String statnNmEng) {
		super();
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
		this.statnNmEng = statnNmEng;
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
	public String getStatnNmEng() {
		return statnNmEng;
	}
	public void setStatnNmEng(String statnNmEng) {
		this.statnNmEng = statnNmEng;
	}
	
}

