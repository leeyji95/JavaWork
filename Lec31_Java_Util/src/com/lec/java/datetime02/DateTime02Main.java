package com.lec.java.datetime02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/*
   Calendar 객체
   
   Calendar 는 추상클래스다.  그래서 new로 생성 불가.
     날짜와 시간을 계산하는 방식(역법) 지역, 문화, 나라에 따라 다르기 때문에
     이를 상속받아 개별적으로 구현함
   
   Calendar 는 날짜/시간을 계산하는 꼭 필요한 메소드만 제공하고
     특정한 역법(날싸 시간계산 ex: 음력) 은 상속받은 클래스에서 구현
   
     특별히 상속할 필요 없으면 getInstance() static 메소드 호출
 */
public class DateTime02Main {

	public static void main(String[] args) {
		System.out.println("Calendar객체로 날짜 다루기");
		
		//  특별한 역법을 쓰지 않는 경우.  우리나라 서력 사용.
		Calendar cal = Calendar.getInstance(); // 캘린더 객체 생성. 하는 순간 현재 날짜가 cal 에 담김
		System.out.println("get() 으로 날짜/시간 받아오기");
		System.out.print("현재:");
//		System.out.println(cal.get(Calendar.YEAR));
//		get(int field)
		printDate(cal);

		
		
		
		
		
		System.out.println("\nTimeZone");
		
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		cal = Calendar.getInstance(timeZone);  // 새로운 캘린더 객체 만듬. new 하지 않고 getInstance() 로 해서 만들어줌
		printDate(cal);
		
		System.out.println();
		// 시간대 문자열들 획득
		String[] availableIds = TimeZone.getAvailableIDs(); // TimeZone.getAvailableIDs() --> String 배열형 타입으로 리턴함으로 String [] 에 담아줌
		for(String id : availableIds) {
			System.out.println(id);
		}
		
		
		
		
		
		System.out.println("\nDate ↔ Calendar 변환");
		// 상호간에 변환할 일이 생긴다..
		
		// 캘린더 타입에서 date 타입으로 변환하는 방법 2가지 .
		// 1-1. Calendar -> Date
		cal = Calendar.getInstance();
		Date date = cal.getTime();   // 위 두줄 -> 캘린더 객체를 데이트 객체로 변환   getTime() -> Date 타입으로 리턴
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		
		// 1-2 Calendar -> Date
		date = new Date(cal.getTimeInMillis());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));  // format() -> String 문자열을  Date 타입으로 포맷해준다!
		
		// 2. Date -> Calendar
		cal.setTime(date);
		printDate(cal);	
		
		// 오늘날 우리 대한민국이 쓰는 달력은 GregorianCalendar(국제표준시) 이며
		// 이는 Calendar 를 상속받은 클래스입니다.
		// 기본적으로 시스템 설정 시각 (서울)으로 되어 있으며
		// Locale 값을 설정하면 특정 지역 시각을 알수 있습니다.
		System.out.println();
		System.out.println("GregorianCalendar 사용");
		GregorianCalendar gregCal = new GregorianCalendar();
		printDate(gregCal);
		
		
		int year = 2020;
		System.out.println(year + " 는 윤년? " + gregCal.isLeapYear(year)); // 우리가 쓰는 서력에서만 쓸 수 있다.  윤년이냐? 알아보기 위한 메소드 -> boolean 타입   그레고리 객체 안에 추상메소드임.
		
		// 캘린더 객체를 쓰면 좋은 점 =?  날짜 연산 가능하다. 
		// 오늘날짜로부터 3개월 이내.. 와 같은 날짜 계산 할 수 있다.  3번째 패키로
		
		
		
		
		
		
		
		
		
		
	} // end main()
	
	public static void printDate(Calendar now) { // 도우미 함수..
		
		int year = now.get(Calendar.YEAR);            // 연도 리턴
		int month = now.get(Calendar.MONTH) + 1;    // 월을 리턴  0 ~ 11
		int day = now.get(Calendar.DAY_OF_MONTH);    // 일을 리턴
		
		int week = now.get(Calendar.DAY_OF_WEEK);    // 요일을 리턴   일요일: 1 ~ 토요일: 7
		int ampm = now.get(Calendar.AM_PM);          // AM 0  PM 1
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		

		//week 값으로 뽑아내기
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		case Calendar.SUNDAY:
			strWeek = "일";
			break;
		}

		
		// AMPM 값으로 뽑아내기
		String strAmPm = null;
		switch(ampm) {
		case Calendar.AM:
			strAmPm = "오전";
			break;
		case Calendar.PM:
			strAmPm = "오후";
			break;
		}
		
		
		System.out.println(year + "-" + month + "-" + day + " " + strWeek);
		System.out.println(strAmPm + " " + hour + ":" + minute + ":" + second);


		
		
	} // end printDate()
	
	
} // end class
