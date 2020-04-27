package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {

	public static final String API_KEY = "717077554f6c65653231554e5a6672";
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.print("날짜입력 :");
		String date = sc.nextLine();
		System.out.print("시작Index :");
		int startIndex = sc.nextInt();
		System.out.print("끝Index : ");
		int endIndex = sc.nextInt();
		sc.close();
		
		
		System.out.println("[XML]");
		System.out.println("날짜              구ID    총생활인구수              일최대이동인구수");
		System.out.println("------------------------------------------------------------");
		String url = buildUrlAddress("xml", startIndex, endIndex, date); // url
		
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
		
		//  날짜             구ID        총생활인구수           일최대이동인구수
		for(Element e : elements) {
			
			String guID= e.selectFirst("SIGNGU_CODE_SE").text().trim();  // 구ID
			String totalLPN = e.selectFirst("TOT_LVPOP_CO").text().trim(); // 총 생활 인구 수
			String dailyMaxMPN = e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();  // 일일 최대 이동 인구 수
			
			System.out.println(String.format("%s %5s \t%s \t%s", date, guID, totalLPN, dailyMaxMPN));
		}
		
		
		System.out.println("\n[JSON]");
		System.out.println("날짜              구ID    총생활인구수              일최대이동인구수");
		System.out.println("------------------------------------------------------------");
		
//		url = buildUrlAddress("json", startIndex, endIndex, date); // JsonParseException  -> String : 문자열로 json 읽어들여서 파싱해야함.
		URL url1 = new URL(buildUrlAddress("json", startIndex, endIndex, date)); // 해당 웹주소 받아서 josn 파싱
		
		ObjectMapper mapper = new ObjectMapper();
		SeoulLP seoulLP = mapper.readValue(url1, SeoulLP.class);
		
		
		for(Row e : seoulLP.getJachiGuDailySum().getRow()) {
			System.out.println(String.format("%s %5s \t%s \t%s", date, 
					e.getGuID(), // 구ID
					e.getTotalLPN(), // 총 생활 인구 수
					e.getDailyMaxMPN())); 
		}
		
		
	} // end main
	
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) throws IOException {
		
			String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%s/", 
				API_KEY, reqType, startIndex, endIndex, date);
			
			return url_address;
		}
	
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class SeoulLP{
	@JsonProperty("SPOP_DAILYSUM_JACHI")
	private JachiGuDailySum jachiGuDailySum;

	public SeoulLP() {}
	
	public JachiGuDailySum getJachiGuDailySum() {return jachiGuDailySum;}
	public void setJachiGuDailySum(JachiGuDailySum jachiGuDailySum) {this.jachiGuDailySum = jachiGuDailySum;}
} // end class


@JsonIgnoreProperties(ignoreUnknown = true)
class JachiGuDailySum{
	
	private List<Row> row;

	public List<Row> getRow() {return row;}
	public void setRow(List<Row> row) {this.row = row;}
}// end class


@JsonIgnoreProperties(ignoreUnknown = true)
class Row{
	@JsonProperty("SIGNGU_CODE_SE")
	private String guID;
	@JsonProperty("TOT_LVPOP_CO")
	private String totalLPN;
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String dailyMaxMPN;
	
	
	public Row() {}
	
	public Row(String guID, String totalLPN, String dailyMaxMPN) {
		super();
		this.guID = guID;
		this.totalLPN = totalLPN;
		this.dailyMaxMPN = dailyMaxMPN;
	}
	
	public String getGuID() {
		return guID;
	}
	public void setGuID(String guID) {
		this.guID = guID;
	}
	public String getTotalLPN() {
		return totalLPN;
	}
	public void setTotalLPN(String totalLPN) {
		this.totalLPN = totalLPN;
	}
	public String getDailyMaxMPN() {
		return dailyMaxMPN;
	}
	public void setDailyMaxMPN(String dailyMaxMPN) {
		this.dailyMaxMPN = dailyMaxMPN;
	}
}// end class




















