package practice.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어  
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {		
		System.out.println("실습: 단어 발생 빈도");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();  
		
		String [] words = C.ALICE30.trim().toLowerCase().split("\\s+");  // 대소문자 구분 안하고 공백으로 찢어놓는 것 까지.   그 다음 특수문자 잘라내는 거 내가 해야 함.  ====> 정규표현식으로 바꾸면 굳이 Tokenizer 안해도 되네...
		
		List<String> list = new ArrayList<String>();
		for(String e : words) {	// words 에서 단어들 꺼내기   
			StringTokenizer word = new StringTokenizer(e, ",.\"\'`_!?;:*-()0"); // 특수문자 제거.
			
				while(word.hasMoreTokens()) {
					list.add(word.nextToken()); // ArrayList 에 담기
				}				
		} // end for
		
		// 두 글자 뽑아내기
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).length() == 1) list.remove(i);
		}
		
		// => 여기서  List<Word> 타입으로 ArrayList 바로 저장...  하고 엔트리로 뽑아내기 
	
		printFreq(list);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
// 메소드	-----------------------------------------------
	static void printFreq(List<String> list) {
	
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();   
		
		for(int i = 0; i < list.size(); i++) { // 발생빈도 구하기
			Integer v = hmap.get(list.get(i));
			
			if(v == null) 
				hmap.put(list.get(i), 1);
			else
				hmap.put(list.get(i), v + 1);
		} // end for
		
		List<WordFreq> freqs = new ArrayList<WordFreq>();  // WordFreq 타입을 가진 List 객체 생성 (WordFreq 클래스는 Comparable 구현됨)
		
		for(Map.Entry<String, Integer> e : hmap.entrySet()) {  // EntrySet 돌려서 key, value 값 뽑아내기  
			freqs.add(new WordFreq(e.getKey(), e.getValue()));  // key, value 값을 매개변수로 받는 WordFreq 인스턴스 생성 -> ArrayList 인 freqs 에 저장(내부적으로 배열에 저장)
		}
		Collections.sort(freqs); // 클래스 WordFreq 에 Comparable() 구현 -> CompareTo 오버라이드(클래스 객체를 매개변수로 받아서 내가 정렬하고 싶은 빈도수(int)를 자기자신과 비교하기 -> 같으면 0 크면 1 작으면 -1 
								// 정렬 완료!	
		for(WordFreq w : freqs) { // ArrayList freqs 에 [ , , ...] 데이터가 배열형태로 담겨있음. 그러므로 배열원소 하나씩 뽑아내려면 -> for문 이용해서 list.get(i) 로 접근한다!
			System.out.println(w);
		}
		
	} // end printFreq()
} // end class




class WordFreq implements  Comparable<WordFreq>{
	
	String word; // 발생단어
	int  	freq; // 빈도수
	
	public WordFreq(String word, int freq) {
		super();
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(WordFreq o) {// 리턴타입이 int 값!! 같으면 0 크면 1 작으면 -1  // 빈도수 내림차순으로
		if(o.freq > this.freq) return 1;
		if(o.freq < this.freq) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
//		return word + " : " + freq + "개";
		return String.format("%-1s : %d", word, freq);
	}

} // end class


// 정규표현식 사용해서 해보기. Pattern 과 matcher ///  익명클래스 응용  // Comparator 에 Map Entry 사용..





