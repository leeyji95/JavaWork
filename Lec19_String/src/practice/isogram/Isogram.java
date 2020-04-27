package practice.isogram;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*	Isogram
	 문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	
	 isogram 예) Machine, isogram, Alphabet, quit
 */
public class Isogram {

	// TODO : 필요한 메소드 있으면 추가 작성
	
  
    public static void main(String[] args)  {
    	Scanner sc = new Scanner(System.in);

    	String word;
    	while(true) {
    		word = sc.next();
    		if(word.trim().equalsIgnoreCase("quit")) break;   // 문자열 비교는 equals..!!!!       word == quit  (xxxxxxxxx) 
    		System.out.println(is_isogram2(word));
    	}
    	
    	
    	sc.close();
    } // end main()

    // substring() 과 indexOf(), charAt()사용
    static boolean is_isogram2(String str) {
		str = str.toLowerCase();
		
		for (int i = 0; i < str.length() - 1; i++) {
			if(str.substring(i + 1).indexOf(str.charAt(i)) != -1) return false; // 이 코드의 의미 : str 의 i+1 번째부터 끝까지 중 i번쨰 문자가 있냐? 예를 들어, 
		}
		return true;
	}
     /* 예를 들어 인덱스 1번부터 끝까지 문자열 중에 0번쨰 문자(charAt(0)_문자하나로 리턴)   가 있냐? 발견하면, false, 발견못하면 true.
      * 비교할 문자 제외하고 그거보다 인덱스번호 +1 많은 문자열과 비교문자를 비교하면 된다...
      */
} // end class
 