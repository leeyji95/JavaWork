package com.lec.java.crawl13jacksondatabined;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Jackson 라이브러리
 * 	Java Object를 JSON으로 변환하거나 JSON을 Java Object로 변환하는데 사용할 수 있는 Java 라이브러리입니다.
 * 		Jackson Github - https://github.com/FasterXML/jackson
 * 
 * Jackson 특징
 * 	1.Stream API : 스트림 형식으로 데이터를 분석하고 생성하기 때문에 성능이 좋습니다.
 * 	2.Tree Model : XML의 DOM 처럼 Node 형태로 데이터를 다룰 수 있기 때문에 유연성이 좋습니다.
 * 	3.Data Binding : POJO 기반의 자바 객체들을 JSON으로 변환시킬 수 있습니다.
 * 
 * Maven 설정
 * 	jackson-databind 라이브러리는 jackson-core 및 jackson-annotation 라이브러리의 의존성을 포함하기 때문에 메이븐을 사용하는 경우 jackson-databind 라이브러리만 추가해주시면 됩니다.
 * 
 * MVNrepository :
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
 */


/*
* 자바스크립트에 있는 배열은 자바의 배열 혹은 ArrayList 와 비슷하지.
* 
* JS 의 배열 <-> Java 의 List<>
* JS 의 object <-> Java 의 객체(class)
* 
* 
* 엘리먼트 찾아가는 과정이 귀찮아. XML 이든, JSON 이든
* 
* 자바스크립의 프라퍼티와 밸류쌍,  자바의 클래스와 멤버변수 대응 
* 
*/
/*
 * 클래스 모아놓은 게 라이브러리잖아.
 * 
 * 어떤 라이브러리를 사용하기 위해 다른 라이브러리가  꼭 필요함. 
 * 이를 의존관계 라함 
 * 
 */

public class Crawl13Main {

	public static void main(String[] args) {
		System.out.println("jackson-databind 사용");
		
		//---------
		// 자바에서 JSON 포맷으로 테이터 만들고 싶을 때   자바에다가 클래스 만들고,  데이터 저장해주고 메인에서 작동 
		User user = new User();
		user.setName("제이슨");
		user.setAge(10);
		user.setScore1(new Score(100, 80, 60));
		List<String> list = new ArrayList<String>();
		list.add("JSON 은 Javascript Object Notation 의 약자입니다");
		list.add("JSON 은 데이터 교환 포맷으로 인기 짱입니다");
		list.add("JSON 은 베열이 있습니다(XML보다 장점!)");
		list.add("JSON 은 타입 검증에 대해선 XML보다 약합니다");
		user.setMessage(list);
		
//		javaToJson(user);
		
		
		
		//------------
		jsonToJava();
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// Java 객체를 --> JSON 으로 변환
	public static void javaToJson(User user) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			//Java 객체(user) --> JSON 문서로 변환해준다 (user.json)
			mapper.writeValue(new File("data/user.json"), user); // 여기 파일에다가  User 객체를 Json 파일로 변환해서 
			
			// Java 객체 --> JSON 문자열 변경해보기
			System.out.println(mapper.writeValueAsString(user));
			
			// JSON 문자열 변환시 이쁜 포맷(Pretty Format)
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
			
			
			//이쁜 포맷으로 JSON 파일 저장
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.myuser2.json"), user); // 이 파알애서 읽어들임
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end javaToJson()
	
	
	
	
	
	public static void jsonToJava() {  // 거꾸로, JSON 을 Java 객체로 변환해보자
		ObjectMapper mapper = new ObjectMapper();
		
		//Json 파일 --> Java 객체로 변환해볼게
		try {
			User user1 = mapper.readValue(new File("data/user.json"), User.class); // user 라는 class 자체로 변환해라.   그리고 애ㅡㄴ ㄴuser 타입으로 리턴한다. 
			System.out.println(user1);  // User 클래스에서 toString() 오버라이딩 해줌
			
			URL url = new URL("http://openapi.seoul.go.kr:8088/717077554f6c65653231554e5a6672/json/CardSubwayStatsNew/1/5/20181001"); 
			
			// Card~   클래스 가진 걸로 만들어줌.   1대1 대응 되는 클래스 만듦. 
			Subway subway = mapper.readValue(url, Subway.class); // url 로부터 읽어들여서 subway  담겨
			System.out.println(subway.CardSubwayStatsNew.list_total_count);
			
			
			// 다른것도 가져와야지 왜 그것만 가져와  익셉션 com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
			// 다른거 무시하는 어노테이션 만들어라 @JsonIgnoreProperties(ignoreUnknown = true)
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

} // end class


@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{
	public CardSubwayStats CardSubwayStatsNew;  //CardSubwayStatsNew 는 list_total_count 를 가지고 있으므로  애ㅒ 타입으로 만들어준다

	public CardSubwayStats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(CardSubwayStats cardSubwayStatsNew) {
		this.CardSubwayStatsNew = cardSubwayStatsNew;
	}
	
}



@JsonIgnoreProperties(ignoreUnknown = true)
class CardSubwayStats{ // 오브젝트 안에 오브젝트니까 클래스 만드는 거지. 
	int list_total_count;

	// getter & setter
	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
	
	
	// 데이터 교환 편리
	// XML 포맷에서 자바로, 자바에서 XML 로
	// 교환 라이브러리가 많음
	// Retrofit
	// volley
}









































