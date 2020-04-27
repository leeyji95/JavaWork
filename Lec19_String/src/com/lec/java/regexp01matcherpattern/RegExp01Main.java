package com.lec.java.regexp01matcherpattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 웹, 앱개발은 이 정규표현식을 꼭 알아야함.
* 주민번호의 경우, 번호 패턴
 숫자 6 - 숫자 7
 쿠폰 번호의 경우 
 잘못된 패턴 들어오면 오류내야 한다.  패턴분석ㅇ하는 코드가 매우 복잡하므로, 이를 편리하게 하는 방법이 정규표현식이다.
 패턴을 정의해서 그게 맞냐 안맞냐 -> 그게 패턴 매칭.
 대표적으로 주민번호, URl, email 형식, 등등등 
이런것들을 걸러내줘야힘.   자바는  java.util.regex 에서 관련 클래스들 제공
 * 		Pattern, Matcher ..---->  이러한 클래스 사용....
  
*/

/* 정규표현식 regular expression
 * 
 * 문자열 검색, 치환  등의 동작에 있어서
 * 단순한 '문자열 비교' 를 하는 것이 아니라 
 * 특정 '패턴'과 비교하고자 할때 이를 단 몇줄의 코드로 구현 가능!
 * 주어진 문자열에서 패턴을 찾아내는 것을 '패턴 매칭(pattern matching)' 이라 함
 * 
 * 사용자가 입력한 문자열 패턴 유효성 체크 등에 많이 사용
 * 		ex) 주민등록번호, URL, email, 비밀번호, 
 * 			날짜포맷(yyyy-mm-dd) 
 * 			전화번호(010-xxxx-xxxx) ... 
 * 
 * 자바는 java.util.regex 에서 관련 클래스들 제공
 * 		Pattern, Matcher ..---->  이러한 클래스 사용....
 * 
 * 일반적인 작성단계
 * 	 1) 주어진 정규표현식을 구현하는 Pattern 객체 생성
 *   2) 패턴 매칭 수행객체 Matcher 생성
 *   3) Matcher 객체로부터 패턴매칭을 수행하여  검색, 치환등의 동작
 * 
 * 장점: 코딩량 저감, 거의 대부분의 언어에서 공용으로 사용.
 * 단점: 처음에 배우기 어렵고, 코드 가독성 떨어뜨림.
 * 
 * 정규표현식을  사용하는 String 메소드들:
 * 	matches(), split(), replaceAll(), replaceFirst()
 * 
 * 정규표현식 연습 사이트 추천
 * : https://regexr.com/    (정규식 , 문자열 매칭 연습)
 * : https://regexone.com/  ( step by step 으로 연습 하기 좋음)
 * : https://regexper.com/  (특징: 시각화, 정규식을 이미지로 다운가능)
 * : https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html  (오라클 공식)
 * ─────────────────────────────────────────────────────────────
 * 	정규표현식		설명
 * 	^			문자열 시작
 * 	$			문자열 종료
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다. ( 있거나 없거나)
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다.
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 문자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * (?i)			대소문자를 구분하지 않습니다.
 */
