package aaaaaa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
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

public class prac {

	public static final String API_KEY = "717077554f6c65653231554e5a6672";
	public static final String FILE_PATH = "stationNameOrigin/xml_data.txt";

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작Index: ");
		int startIndex = sc.nextInt();
		System.out.print("끝Index: ");
		int endIndex = sc.nextInt();
		sc.close();
		
		//http://openapi.seoul.go.kr:8088/717077554f6c65653231554e5a6672/xml/StationNmfpcOrgnThemaNm/1/5/
		System.out.println("[XML]");
		System.out.println("------------------------------------------------------------");
		
		String url = buildUrlAddress("xml", startIndex, endIndex);
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
			
		// 읽은 xml 데이터를 리스트에 저장...
		List<String> list = new ArrayList<String>();
		
		for(Element e : elements) {
			
			list.add(e.selectFirst("LINE").text().trim() + "호선");  // 호선 번호
			list.add(e.selectFirst("STATN_NM").text().trim() + "역"); // 역 이름
			list.add("유래: " + e.selectFirst("NMFPC_ORGN").text().trim()); // 역명
			
//			System.out.printf("%s호선 %5s역 \t유래:  %2s\n", line, statnNm, nameOrign);
		} // end for
		
		for(String e : list) {
			System.out.println(e);
		}
		
			
//		PrintWriter out = null;
//		BufferedReader br = null;
//		
//		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH), "euc-kr")));
//		test_write(out, list);  // 파일에 텍스트로 쓰고 저장함
//		
//		System.out.println();
//		br = new BufferedReader(new  InputStreamReader(new FileInputStream(FILE_PATH), "euc-kr"));
//		test_read(br);
//		
//		out.close();
//		br.close();
		
		System.out.println("\n[JSON]");
		System.out.println("------------------------------------------------------------");
		ObjectMapper mapper = new  ObjectMapper();
		URL url1 = new URL(buildUrlAddress("json", startIndex, endIndex));
		StationHistory sh = mapper.readValue(url1, StationHistory.class);
		
		for(StatnRow e : sh.getStationNmfpcOrgnThemaNm().getRow()) {
			
			System.out.println(
					"<" + e.getLine() + " 호선>\n"
					+ e.getStatnNm() + " 역\n"
					+ "[유래: " + e.getOrgn() + "]");
		}
		

		
		
		
		
	} // end main()
	
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex) {
		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/StationNmfpcOrgnThemaNm/%d/%d/",
				API_KEY, reqType, startIndex, endIndex);
		return url_address;
	}
	
	
	public static void test_write(PrintWriter out, List<String> list) {
		
		for(String e : list) {
			out.println(e);
		}
		out.flush();
	}
	
	
	public static void test_read(BufferedReader br) {
		String line;
		StringBuffer sb = new StringBuffer();
		
		try {
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		
	}
} // end class



@JsonIgnoreProperties(ignoreUnknown = true)
class StationHistory{
	public OrgnThemaNm StationNmfpcOrgnThemaNm;

	public OrgnThemaNm getStationNmfpcOrgnThemaNm() {
		return StationNmfpcOrgnThemaNm;
	}

	public void setStationNmfpcOrgnThemaNm(OrgnThemaNm stationNmfpcOrgnThemaNm) {
		StationNmfpcOrgnThemaNm = stationNmfpcOrgnThemaNm;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class OrgnThemaNm{
	@JsonProperty("list_total_count")
	private int total;  // 총 데이터 개수
	private List<StatnRow> row;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<StatnRow> getRow() {
		return row;
	}
	public void setRow(List<StatnRow> row) {
		this.row = row;
	}
	
	
	
}


@JsonIgnoreProperties(ignoreUnknown = true)
class StatnRow{
	@JsonProperty("LINE")
	private String line; // 호선
	@JsonProperty("STATN_NM")
	private String statnNm; // 역 이름
	@JsonProperty("NMFPC_ORGN")
	private String orgn; // 유래
	public StatnRow() {
		super();
	}
	public StatnRow(String line, String statnNm, String orgn) {
		super();
		this.line = line;
		this.statnNm = statnNm;
		this.orgn = orgn;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStatnNm() {
		return statnNm;
	}
	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}
	public String getOrgn() {
		return orgn;
	}
	public void setOrgn(String orgn) {
		this.orgn = orgn;
	}
	
	
}