package com.lec.java.input02bufferconsume;

import java.util.Scanner;
// Ctrl + Shift + O : 자동 import

// 문자열(String) 입력
// char 입력
public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");
		
		Scanner sc= new Scanner(System.in);
/*		
		// String 입력
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();  // 엔터를 입력할 때까지의 모~든 문자들을 문자열로 리턴
		
		System.out.print("별명을 입력하세요: ");
		String nick = sc.nextLine();
		
		//System.out.print("이름은: " + name + "\n별명은: " + nick);
		
		// char 입력
		// .nextChar()? 라는 명령 없다!
		System.out.println("성별을 입력하세요 M/F: ");
		char gender = sc.nextLine().charAt(0);
		System.out.println("이름은: " + name + "\n별명은: " + nick + "\n성별은: " + gender);
		
		
		System.out.println();
*/
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		
		System.out.println("주소도 입력하세요: ");
		
		// 숫자 입력 받은  뒤에 문자열 입력시에는 반드시 '\n' 을 consume(버퍼에서 제거) 해야 한다. 
		sc.nextLine(); // 인위적으로 줄바꿈 없애기 위해 한 번 작성해줌.
		
		String addr = sc.nextLine();
		
		
		System.out.println("나이: " + age + "\n주소: " + addr);
		
		
		/*
		 * 키보드로부터 데이터를 받아놓는 버퍼. 이 안에 타이핑한 것들이 차곡 쌓임. 
		 * nextint 수행 -> 내가 88 입력했어. 우리 눈엔 2글자 입력...?한것처럼 보이나  -> 사실은 타이핑 정확히 3글자 한거다.  '8' '8' '엔터' 까지 이렇게 3개가 들어온 것     
		 * 엔터 입력하는 순간 nextint 수행.하는 순간
		 * 버퍼에서 꺼내감
		 * 여기서 숫자만 뺴가.  버퍼에서 8, 8  이라는 숫자만 꺼내감. 
		 * 
		 * 키보드 버퍼에 엔터만 남아있음.
		 * 
		 * nextLine ? -> 얘는 정의 자체가 '엔터가 들어올때까지의 문자열을 받는 메소드다'.
		 * 그러니 바로 아무것도 입력받지 않고 출력해냄.
		 * 
		 * 그러면 이거 어떻게 처리?
		 * 언제 발생되는가?
		 *  // 숫자 입력 받은 뒤에 문자열 입력시에는 반드시 '\n' 을 consume(버퍼에서 꺼내는거 즉 제거한다) 해야한다. 
		 *  남아 있는 엔터 빼버리는 동작임
		 *
		 * 
		 */
		
		sc.close();
	}

}
