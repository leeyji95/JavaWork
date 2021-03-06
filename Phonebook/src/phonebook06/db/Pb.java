package phonebook06.db;
// <나의 필기>
// Controller 인터페이스
// 왜 인터페이스로 만들?  컨트롤러가  동작을 정의한다고 했잖아.
//  동작을 정의하기 전에 동작을 먼저 설계 해야한다.
// 인터페이스는 추상메소드와 추상멤버변수가 있으므로, 본체가 없다. 그러므로 항상 설계부터 해야 한다.!!!
public interface Pb {
	
	public static final String VERSION = "전화번호부 6.0";
	
	// 인터페이스 변수 /*1*/
	public abstract int insert(String name, String phoneNum, String memo); 
	
	// 폰북모델배열타입으로 리턴하는 추상메소드  /*2*/ 
	public abstract PhonebookModel[] selectAll();
	
	// uid 를 받아서 찾고 그것을 폰북모델로 리턴할 것./*3*/
	public abstract PhonebookModel selectByUid(int uid); 
	
	// 주어진 데이터를 이 매개변수 값으로 변경해라. /*4*/
	public abstract int updateByUid(int uid, String name, String phoneNum, String memo);
	
	// 이러한 uid 값을 가진 데이ㅓ터를 삭제하겠다./*5*/
	public abstract int deleteByuid(int uid);
	
//	public static final int QUERY_FAIL = 0;
	
	
	// 익셉션으로  FAIL  판단할거기때문에 상수 QUERY 지울 것
	// 여러가지 에러 사항 정리
	

	// 에러코드 상수
	public static final int ERR_GENERIC = 0; // 일반 오류
	public static final int ERR_INDEXOUTOFRANGE = 1;// 인덱스 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2;// 입력문자열이 empty(or null) 인 경우
	public static final int ERR_UID = 3;// uid 가 없는 경우
	

	// 에러문자열
	public static final String[] ERR_STR = {
		"일반오류", // 0
		"인덱스오류", // 1
		"문자열오류", // 2
		"UID 오류" //3 
	};
//-=---------- 여기까지 위에서 에러 코드값 만들었고, 그에 상응하는 메시지 만든 것

	
	
	
// Query 복붙
	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";
	
	
	// 필요한 상수 만들기 
	public static final String TBL_NAME = "phonebook";
	
	public static final String COL_LABEL_UID = "pb_uid";
	public static final String COL_LABEL_NAME = "pb_name";
	public static final String COL_LABEL_PHONENUM = "pb_phonenum";
	public static final String COL_LABEL_MEMO = "pb_memo";
	public static final String COL_LABEL_REGDATE = "pb_regdate";
	public static final String SEQ_NAME = "phonebook_seq";

	
	// 쿼리 문자열
	// PreparedStatement  방식
	
	public static final String SQL_COUNT_ALL 
						= "SELECT COUNT(*) cnt FROM " + TBL_NAME;
	
	public static final String SQL_SELECT_ALL   // 조회
						= "SELECT * FROM " + TBL_NAME 
						+ " ORDER BY " + COL_LABEL_UID 
						+ " DESC";
	
	public static final String SQL_INSERT    // 삽입
						= "INSERT INTO " + TBL_NAME 
						+ "(pb_uid, pb_name, pb_phonenum, pb_memo) " 
						+ " VALUES(" + SEQ_NAME + ".nextval, ?, ?, ?)";
	
	// "INSERT INTO phonebook(pb_uid, pb_name, pb_phonenum, pb_memo) VALUES(phonebook_seq, ?, ?, ?)"
	// "INSERT INTO phonebook(pb_uid, pb_name, pb_phonenum, pb_memo) VALUES(phonebook_seq.nextval, ?, ?, ?)"
	
	public static final String SQL_UPDATE_BY_UID     // 특정 UID 값을 수정
						= "UPDATE " + TBL_NAME + " SET " 
						+ COL_LABEL_NAME + " = ?, " 
						+ COL_LABEL_PHONENUM + " = ?, " 
						+ COL_LABEL_MEMO + " = ? " + "WHERE " 
						+ COL_LABEL_UID + " = ?";
	
	public static final String SQL_DELETE_BY_UID
						= "DELETE FROM " + TBL_NAME
						+ " WHERE " + COL_LABEL_UID + " = ?"
						;

	
	// TODO : 추가로 필요한 쿼리문...
	public static final String SQL_SELECT_BY_UID 
						= "SELECT * FROM phonebook where " 
						+ COL_LABEL_UID + " = ?";  // pb_uid = ? 일때만 모든 컬럼들 다 소환
	
	

}
