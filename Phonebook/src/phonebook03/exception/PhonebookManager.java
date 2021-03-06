package phonebook03.exception;

import java.util.Arrays;


// CONTROLLER 객체
// 어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)
public class PhonebookManager implements PbControl {
	
	// 최대 데이터개수 잡아놓기 
	public static final int MAX_DATA = 3; 
	
	// 배열로 구현
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];  //-> 3개 짜리 배열로 시작하겠다. 플러스 3씩 증가하는 걸로.(잏정양 증가)
	
	// 5개짜리 배열에 데이터 더 추가하려면?     ---> 새로 만들어야 한다...(오...) 새집으로 이사가야함.  
	// 데이터 늘리는 배열 동작은 성능이 느림. 
	
	// 몇개의 데이터가 저장되었는지
	private int count = 0;
	
	
	
	// singleton 적용
	private PhonebookManager() {}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}// end getInstance()
	
//------------------------------------------------------------데이터 나열	
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// name 값이 반드시 입력되어야 함을 코드로 만들면.
		// ★★★ 매개변수 검증 : 이름 필수 ★★★★
		
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류:", PbControl.ERR_EMPTY_STRING);
		}
		
		
		// 1. 만약 배열이 다 차있는지 부터 봐야함. 
		// 만약 배열이 다 찼으면, MAX_DATA 만큼 추가된 새 배열 작성
		// count == pbList.length 같으면 다 찼는지 알 수 있다.
		if(count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length + MAX_DATA); // 원본데이터는 복사되고, 나머지는 null 로 초기화 된다.  그 카피된 것이 리턴된다. 그걸 pbList 에 덮어쓴다.
		}
		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count].setUid(getMaxUid() + 1);  // 기존의 최대 uid 값보다 1 증가한 값. (unique 한 값 보장하기 위해, 절대 중복될 수 없기 때문)
		// uid 와  배열 index 는 다르다!! 
		count++;
		
		
		return 1;
	}

	
//------------------------------------------------------------
	// 데이터 출력 
	@Override
	public PhonebookModel[] selectAll() {
		return Arrays.copyOfRange(pbList, 0, count);  // COUNT 4라면 0-3까지 4개의 ㄷ이터가 저장되어 있다는 뜻
	}

	
//------------------------------------------------------------
	// uid 찾기
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid)
				return pbList[index];  // uid 값 발견하면 리턴
		}
		return null; //  못 찾으면 null 리턴
	}  // end selectByUid()

	
//------------------------------------------------------------	
	// 데이터 수정
	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		 // 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, PbControl.ERR_UID);  
		if(name == null || name.trim().length() == 0)  // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: " + uid, PbControl.ERR_EMPTY_STRING);
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 값을 찾아내기  -> 아래 메소드 만들기
		int index = findIndexByUid(uid);
		if(index < 0) 
			throw new PhonebookException("update() 없는 uid 오류: " + uid, PbControl.ERR_UID);  
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);
		
		return 1;
	}
	
//------------------------------------------------------------
	@Override
	public int deleteByuid(int uid) {
		
		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("deleteByuid() uid 오류: " + uid, PbControl.ERR_UID);  
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByuid() 없는 uid 오류: " + uid, PbControl.ERR_UID); 
		
		// 배열 뒤의 원소들을 앞으로 이동
		for(int i = index, j = index + 1; j < count; i++, j++) {
		// j에 있는게 i 에 있는곳으로 당겨옴			
					pbList[i] = pbList[j];	
		}
		
		// count 감소
		count--;
		
		return 1;
	}

	
	
//------------------------------------------------------------
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		// count 값이 데이터의 개수....니까 ㄷ이터개수만큼  뒤짐!
		
		for(int index = 0; index < count; index++) {
			if(maxUid < pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}
		
		return maxUid;
		
	}
	


//------------------------------------------------------------

// 특정 uid 값을 가진 데이터의 배열 인덱스 값을 찾아내기
// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return index;
			}
		}
		return -1;
	}
	
} // end PhonebookManager

// 예외 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지' 를 부여하여 관리하는게 좋다!
class PhonebookException extends RuntimeException{
	
	private int errCode = PbControl.ERR_GENERIC;
	
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
		String msg = "ERR-" + errCode + "]" + PbControl.ERR_STR[errCode] + 
				" " + super.getMessage();
		
		return msg;
	}
	
} // end PhonebookException

















