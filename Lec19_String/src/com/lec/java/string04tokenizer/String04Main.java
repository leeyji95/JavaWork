package com.lec.java.string04tokenizer;

import java.util.StringTokenizer;

/* StringTokenizer 클래스

	token ? : '규칙'에 의해 구분된 더 이상 나눌수 없는 문자요소(문자열)
				(문법적으로 더 이상 나눌 수 없는 기본적인 언어요소)
*/

public class String04Main {

	public static void main(String[] args) {
		System.out.println("StringTokenizer 클래스");
		
		// token <- '규칙'에 의해 구분된 문자덩어리(문자열)?
		String str1 = "13:46:12";
		
		StringTokenizer tokenizer = new StringTokenizer(str1, ":");  // 쪼갤 대상, 뭘 기준으로 쪼갤건지 작성
		System.out.println("토큰 개수 : " + tokenizer.countTokens());
		
		while(tokenizer.hasMoreTokens()) { // hasMoreTokens() 아직도 뽑아낼 토큰이 남아있는가? 
			System.out.println(tokenizer.nextToken());  // 줄 세워놓고 하나하나 뽑아냄.   다 뽑아내면 false 나와서 종료
		}
		
		
		//tokenizer.nextToken();  
		// ----> 다 뽑아 놓고 또 뽑아내려고 하면    NoSuchElementException   익셉션 발생
		
		
		
		
		System.out.println();
		String str2 = "abc:def:ghi:jkl:mno";   // : 로 토큰분리

		StringTokenizer tokenizer1 = new StringTokenizer(str2, ":");
		while(tokenizer1.hasMoreElements()) {
			System.out.println(tokenizer1.nextToken());
		}
		
		
		System.out.println();
		String str3 = "2015/04/08";     // / 로 토큰분리

		StringTokenizer toknizer2 = new StringTokenizer(str3, "/");
		while(toknizer2.hasMoreTokens()) {
			System.out.println(toknizer2.nextToken());
		}
		
		
		System.out.println();
		String str4 = "2015년-4월-8일";   // - 으로 토큰분리

		StringTokenizer tokenizer3 = new StringTokenizer(str4, "-");
		while(tokenizer3.hasMoreTokens()) {
			System.out.println(tokenizer3.nextToken());
		}
		
		
		
		
//	String date = str5.split("\\s+")[0];
//	String time = str5.split("\\s+")[1];
//	
//	StringTokenizer a = new StringTokenizer(date, "-");
//	StringTokenizer b = new StringTokenizer(time, ":");
//	while(a.hasMoreElements()) {
//		System.out.println(a.nextToken());
//	}
//	// ....
	//  split 처럼 안해도 된다. !	
		System.out.println();
		String str5 = "2015-04-08 14:10:55";
		
		StringTokenizer tokenizer5 = new StringTokenizer(str5, ":- "); // 토크나이저는  딜리미터 다 적어줘도 된다. 
		while(tokenizer5.hasMoreElements()) {
			System.out.println(tokenizer5.nextToken());
		} 
		
		
		
		
		
		
		System.out.println();
		// StringTokenizer 생성자의 세번째 매개변수를 true 로 주면
		// delimiter 도 token 으로 추출된다
		String str6 = "num += 1";
		StringTokenizer token6 = new StringTokenizer(str6, "+=", true);  // true 로 매개변수 주냐 안주냐..  
		while(token6.hasMoreTokens()) {                        			// 딜리미터(구분자)도  출력된다. 
			System.out.println(token6.nextToken());
		}
		
		
		// 실습]
		// 다음과 같은 수식이 있을때  토큰들을 분리해네세요
		// 연산자 + - / *   괄호 ( )
		// 10  +  (name * 2) / num8- (+3)
		// 힌트]
		// 일단 공백으로 분리 split()
		// 그리고 나서 각각을 StringTokenizer 함
		
		System.out.println();
		System.out.println("수식 분석기");
		String expr = "10  +  (name * 2) / num8- (+3)";
		
		String[] strings = expr.split("\\s+"); // 1. split 으로 일단 공백 분리 -> 그걸 배열에 담아! 왜? String [] 로 리턴하니까.
		for(String x : strings) {           	// 2. for 문으로 덩어리를 뽑아내.
			StringTokenizer token9 = new StringTokenizer(x, "+(*)/-(+)", true); // 3. 그걸 StringTokenizer 로 쪼개.
			while(token9.hasMoreTokens()) {   											
				System.out.print(token9.nextToken() + ", ");
			}
		}
	// 공백 분리한 걸 배열에 담아낼 수 있는가,
	// 그걸 for문 으로 뽑아서, 
	// for 문 안에서 토큰 뽑아낼 수 있는가....!
		System.out.println();
		
		// 쌤이 하신것.
		for(String s: expr.split("\\s+")) {
			StringTokenizer exprTokenizer = new StringTokenizer(s, "+=*()", true);
			while(exprTokenizer.hasMoreTokens()) {
				System.out.print(exprTokenizer.nextToken() + ", ");
			}
		}
		
		
		
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











