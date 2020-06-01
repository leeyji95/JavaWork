package common;

/*
 * DB 접속 정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별도로 관리하든지
 * XML, 초기화 파라미터 등에서 관리하는 것이 좋다.
 */
public class D {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";  // JDBC 드라이버 클래스
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  // DB 접속 URL
	public static final String USERID = "scott0316";  // DB 접속 계정 정보
	public static final String USERPW = "tiger0316";
	
	public static final String SQL_INSERT = "INSERT INTO user_join VALUES(user_seq.nextval, ?, ?, ?, ?, 0)";
	
	public static final String SQL_GET_EMAIL = "SELECT user_email FROM user_join WHERE user_id = ?";
	
	public static final String SQL_SET_EMAIL_CHECK = "UPDATE user_join SET userEmailChecked = '1' WHERE user_id = ?";
	
	public static final String SQL_EMAIL_CHECK = "SELECT user_emailchecked FROM user_join WHERE user_id = ?";
	
	
	
}


