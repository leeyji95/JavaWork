package practice.maxwords;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
/* MaxWord
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	hint : StringTokenizer,   split()  사용하면 간편할수도..

	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	
	// TODO : 필요한 메소드 있으면 추가 작성

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String strLine = sc.nextLine();  // 문자열 입력
		

		String maxSentence = null;
		int maxWords = 0 ; // 최대 개수를 일단 0 으로 초기화
		
		StringTokenizer sentences = new StringTokenizer(strLine, ".?!"); // 문장 구분
		while(sentences.hasMoreTokens()) {
			String sentence = sentences.nextToken().trim();
//			System.out.println(sentence);
			String [] words = sentence.split("\\s+");
//			System.out.println(Arrays.toString(words));
			System.out.println(words.length);
			
			int len = words.length;  
			if(len > maxWords) { // 단어 개수 비교
				maxWords = len; // 최대 단어 개수 뽑아내기
				maxSentence = sentence;
			}
		}
		System.out.println(maxWords + "개");
		System.out.println(maxSentence);
		
		
		
		
		
		
//		String [] words = strLine.trim().split("\\s+"); // 먼저 공백으로 모두 분리.
//		System.out.println(Arrays.toString(words));
//		
//		for (int i = 0; i < words.length; i++) {
//			StringTokenizer token = new StringTokenizer(words[i], ".?!");
//			while(token.hasMoreTokens()) {
//				System.out.println(token.nextToken());
//			}
//		}
		
		
		
		
		sc.close();
//		System.out.println(Arrays.toString(words));
//		System.out.println("words 의 길이 : " + words.length);
		
		
		
	} // end main
} // end class
