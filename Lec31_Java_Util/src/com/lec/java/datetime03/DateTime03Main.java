package com.lec.java.datetime03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Calendar 객체를 사용한 시간 및 날짜 연산
 *  
 */
public class DateTime03Main {

	public static void main(String[] args) {
		System.out.println("날짜, 시간 연산");

		Calendar cal = Calendar.getInstance();
		DateFormat df = null;  // SimpleFormat 의 부모
		Date date = null;
		
		//-------------------------------------------------------
		System.out.println("현재 시간에서 날짜 더하고 빼기");
		
		cal.setTime(new Date()); // 현재 시간
		df = new SimpleDateFormat("yyyy-MM-dd");
		df.format(cal.getTime());  // cal 객체를 date객체로 바꾸고 그걸 Datefomat 객체로 변환함.
		System.out.println(df.format(cal.getTime()));
		
		// 어떤 값을 기준으로 연산할 것인가,  년월일시분초단위로 쓸 수 있다. 
//		cal.add(Calendar.MONTH, -4);  // 현재 날짜에서 '월' 2개월 뒤 를 출력함.  11 -> 내년 2021 ~,  -4 하면 2019~
		cal.add(Calendar.DATE, 3);  // Calendar 의 DATE 하면 '일' 증가 
		
		System.out.println("계산후: " + df.format(cal.getTime()));
		
		
        //-------------------------------------------------------
        System.out.println();
        System.out.println("특정 날짜에 더하고 빼기");
        
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
			date = df.parse("2020-03-16 09:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
     // add 로 시간 계산하기
        cal.setTime(date);  // 캘린더 객체를 Date 객체로 변환
        System.out.println("주어진시간: " + df.format(cal.getTime()));
        cal.add(Calendar.HOUR_OF_DAY, 5);  //아워 오브는 24시간제, 그냥 아워는 12시간제
        cal.add(Calendar.MINUTE, 20); 
        cal.add(Calendar.SECOND, 10);
        System.out.println("계산후 시간: " + df.format(cal.getTime()));
        
        //-------------------------------------------------------
        System.out.println();
        System.out.println("날짜 두개 더하기");
        // 두개의 Date를 더하려면 두개의 Calendar를 사용해야 합니다. 

        Calendar cal2 = Calendar.getInstance();
        System.out.println("cal: " + df.format(cal.getTime()));
        System.out.println("cal2: " + df.format(cal2.getTime()));
        
        cal.add(Calendar.DATE , cal2.get(Calendar.DATE)); // cal 값의 변화.    cal의  일에 cal2 일수를 더한것과 빼는  연산 가능

        System.out.println("날짜 두개  계산후");
        System.out.println("cal: " + df.format(cal.getTime()));
        System.out.println("cal2: " + df.format(cal2.getTime()));
        
        
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











