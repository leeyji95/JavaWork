package com.lec.java.datetime01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * 날짜를 다루기 위해 자바에선 java.util.Date 클래스 제공   JDK 1.0 부터..
 * 이후 보완하여 java.util.Calendar 등장   JDK 1.1 부터..
 * java.time 패키지 제공 JDK 1.8 (Java8)부터
 * 
 * 지금은 java.time 패키지만으로 충분하긴 하나.. 
 * 오랜시간 Date, Calendar 를 사용하여 만들었으므로 이 또한 알긴 알아야 한다
 * 
 */
public class DateTime01Main {

	public static void main(String[] args) throws Exception{
		System.out.println("Date객체로 날짜 다루기");

		// 현재 날짜 얻어오기,  생성자가 현재 날짜, 시간을 얻어온다.  <-  new  하는 순간 날짜 날라온다
		Date now = new Date();
		String strNow = now.toString();
		
		
		System.out.println("1. Date 의 toString() 사용한 출력");
		System.out.println(strNow);   // 기본 toString 형식으로 출력됨(드러움...)
		
		System.out.println();
		System.out.println("2. Date 의 get..()을 사용한 출력");
		// Date객체의 대부분의 메소드들은 현재 deprecated 됨.
		int year = now.getYear() + 1900; // 연도는 1900 이후 경과 년도 출력함으로 + 1900 한다. // 안드로이드에서 많이 나옴. 데프러케이트. .. -> 앞으로 이거는 안쓸거에요 라는 말. 계속 시대가 바뀌면서 대체되거나 등등 이전에 만들었던 거를 고지한 것.  당장은 돌아가고 에러는 나지 않음. 앞으로 사라질 메소드라는 뜻.
		int month = now.getMonth() + 1;  // 0 부터 시작, 0이 1월임.
		int date = now.getDate(); // 날짜 
		int weekDay = now.getDay(); // 요일 : 일요일이 0 
		int hour = now.getHours();
		int minute = now.getMinutes();
		int second = now.getSeconds();
		System.out.println(year + "년 " + month + "월 " + date + "일 " + weekDay + "요일 " +hour + "시 " + minute + "분 " + second + "초");
		// 옛날에 이런게 있었구나만 알기 
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("3. SimpleDateFormat 사용한 출력");  // 위에거 쓰지 말고 이거 쓰세요 // 원하는 형식으로 출력해낼 수 있음
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");  // 문자를 이런 형식으로 입력하겠다고 말하는 것
		String strNow2 = fmt.format(now);
		System.out.println(strNow2);
		
		// yyyy-MM-dd hh:mm:ss 형식 출력
		// 포맷에 사용되는 문자열 종류 : 자바의 정석 교재 p544
		// H: 시간 (0~23),  h : 시간 (1~12)
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now));  // 한줄 표현!
		
		// ※ 현재 Date() 객체는 생성자를 제외하고는 거의다 deprecated 되어 있다.
		
		System.out.println();
		System.out.println("Date 테스트");
		long baseTime = System.currentTimeMillis(); // 현재시각을 ms 로 리턴.  1000분의 1초 단위
											// 1970-01-01 00:00:00 UTC 기준으로 경과된 ms ---->  날짜시간 계산할 때 이 기준으로 한 밀리세컨즈 출력됨.
//		System.out.println(baseTime);
		long curTime = baseTime + 2000; // 2 초 뒤의 시간값 ms   ...   1초 는 1000ms 이므로 2초는 2000ms
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("YYYY:MM:dd-HH:mm:ss", Locale.KOREA); // 두번째 변수에는 어느 지역대의 시간인지 지정해줄수 있음. 즉 나라별 시간 -> Locale 씀
		String mTime = mSimpleDateFormat.format(new Date(baseTime));  // format(여기는 Date 객체 들어가야 함.)-> Date객체를 문자열로 변환
		String mTime2 = mSimpleDateFormat.format(new Date(curTime));
		System.out.println(mTime); 
		System.out.println(mTime2);
		
		
//------------------------------------------- 거---- 꾸---- 로-----------------------------------------------------------------------------------------------------------		
		
		
		// 문자열을 Date 타입으로 파싱하기
		System.out.println();
		System.out.println("문자열 -> Date");
		String oldstring = "2018-08-16 14:21:52.3";
		
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.KOREA).parse(oldstring); // .S 는 십분의 1초  // 이거는 문자열을  date 객체로 표현하는 코드 (new ~ 만들고 이걸 date 에 담기)
		System.out.println(date1); // Date 객체로만이 날짜 계산 가능함.
		
		// 경과시간 체크하기
		System.out.println();  // 특정구간의 시간체크 할 때 사용함.
		System.out.println("경과시간");  // 1000 이면 1초 딜레이(약 1초 정도 딜레이되면서 출력)
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}  // 이 구간 수행하는데 5초 걸림... 특정구간의 시간체크 할 때
		long end = System.currentTimeMillis();
		long lapTime = end - start; // 경과시간
		System.out.println("경과시긴: " + lapTime + " ms");
		
		
		// nonesec : 10E-9초
		start = System.nanoTime();
		// ...
		end = System.nanoTime();
		
		
		
		
		System.out.println();
		System.out.println("millisec -> time");  // -----> 알고리즘 성능 계산할 떄 ....    최소한 밀리 세컨즈로 계산함.
		// 밀리세컨즈로 받아사서 데이트 객체로 변환해서 출력함. 
		// 이 밀리세컨드는 몇 초 인지, 몇 시간인지... 알고 싶을 때
		long  durationInMillis = 1000003; // 뒤에 세자리가 ms 밀리세컨즈조.? 2300 -> 2.3 초 니까 300 을 ms 로 볼 수 있다. 
		long millis = durationInMillis % 1000; // 1000 으로 나눈.
		long sec = (durationInMillis / 1000) % 60; // 초로 환산하고 싶으면 1000으로 나누고 60 으로 나눈 나머지.
		long min = (durationInMillis/ (1000 * 60)) % 60;
		long hr = (durationInMillis / (1000 * 60 * 60)) % 24;
		
		// * 그래서 1000000 이게 몇 초인데?
		
		String time = String.format("%02d:%02d:%02d.%03d", hr, min, sec, millis);
		System.out.println(time);
		
		// 백만삼 밀리세켄드는 16분으로 환산(시분초니까)  초가 소수점 단위로 나옴.
		
		
		
		
		
		
		
		

		
	} // end main()

} // end class