public class RegExp01Main {
	public static void main(String[] args) {
		System.out.println("정규표현식 regular expression");
		// 패턴을 어떻게 정의할 것인가. 그게 정규표현식의 핵심
		
		String input;
		String regex; // 정규표현식도 문자열 타입임.
		Pattern pat;
		Matcher matcher;
		
		System.out.println();
		System.out.println("■ 정규표현식 객체, 메소드 연습");
		System.out.println("패턴] .  ← 임의의 문자 하나");
		// 정규표현식은 임의의 문자입니다.
		
		
		
		// 1).주어진 정규표현식을 구현하는 Pattern 객체 생성  
		// Pattern.compile(정규표현식 문자열) 사용  

		regex = "My....";  // My 로 시작하고 뒤에 임의의 문자 4개가 따라오는 패턴이다.
		pat = Pattern.compile(regex);  // Pattern 객체 생성한 것. 
		
		 input = "-My1234-";  // 위에서 정의한 regex 의 패턴이 있음.
		
		// 2) 패턴 매칭 수행객체 Matcher 생성
		// Pattern 의 matcher() 사용
		// Pattern을 사용해서 주어진 문자열에서 패턴 매칭할 객체 생성 --> Matcher객체 리턴
		// (아직 패턴 매칭을 진행하진 않았다)
		
		matcher = pat.matcher(input); // 위에서 만든 패턴이 인풋에 있는가 물어봄..   패턴 매칭의 결과, 이거는 Matcher 객체를 생성해서 리턴한다. 
		
		// 3) Matcher 객체로부터 패턴매칭을 수행하여  검색, 치환등의 동작    // 무엇이 매칭되고, 어디서부터 어디까지 매칭되는지.
		//  find() '다음' 패턴매칭 검색 , 패턴매칭 발견하면 true 아니면 false 리턴
		//  group() 바로 직전에 패턴매칭된 문자열 String 리턴
		//  reset() 다시 처음부터 패턴매칭하도록 reset 함.
		//  replaceFirst() : 첫번째 매칭을 치환
		//  replaceAll() : 모든 매칭을 치환
		//  matches() : 패턴매칭이 '문자열 전체영역' 이 패턴매칭 되는지 여부
		//  start() : 최근 매칭의 시작 index,   
		//  end() : 최근 매칭의 끝 index (마지막 매칭된 문자 '다음' 인덱스값)
		if(matcher.find()) {
			System.out.println("find() 성공");
			System.out.println(matcher.group() + "{" + matcher.start() + " ~ " + matcher.end() + "}");   //  바로 직전에 매칭된 그룹.  매칭된애가 My1234 입니다  // end()는 맨 마지막 매칭된 문자의 바로 직전 문자까지.
		} else {
			System.out.println("find() 실패");
		}
		
		// 위의 코드를 다시 실행하면? 
		// 매칭은 순서대로 진랭하므로,  -My1234/- : / 까지 매칭 진행되었으므로ㅗ, - 여기서부터 매칭하려고 할 것. 그러므로 두번째 매칭실행은 실패로 결과 나옴.
 		if(matcher.find()) {
			System.out.println("find() 성공");
			System.out.println(matcher.group() + "{" + matcher.start() + " ~ " + matcher.end() + "}");   
		} else {
			System.out.println("find() 실패");
		}
		
 		
		
 		// 다시 처음부터 매칭하고 싶으면 ,,,  reset 사용
		// reset() 다시 처음부터 패턴매칭하도록 reset 함.
		matcher = matcher.reset();   // 덮어쓰기 해야함. reset 의 결과를 다시 matcher 에 담음.(덮어쓰기)
		
		// 다시 시도하면 매칭된다. 
		if(matcher.find()) {
			System.out.println("find() 성공");
			System.out.println(matcher.group() + "{" + matcher.start() + " ~ " + matcher.end() + "}");   
		} else {
			System.out.println("find() 실패");
		}
		
		
		
		// 정규표현식은 대표적인 검색기능에 사용된다. 
		
		// replaceFirst() : 첫번째 매칭 패턴을 치환하여 결과 리턴
		matcher.replaceFirst("XXXX");  // 첫번째 매칭 문자를 발견해서, 그것을 XXXX로 바꾸라는 말. 
		// 출력 -XXXX-  -My1234- 중에서 My1234(첫번째 발견한 문자)를 찾아서 주어진 문자열로 바꿈. 
		
		
		// matches()
		// 패턴매칭이 '문자열 전체영역' 이 패턴매칭 되는지 여부
		// 아까는 부부만 매칭되었다면, 이번에는 전체가 매칭되도록.
		System.out.println();
		System.out.println("matches()");
		matcher = pat.matcher("-My1234-");
		if(matcher.matches()) {  // matcher 는 t/F 리턴
			System.out.println("matches() 매칭 OK");
		} else {
			System.out.println("matches() 매칭 FAIL");
		}
		
		matcher = pat.matcher("My1234");
		if(matcher.matches()) {  // matcher 는 t/F 리턴
			System.out.println("matches() 매칭 OK");
		} else {
			System.out.println("matches() 매칭 FAIL");
		}
		
		// 위 코드를 아래와 같이 한번에 만들 수 있다. 
		if(Pattern.compile("My....").matcher("My1234").matches()) {  // matcher 는 t/F 리턴
			System.out.println("matches() 매칭 OK");
		} else {
			System.out.println("matches() 매칭 FAIL");
		}
		
		
		System.out.println();
		System.out.println("Pattern.matches(regex, input) 사용");
		// 단순히 '문자열 전체영역' 이 패턴에 맞는지 여부 만 확인하려면 간단하게 Pattern.matches() 사용하자.
		// Pattern.matches()는 내부적으로 정확히 아래와 같이 동작하게 된다.
		//     Pattern.compile(regex).matcher(input).matches()
		if(Pattern.matches("My....", "Myabcd")) {               // 정규표현식은 대소문자를 가림!!!!,  그리고 개수만큼 매칭되어야 함. 
			System.out.println("Pattern,matches() 매칭 OK");
		} else {
			System.out.println("Pattern.matches() 매칭 FAIL");
		}
		

		System.out.println();
		System.out.println("■ 여러개 패턴 검색");
		
		// 과연 "My...." 으로 몇개가 매칭되나?  : 예측해보자
		// 기본적으로 대소문자를 구분하여 매칭한다
		input = "-My98KK-myABCD--My1234567--MyZZ---My789"; // My98KK , My1234, MyZZ--  이 패턴매칭되고 있음... 오... 하이푼도... 신기하네..
		matcher = pat.matcher(input);
		 
		// 여러개가 나올 수 있으므로 while 문 돌려봐자
		while(matcher.find()) {               // 매칭 찾아내보자
			System.out.println(matcher.group() + "{" + matcher.start() + "~" + matcher.end() + "}");  // 찾아낸거 하나씩 뽑아보자(matcher.group()),
		} // end while
		
		
		/*
		My98KK{1~7}  1번부터 7번전인 6번까지의 인덱스    --> 이런식으로 어느부분까지 매칭되는지 알아낼 수 있다. 
		My1234{16~22}
		MyZZ--{27~33}
		 */
		
		System.out.println();
		
		System.out.println(matcher.replaceFirst("***"));	  // 처음에 발견한 것만 별 3개로 바꿈.	
		System.out.println(matcher.replaceAll("***"));     	// 매칭된 모든 것이 별 3개로 바뀜.
		
		System.out.println();
		System.out.println("find(fromIndex)");  // fronIndex부터 검색

		matcher = pat.matcher(input);  // matcher 객체 생성
		int fromIndex = 16;
		while(matcher.find(fromIndex)) {    // 16번째 부터 찾아보쟈.    ---> 근데..? 이거 무한루프 돔. 계속 16번째 찾음
			System.out.println(matcher.group() + "{" + matcher.start() + "~" + matcher.end() + "}");  // 찾아낸거 하나씩 뽑아보자(matcher.group()),
			fromIndex = matcher.end();
			
		} // end while
		
		
		// 자바에서 제공하는 정규표현식은  pattern 과 matcher 객체가 있다는 것을 배움. 
		// 정규표현식 구현하기 위해 Pattern 객체 생성 Patter pat = Pattern.compile(regex)
		// Pattern 의 matcher() 사용해서 Matcher 객체 생성 -> 패턴 매칭을 수행할 객체임.
		// -> Pattern.matcher() (<-이거의 의미 : pattern 객체 사용해서 주어진 문자열(input) 중 패턴 매칭할 문자열 찾겠다.)
		// 위에를 Matcher matcher = Pattern.matcher(input)
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















