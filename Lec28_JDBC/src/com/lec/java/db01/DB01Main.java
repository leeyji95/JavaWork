package com.lec.java.db01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)  --->  동일명 패키지가 있을 경우  우선순위를 정해줌

 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site


public class DB01Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	
	// DB 서버 접속 주소(url) 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	
	// DB 접속 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316"; 

	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null;  // java.sql.Connection  패키지에서 대부분 import 됨
		Statement stmt = null;  //java.sql.Statement
		ResultSet rs = null;   //java.sql.ResultSet
		
		// 2. JDBC 드라이버 클래스를 메모리에 로드
		try {
			Class.forName(DRIVER); // <-- 동적 클래스 로딩           자바가상 머신에서 메소드에리어는 프로그램 시작할떄 클래스로딩된다고했음 괄호치고 작게.. 근데 이건 프로그램 실행중에 로딩이 될 때가 forname 메소드 .   메모리에 로딩되고 나서 실행됨.
			System.out.println("드라이버 클래스 로딩 성공");
			
			// 3. DB와 connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWD); // SQLException (최상위Excetion임 거의)
			System.out.println("DB Connect 연결");
			// 시스템이 네트워크와 연결된다는 건 복잡하고 신비로운 것..  이 connection 은 자원이다. 그러므로 꼭 finally,, close!  시스템적으로  로드 되는 시간이 조금 있음.(<-이게 connection 잡는거) 이게 무한정 로드 되는 것이 아니므로 한정된 자원이다. 그러므로 클로즈 해주는 것
			
			//4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)  --> DB에 쿼리 날리는 동작( 연결로 끝이 아니잖아?) 쿼리 날리기 위해서 Statment 인스턴스가 필요함
			stmt = conn.createStatement();  // Connection으로부터 Statement 가 만들어짐
			System.out.println("Statement 생성 성공");
			// Statement도 자원이므로, 
			
			// 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			System.out.println();
			String sql_insert = "INSERT INTO test_member VALUES(100,'마징가', SYSDATE)"; // sql문이 String 으로 들어감..
			
			//sql_insert = "INSERT INTO test_member(mb_no) VALUES(101)";
			
//			int no = 200;
//			String name = "뽀로로";
//			sql_insert = "INSERT INTO test_member VALUES(" + no + ", '" + name + "', SYSDATE)";  // 사용자입력 받아서 sql 문 조립하고 수행한다~~   특히, 문자열에 ' 싱글따옴표 뻬먹지 말자!!
			
			System.out.println(sql_insert);     // sql 은 Statement 인스턴스로 실행됨.
			int cnt = stmt.executeUpdate(sql_insert); // 'DML' 명령은 executeUpdate() 로 실행 ,   리턴값 "정수" 이므로  ~    몇 개의 행인지 INSERT, DELETE, UPDATE 되는지 출력됨
											// 리턴값은 정수(int)
			System.out.println(cnt + "개 row(행)이 INSERT 됨");
			
			System.out.println();
			String sql_select = "SELECT mb_no mm, mb_name, mb_birthdate FROM test_member";
			System.out.println(sql_select);
			
			rs = stmt.executeQuery(sql_select);  // 'SELECT' 및 기타 쿼리의 경우 executeQuery() 로 실행 
											// 리턴값은  ResultSet 객체     SELECT 의 결과는 테이블이기 때문에 그럼
			// 7. ResultSet 에 담겨 있는 record 확인하자(그 전에 rs 도 자원이므로 close 해주고 가자)
			// 7-1 컬럼이름으로 받기 
			System.out.println();
//			while(rs.next()) { // next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
//					// 각 레코드별로 컬럼이름으로 출력해보자
//				
//				 String no = rs.getString("mm"); // getXXX() 에 '컬렁명' 혹은 '별명' 명시    // 엉뚱한 컬럼 이름 넣었을 때 : java.sql.SQLException: 부적합한 열 이름    에러 // 위에서 별명으로 썻으면, 별명으로 뽑아야 한다. 
//				 String name = rs.getString("mb_name");
//				 String birthdate = rs.getString("mb_birthdate"); 
//				 // 각각의 컬럼 값을 String 타입으로 받았구, 
//				 String result = no + "\t | " + name + "\t | " + birthdate;
//				 System.out.println(result);
//				 
//				// 컬럼/별명이름 틀리면
//				// java.sql.SQLException: 부적합한 열 이름 
//			} // end while
			// ->  오라클의 타입으로 모두 String으로 바꿔서 출력한 결과임
			
			
			//7-2 컬럼 인덱스로 받기 
//			while(rs.next()) { // next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
//				
//			
//			 String no = rs.getString(1); // getXXX() 에 인덱스 명시 (1부터 시작)   셀렉트 구문 안에 있었던 컬럼이름 순서(※ 1부터 시작_인덱스가!) 
//			 String name = rs.getString(2);  // 없으면 null 을 리턴함
//			 String birthdate = rs.getString(3);  
//			 String result = no + "\t | " + name + "\t | " + birthdate;
//			 System.out.println(result);
//		} // end while
			
			
			//7-3 null 처리하기 
//			while(rs.next()) { // next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
//				
//				
//			 //getXXX() 로 가져온 데이터가 NULL 값이면 null 리턴한다.   이거 처리해보자
//			 String no = rs.getString("mm"); 
//			 if(no == null) no = "";
//			 String name = rs.getString("mb_name");
//			 String birthdate = rs.getString("mb_birthdate");  
//			 if(birthdate == null) birthdate = "";
//			 String result = no + "\t | " + name + "\t | " + birthdate;
//			 System.out.println(result);
//			 
//		} // end while
//			
			
			//7-4 개별적인 타입으로 get하기    받아올 떄 오라클 타입과 같은 걸로 받아오고 싶을 떄 
			while(rs.next()) { // next() 레코드 하나 추출하고 true 리턴, 더이상 뽑아낼 레코드 없으면 false 리턴
				
					
				 int no = rs.getInt("mm"); 
				 // mm 컬럼값이 null 이면 0 리턴 한다. 
				 String name = rs.getString("mb_name");
				 String birthdate = rs.getString("mb_birthdate");  
				 
				 // java.sql.Date, java.sql.Time
				 Date d = rs.getDate("mb_birthdate"); // 날짜만 가져옵니다  / java.sql 패키지로 import
				 Time t = rs.getTime("mb_birthdate"); // 시간만 가져옵니다
				 
				 if(d != null) {
					 birthdate = new SimpleDateFormat("yyyy년MM월dd일").format(d) + " " + 
							 	new SimpleDateFormat("hh:mm:ss").format(t);
				 }
				 
				 String result = no + "\t | " + name + "\t | " + birthdate;
				 System.out.println(result);
				 
			} // end while
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 나중에 만들어진 인스턴스부터 먼저 close() 해주자.
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();  // Connection 부터 만들어졌으므로, stmt 부터 닫아줘야지
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main













