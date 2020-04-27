package com.lec.java.regexp03kinds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식 에 사용하는 각종 표현식들
 * 	정규표현식		설명   패턴을 정의하는것이라고 했음
 * 	^			문자열 시작  ^이거 다음,문자열로 시작해라.
 * 	$			문자열 종료   이 문자열로 종료되어야 한다. 
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다. (그룹)
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 숫자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * (?i)			대소문자를 구분하지 않습니다.
 * 
 * 
 * 자바 정규표현식에 사용되는 esc8aped character 들
 *    \.[]{}()<>*+-=!?^$|
 */
public class RegExp03Main {

	public static void main(String[] args) {
		System.out.println("정규표현식\n");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "^ : 바로 문자뒤의 문자열로 시작됨";
		regex = "^The"; // The 로 시작하는 문자열 패턴을 말함
		arrInput = new String[] {
				"The Things",
				"On The Things",  // X 매칭없음
				" The The The",   // 앞에 공백 안됨. 얄짤 없음
				"The The the The" //  하나만 매칭!이다.  세개도 낚이면 안된다.    매치1: 0~3(0부터 2번째 까지) 매칭.
		};
		//─────────────────────────────────────────
		title = "$ : 문자열의 마지막이 이 문자열로 마무리 됨";   
		regex = "Man"; // Man 으로 끝나는 문자열 패턴을 말함
		arrInput = new String[] {
				"SuperMan",
				"AquaMan",
				"WonderWoMan",
				"PostMan ",   // 마지막에 공백 처리 안됨. 
				"Man Man Man"
		};
			
		//─────────────────────────────────────────
		title = "^표현식$ : 정확하게 전체패턴매칭되는 문자열";
		regex = "^Su...Man$"; // TODO
		arrInput = new String[] {
				"SuperMan",
				"SugarMan",
				"Super Man",
				"Supe Man",
				" SuperMan",
				"SuperMan "
		};
		
		//─────────────────────────────────────────
		title = " . : 어떤 문자든지 임의의 '한문자'를 말한다.꼭 하나의 문자와 매칭";
		regex = "x.y"; // TODO  // x 와 y 사이에 문자가 있는경우.( 이 사이에 임의의 한문자만! 있는 경우)
		arrInput = new String[] {
				"xyz", // 2
				"xxzdfdk", 
				"aa10x9zbxbz",
				"xz",
				"90x zxx_zdf",  // 공백도 하나의 문자다! 매칭된다
				"xbz",				
				"xyyz xy xyxyxyxyxxxxxxyxyxxyxyy"
		};
		
		//─────────────────────────────────────────
		title = " * : 바로 앞의 문자가 없거나 한개 이상의 경우를 매칭";   // 이거 조금 어렵
		regex = "ab*"; // TODO
		arrInput = new String[] {
				"a",
				"abc",
				"ab",
				"abbbaaaabababbab", // 8개 abbb a a a ab ab abb ab
				"bbba", // 1개 a
				"cdef"
		};
		
		//─────────────────────────────────────────
		title = " + : 바로 앞의 문자를 나타내면 꼭 한개 혹은 그 이상을 매칭";
		regex = "ab+"; // TODO  // a로 시작하고 , b는 한개이상 뒤따라 와야 함.
		arrInput = new String[] {
				"a",  // 매칭 안됨
				"abc", // 매칭 하나
				"ab", // 매칭 1
				"abbbaaaabababbab", //  abbb ab ab abb ab  a로 시작하고 b가 뒤따라나오는 구조.
				"bbba", // 없음
				"cdef" // 없음
		};
		
		//─────────────────────────────────────────
		title = " ? : 바로 앞의 문자가 한개 있거나 없는것을 매칭";     // 여러개아니고, 있거나 없는 경우
		regex = "ab?"; // TODO  // a 로시작하되, b는 있거나 없거나, 있으면 1개있어야.
		arrInput = new String[] {
				"a", //1
				"abc", //1
				"kkabcc", //1 ab
				"abbbaaaabababbab", // ab a a a ab ab ab ab  8 개
				"bbba" // a  1개
		};

		//─────────────────────────────────────────
		title = " [] : 안에 존재하는 문자들중 한 문자만을 매칭"; // 하나만 매칭되어야함
		regex = "[abc]"; // a 또는 b 또는 c  중의 한 문자에 매칭
		arrInput = new String[] {
				"able",  // 2개 a b   // ab
				"bible", //  b b   // b b 
				"cable", // c a b    // cab
				"xenosys",	 // 없음 
		};
		regex = "[abc]+";   // + 한개 이상..    
		// ab    b b    cab     // d
		regex = "[a-z]+"; // a부터 z 까지 한개 이상 있는 문자 매칭 -> 전체 매칭될 것.   ?// 소문자로만 구성된 단어 받을 때 사용
		arrInput = new String[] {
				"abc100",
				"abcDefGHIUJ-KLM123opQrstuz"
			};
		regex = "[a-zA-Z]+"; // 소문자 중에 하나, 대문자 중에 하나 있는 문자 매칭. // 소문자와 대문자로 구성되어 있는 것
		regex = "[a-zA-Z0-9]+";  // 소문자 대문자 숫자로 구성된 문자 매칭
		regex = "[a-zA-Z0-9-]+"; // 뒤에 하이푼까지 포함하는 문자 매칭.
		
		arrInput = new String[] {
				"23",
				"0",
				"-10",
				"012"
		};  // 자연수의 패턴 .. 어떻게?  첫번째 자리는 1-9 까지, 두번째 자리는 0-9까지 있거나 없거나.
		regex = "^[1-9][0-9]*$"; // 자연수에 대한 정규표현식
		
		//─────────────────────────────────────────
		title = " {} : 앞에 있는 문자나 문자열의 등장개수를 정함";
		regex = "ab{2}"; // TODO // b 가 2개 매칭  그러니까 'abb' 를 찾으면 됨.
		arrInput = new String[] {
				"abb",
				"abbb",
				"abbbabbbbbbbbabaabab", 
		};
		regex = "ab{2,}"; // b 의 개수가 2개 이상	
		regex = "ab{3,5}"; // b 의 개수가 반드시 3개부터 최대 5개까지 매칭이되     // 에러시  PatternSyntaxException 투덜투덜
		
		//─────────────────────────────────────────
		title = " () : ()안에 있는 글자들을 그룹화 ";
		regex = "a(bc)*"; // * 은 (bc) 가 없거나 하나이상 있는 경우.  
		arrInput = new String[] {
				"abc", // 1  abc
				"abcbcbbc", //  abcbc 까지.   
				"abcbcbbca", //     이땐 마지막 a 뒤에 그룹이 없으므로  group(1): null {-1~-1}  null 값 나옴.
				"abcabcabc", // abc abc abc
		};
		
		//─────────────────────────────────────────
		title = " | : OR 연산자  역할";
		regex = "a|b"; // a 또는  b 둘 중 하나   
		arrInput = new String[] {
				"a",//1
				"b", //1
				"abb", // 3
				"xyz",// X
				"abccbbcccbbcaaaacbbbcbcbabaacbcbabbcccc"
		};
		regex = "(a|b)+";  // a b  둘 중 하나가 한개이상일떄
		
		//─────────────────────────────────────────
		title = "(?i)  : 대소문자 구분안하고 매칭 ";  // 타 언어 정규표현식과 다름
		regex = "(?i)abc"; // 대소문자 구분안하고 매칭하겠다.  ! 느낌표가 아니라  소문자  'i'...
		arrInput = new String[] {
				"abc",
				"Abc",
				"ABC"
		};
		
		//─────────────────────────────────────────
		title = "\\s : 공백,  \\S : 공백아닌 문자";
		regex = "\\s+"; // 공백 한개이상 . 여깃ㅅ 말하는 공백은 (스페이스바, 줄바꿈, 탭) 한개이상
		arrInput = new String[] {
				"Hello My World", // 공백 두개 발견
				"He \tllo My World", // 탭 공백
				"\n\t Hello My World\n\n", // 
		};
		regex = "\\S+";  // 공백이 아닌 것이 매칭ㅡ 
		
		//─────────────────────────────────────────
		title = "\\w : 알파벳이나 숫자, \\W 알파벳이나 숫자를 제외한 문자";
		regex = "\\w+"; //  
		arrInput = new String[] {
				"This is 2020-03-23 !!"  // 숫자와 알파벳만 출력
		};
		regex = "\\W+";  // 알파벳과 숫자가  '아닌것!' 출력

		//─────────────────────────────────────────
		title = "\\d : [0-9] 숫자, \\D 숫자를 제외한 모든 문자";
		regex = "\\d+"; 
		arrInput = new String[] {
				"This is 2020-03-23 !!"   // 숫자만
		};
		regex = "\\D+";  // This is 가 한 덩어리로.
		
		//─────────────────────────────────────────
		title = "escaped character 매칭 시키기";  // 정말 내가 쩜 자체 그 자체를 매칭시키고 싶을 떄.
		regex = "[.]+";  // . 쩜 자체를 매칭하고 싶을 떄
		arrInput = new String[] { 
				"My name is ..."  // 이거 하나 매칭.(".+" 일떈)   
		};
		
		/*		
		
		// 나중에 자바스크립트에서도  똑같이 정규표현식 쓰이므로, 종종 익혀두삼
		
		
*/		
		
		
		//*****************************************
		// 패턴매칭 수행
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");
	} // end main()
	
	// 도우미 함수
	public static void regExpTest(String regex, String [] arrInput) {  // 두번째 매개변수는 문자열 배열 -> 여러개의 문자열 데이터로 호출해볼것
		for(String input : arrInput) regExpTest(regex, input);
	}
	
	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);
		
		Matcher matcher = Pattern.compile(regex).matcher(input);
		int groupCount = matcher.groupCount();  // 그룹 개수
		
		int matchCount = 0;		
		while(matcher.find()) {
			matchCount++;
			System.out.println("    매치" + matchCount + ": " + matcher.group() + " {" + matcher.start() + "~" + matcher.end() + "}");
			
			// 그룹이 있으면 group별 출력
			if(groupCount > 0) {
				for(int i = 0; i <= groupCount; i++) {	 // i 범위 주목!	
					System.out.printf("\t group(%d): %s {%d~%d}\n",
							i, matcher.group(i), matcher.start(i), matcher.end(i));
				}
			}
			
		} // end while
		if(matchCount == 0) System.out.println("   Ⅹ매치 없슴Ⅹ");
		System.out.println();
	} // end regExpTest()

} // end class
