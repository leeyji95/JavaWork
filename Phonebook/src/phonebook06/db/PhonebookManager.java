package phonebook06.db;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.net.aso.p;




// CONTROLLER 객체 수정해보쟈~
// 어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)  ..  
// 컨트롤러는 출력 안함. 사용자 입력도 안받음. 주어진 인터페이스와 데이터를 주고 받음 뷰와.     추상메소드를 잡아놓구, 뷰로부터 입력값을 받고  입력받은 값을  처리해서 뷰단에 돌려주는 그런 4역할하는 것이 -> 컨트롤러 역할.
public class PhonebookManager implements Pb, Closeable {
	
	
	// TODO  : DB 를 위한 변수들 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	// singleton 적용
	private PhonebookManager() {
		
		// TODO : 
		// JDBC 프로그래밍
		// 클래스 로딩
		// 연결 Connection
		// 한번만 수행하면 되는 코드이므로, Statement (필요하다면) 생성 
		
		// 2. JDBC 드라이버 클래스를 메모리에 로드 
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// 3. DB 와 Connection 연결
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 연결");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
} // end 기본 생성자
	
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}// end getInstance()
	
//------------------------------------------------------------데이터 나열--------------------------------------------
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// name 값이 반드시 입력되어야 함을 코드로 만들면.
		// ★★★ 매개변수 검증 : 이름 필수 ★★★★
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류:", Pb.ERR_EMPTY_STRING);
		}
		
		
		// TODO : 
		// PreparedStatement 
		// SQL_INSERT 사용하여 INSERT  
		// PreparedStatement 사용..   여기서 close 해주고 
		
		int cnt = 0; 
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			// "INSERT INTO phonebook(pb_uid, pb_name, pb_phonenum, pb_memo) VALUES(phonebook_seq.nextval, ?, ?, ?)"
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			cnt = pstmt.executeUpdate(); // DML 명령어
			System.out.println(cnt + "개 행(row) INSERT 성공");  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	
//----------------------------------------------------------------------------------------------------------------
	// 데이터 출력 
	@Override
	public PhonebookModel[] selectAll() {
		
		// TODO 
		// 리스트 만들어서 해라..
		// SQL_SELECT_ALL 사용 ... 
		List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int uid = rs.getInt(COL_LABEL_UID); // "pb_uid" 값을 꺼냄
				String name = rs.getString(COL_LABEL_NAME);
				String phoneNum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				Date regDate = rs.getDate(COL_LABEL_REGDATE);
				pbList.add(new PhonebookModel(uid, name, phoneNum, memo, regDate)); // 폰북 객체가 리스트에 저장
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pbList.toArray(new PhonebookModel[pbList.size()]);
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		// TODO   쿼리문 정의하기
		// 내가 입력한 uid 값이랑, pb_uid 랑 같은지 찾으면 되잖아.
		PhonebookModel pbm ; // 인스턴스 하나 생성해주고
		try {
				pstmt = conn.prepareStatement(SQL_SELECT_BY_UID);
				pstmt.setInt(1, uid);  // pb_uid = uid  일떄만  컬럼 모두 가져왕
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) { // 합 개 밖에 없으므로, 
					pbm = new PhonebookModel();
					pbm.setUid(uid);
					pbm.setName(rs.getString(COL_LABEL_NAME));
					pbm.setPhoneNum(rs.getNString(COL_LABEL_PHONENUM));
					pbm.setMemo(rs.getString(COL_LABEL_MEMO));
					pbm.setRegDate(rs.getDate(COL_LABEL_REGDATE));
					
					return pbm;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//			
//		
	
		return null; // 없으면 null 리턴
	}  // end selectByUid()

	
//----------------------------------------------------------------------------------------------------------------
	// 데이터 수정
	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		 // 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);  
		if(name == null || name.trim().length() == 0)  // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: " + uid, Pb.ERR_EMPTY_STRING);
		int cnt = 0;
		
		// TODO : 
		// uid 값 곧바로 쿼리문에서 찾을 수 있음
		// SQL_UPDATE_BY_UID 사용 
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");  

		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
		
		return cnt;
	}
	
//---------------------------------------------------------------------------------------------------------------
	@Override
	public int deleteByuid(int uid) {
		
		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("deleteByuid() uid 오류: " + uid, Pb.ERR_UID);  
		
		int cnt = 0;
		
		// TODO 
		// 특정 uid 받아서 삭제 시키기
		// SQL_DELETE_BY_UID 사용 
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) DELETE 성공");  
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	
	
//---------------------------------------------------------------------------------------------------------------
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		// TODO : 옵션 ..   max 함수  쿼리문 만들어 해보기..
		
		return maxUid;
	}

//---------------------------------------------------------------------------------------------------------------

	@Override
	public void close() throws IOException {
		
		// TODO
		// ResultSet
		// Statement
		// Connection 
		// 들 close()...
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn !=  null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
} // end PhonebookManager


//------------------------------------------- 예외 Exception class -------------------------------------------------
// 예외 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지' 를 부여하여 관리하는게 좋다!
class PhonebookException extends RuntimeException{
	
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + 
				" " + super.getMessage();
		
		return msg;
	}
	
} // end PhonebookException

















