package com.lec.java.regexp02group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 그룹(group) 
 * 정규표현식에 () 을 사용하여  패턴 내에서 '그룹'을 지정 하면
 * () 의 개수만큼 그룹이 만들어진다.
 * 
 * 
 */
public class RegExp02Main {

	public static void main(String[] args) {
		System.out.println("정규표현식 : group");
		
		String input;
		String regex;
		Pattern pat;
		Matcher matcher;
		
		System.out.println();
		regex = "(My)(....)";  // 정규표현식에 () 사용
		pat = Pattern.compile(regex);  // 패턴은 한번 만들어놓고 쭉 사용.
		
		input = "-My98KK-myABCD--My1234567--MyZZ---My789";
		
		matcher = pat.matcher(input);  // matcher 객체 생성
		
		// 그룹 카운트.. -> 그룹이 몇개 있는가 
		System.out.println("groupCount(): " + matcher.groupCount()); // (My)(....)   그룹 2개 출력
		
		System.out.println("입력문자열: " + input);
		
		while(matcher.find()) {             
			System.out.println(matcher.group() + "{" + matcher.start() + "~" + matcher.end() + "}");  // regex 에 () 괄호 있어도 동일하게 출력된다는 사실 알 수 있고, 이제 그룹끼리 출력해보자.
			
			// 그룹들 출력해보기
			// group(int group), start(int group), end(int group)
			System.out.println("\t group(0): " + matcher.group(0) + "{" + matcher.start(0) + "~" + matcher.end(0) + "}");
			System.out.println("\t group(1): " + matcher.group(1) + "{" + matcher.start(1) + "~" + matcher.end(1) + "}");
			System.out.println("\t group(2): " + matcher.group(2) + "{" + matcher.start(2) + "~" + matcher.end(2) + "}");
			
			// 0번은 전체, 첫번째그룹은 1번부터 시작,  2번은 두번째 그룹. 
			
		} // end while
		
		
		// 도우미 함수를 사용해보자
		System.out.println();
		regExpTest("My....", "-My1234-");
		regExpTest("(My)(....)", "-My1234-");
		regExpTest("My....", input);
		regExpTest("(My)(....)", input);
		regExpTest("ABC...DEF", input);
		
		
		System.out.println("프로그램 종료");
	} // end main
	
	// 도우미 함수
	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-------------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열 : " + input);
		
		Matcher matcher = Pattern.compile(regex).matcher(input);
		
		// 그룹개수구하기
		int groupCount = matcher.groupCount(); // 그룹개수
			
		int matchCount = 0; // 매칭된 패턴의 개수
		while(matcher.find()) {
			matchCount++; // 발견했으면 1증가 
			System.out.println("      매치" + matchCount + ": " + matcher.group() + "{" + matcher.start() + "~" + matcher.end() + "}");  
			
			// 그룹이 있었다면 group 별 출력
			if(groupCount > 0) { // 0 보다 크다면 그룹이 있다는 것.
				for(int i = 0; i <= groupCount; i++) { // 주목할 포인트는 같거나 같다. 그룹이 1부터 시작했기 때문에!!  0번째는 전체를 나타내는 거니까.
					System.out.printf("\t group(%d):  %s {%d~%d}\n",
							i, matcher.group(i), matcher.start(i), matcher.end(i));
					
				} // end for
			} // end if
			
			
		} // end while
		
		if(matchCount == 0) System.out.println("   X매칭 없음X");
		
		System.out.println();
		
		
		
	}
	
} // end class

























