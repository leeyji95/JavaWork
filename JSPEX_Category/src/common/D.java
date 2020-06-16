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
	
	// 특정 depth 의 특정 parent 인 카테고리들 읽어오기
		public static final String SQL_CATEGORY_BY_DEPTH_N_PARENT 
					= "SELECT ca_uid, ca_name, ca_depth, ca_parent, ca_order "
							+ "FROM test_category "
							+ "WHERE ca_depth = ? AND ca_parent = ? "
							+ "ORDER BY ca_order ASC";  
		
		
		
		// TODO : 필요한 쿼리문 만들어 보기
		
		public static final String SQL_CATEGORY_BY_DEPTH 
		= "SELECT ca_uid, ca_name, ca_depth, ca_order "
				+ "FROM test_category "
				+ "WHERE ca_depth = ? "
				+ "ORDER BY ca_order ASC";  


		
} 



