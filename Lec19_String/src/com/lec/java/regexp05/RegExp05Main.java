package com.lec.java.regexp05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────           // URL , email ~~  구글링  해보기.  관련 사이트 많음. 테스트 문자열 넣어서 실행해보기 
		title = "URL";
		regex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";
		arrInput = new String[] {
			"https://docs.google.com/",
			"https://regexr.com/",
			"http://dict.naver.com/"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "email";
		regex = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$";
		arrInput = new String[] {
				"leeyji95@naver.com",
				"leeyji95@gmail.com",
				"236_hu@lknse.net"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "[0-9]{2}(0[1-9]|1[012])(0[1-9]|1[0-9]|2[0-9]|3[01])-?[012349][0-9]{6}";
		arrInput = new String[] {
			"123456-7894567",
			"950127-2005842",
			"were12-4567812"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$"; // TODO
		arrInput = new String[] {
			"1999-12-24",
			"0000-00-00",
			"1995-01-27",
			"ssss-56-12",
			"2020-03-24"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[1-9][0-9]*$"; // TODO
		arrInput = new String[] {
			"23",
			"056",
			"-56",
			"-2.5",
			"89.2356",
			"456789"
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "^[-]?[0-9]+$"; // TODO
		arrInput = new String[] {
			"0.2",
			"123",
			"-42",
			"-0.2323",
			"894620"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		
		//─────────────────────────────────────────
		title = "소수";
		regex = "^[0-9]+\\.[0-9]+$"; // TODO
		arrInput = new String[] {
				"0.2",
				"23.5666",
				"123",
				"-42"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "^[0-9]+\\.[0-9]{2}$"; // TODO
		arrInput = new String[] {
			"23.23",
			"56.8",
			"75.5628888",
			"12.0",
			"45.23"
			
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "통화표시 (￦)"; // 세자리 단위로 콤마 표시하는 거...
		regex = "^([1-9][0-9]{0,2}(,[0-9]{3}))$"; // TODO
		arrInput = new String[] {
			"1,333",
			"11,444",
			"112,234",
			"1,1111,112",
			"1,111,111"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
