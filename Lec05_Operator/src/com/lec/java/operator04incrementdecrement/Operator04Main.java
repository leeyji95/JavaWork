package com.lec.java.operator04incrementdecrement;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *  
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

	public static void main(String[] args) {
		System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");
		
		int num1 = 100;
		System.out.println("num1 = " + num1);

		// ++ : 변수값 1증가
		++num1;
		// num1 = num1 + 1 과 동일한 결과
		// num1 += 1 과 동일한 결과
		System.out.println("num1 = " + num1);
		
		// -- :  변수값 1 감소 
		int num2 = 100;
		--num2;
		// num2 = num2 - 1
		// num2 -= 1
		System.out.println("num2 = "  +  num2);
		num2--;
		num2--;
		System.out.println("num2 = "  +  num2);
		
		
		
		System.out.println("\n\n======================");
		System.out.println("증감연산자: prefix(접두사), postfix(접미사)"); // 언제 수행되는가?   무슨 연산자 다음에 or 이전에 
		
		
		int num4 = 100;
		int num5 = ++num4; // prefix, 대입연산자 보다 먼저 수행된다는 것이 중요!!!!  ++ 수행되면 101, 그리고 나서 대입연산자 수행,
		// 대입연산자 = 보다 ++ 가 먼저 수행된다. 
		System.out.println("num4 = "  +  num4);
		System.out.println("num5 = "  +  num5);
		
		int num6 = 100;
		int num7 = num6++; // postifx,  대입연산자 다음에 ++ 증감연산자 수행된다.
		System.out.println("num6 = "  +  num6);
		System.out.println("num7 = "  +  num7);
		
		System.out.println();
		
		int num8 = 10;
		int num9 = --num8 + 5;  // + 보다 먼저. 왜?  -- 없다고 생각하면, num8 은 + 5 랑 먼저 덧셈 연산을 해야하므로, + 에 걸린다.  그래서 + 보다 먼저 수행해야 한다. 
		System.out.println("num8 = "  +  num8);
		System.out.println("num9 = "  +  num9);
		
		int num10 = 10;
		int num11 = num10-- + 5;
		System.out.println("num10 = "  +  num10);  // 9
		System.out.println("num11 = "  +  num11); // 15 
		/*
		 * 과정이 num10 + 5 해서 15 담기고, 
		 * 그다음 num10 에서 1 감소 . 
		 * 15담긴값은 그대로 num11 에 담김.
		 */
		
		//--------------------------------------------------------
		int number1 = 10;
		int number2 = number1-- + 5 + --number1;   
		System.out.println("number1 = "  +  number1);
		System.out.println("number2 = "  +  number2);
		
		// (1) number1에 저장된 값(10) + 5 -> 15
		// (2) number1의 값이 1 감소 -> 9
		// (3) 15 + --number1: number1의 값을 먼저 감소 -> 8
		// (4) 15 + 8 -> 23
		// (5) number2에 23이 저장
		// ★ 그러나, 실무에서는 절대로 이런 코드는 작성하지 마십시오.


		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class












