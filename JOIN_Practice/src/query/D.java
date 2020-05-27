package query;

public class D {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";  // JDBC 드라이버 클래스
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  // DB 접속 URL
	public static final String USERID = "scott0316";  // DB 접속 계정 정보
	public static final String USERPW = "tiger0316";
	
	public static final String SQL_SELECT_USERPASSWORD = "SELECT userPassword FROM TB_USER WHERE userID = ?";

	public static final String SQL_INSERT_TB_USER = "INSERT INTO TB_USER VALUES (?, ?, ?, ?, ?)";

	public static final String SQL_SELECT_USEREMAIL = "SELECT userEmail FROM TB_USER WHERE userID = ?";

	public static final String SQL_SELECT_USEREMAILCHECKED = "SELECT userEmailChecked FROM TB_USER WHERE userID = ?";

	public static final String SQL_UPDATE_USEREMAILCHECKED = "UPDATE TB_USER SET userEmailChecked = ? WHERE userID = ?";





	
	
	
	
	

}
