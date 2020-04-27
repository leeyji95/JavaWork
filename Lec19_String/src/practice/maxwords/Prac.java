package practice.maxwords;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Prac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); // 문자열 입력
		
		String maxSentence = null;
		int maxWord = 0;
		
		StringTokenizer sentences = new StringTokenizer(str, ".!?");
		while(sentences.hasMoreTokens()) {
			String sentence = sentences.nextToken().trim();  // 문장 뽑음
			String [] words = sentence.split(" "); // 단어 뽑아서-> 배열에 담음
//			System.out.println(Arrays.toString(words));
//			System.out.println(words.length);
		
			int wordCnt = words.length; // 3, 4, 5
			
			if(wordCnt > maxWord) {
				maxWord = wordCnt;
				maxSentence = sentence;
			}
		}
		
		if(maxWord != 0)	System.out.println(maxWord + "개");
		if(maxSentence != null) System.out.println(maxSentence);
		
		
		
		
		
		sc.close();

	}

}
