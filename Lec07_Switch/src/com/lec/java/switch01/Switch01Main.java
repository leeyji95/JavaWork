package com.lec.java.switch01;

/* switch - case 조건문
 * 
 * 	switch (조건값){
 * 	case 값1:
 * 		...
 * 	case 값2:
 * 		...
 *	default:
 *		...
 *	}
 *
 * 	해당 조건의 case문을 찾아서 거기서부터 break를 만날 때까지 실행을 함.
 *  break를 만나게 되면 switch 문장을 종료.
 *  해당하는 case가 없으면 default 문장을 실행함.
 *  
 *  	※ 모든 switch 조건문은 if - else if - else로 바꿀 수 있다. (할수 있어야 한다)
 */
public class Switch01Main {

	public static void main(String[] args) {
		System.out.println("switch 문");

		int num = 2;
		switch(num) {
		case 1:
			System.out.println("하나");
			System.out.println("ONE");
			break;  //switch  안에서의 수행 종료.   // case 1 의 경우, break 가 끝날때까지 수행
		case 2: 
			System.out.println("둘");
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("셋");
			System.out.println("THREE");
		default: 
			System.out.println("이도 저도 아님.."); // 어느  case 에서도 수행하지 않을 때
		} 
		
		System.out.println();
		// 모든 switch 조건문 if - else if - else로 바꿀 수 있다.       그러나 모든 if 문을 switch 문으로 바꿀 순 없다. 
		
		if(num == 1) {
			System.out.println("하나");
			System.out.println("ONE");
		} else if(num == 2) {
			System.out.println("둘");
			System.out.println("TWO");
		} else if(num == 3) {
			System.out.println("셋");
			System.out.println("THREE");
		} else {
			System.out.println("이도 저도 아님..");
		}
		
		
		/*
		 * 	
		  모든 switch 조건문 if - else if - else로 바꿀 수 있다.           그러나 모든 if 문을 switch 문으로 바꿀 순 없다. 
		내부적으로 작동 방식이 다름.
		
		if 문은 차례대로 수행(즉, 한줄한줄 체크하면서), switch 문은  바로 그 값으로 가서  곧바로 수행함(뛰어넘음).
		 */
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










