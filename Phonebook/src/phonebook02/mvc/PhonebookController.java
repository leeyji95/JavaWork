package phonebook02.mvc;
// <나의 필기>
// Controller 인터페이스
// 왜 인터페이스로 만들?  컨트롤러가  동작을 정의한다고 했잖아.
//  동작을 정의하기 전에 동작을 먼저 설계 해야한다.
// 인터페이스는 추상메소드와 추상멤버변수가 있으므로, 본체가 없다. 그러므로 항상 설계부터 해야 한다.!!!
public interface PhonebookController {
	
	public static final String VERSION = "전화번호부 2.0";
	
	
	// 만들고자 하는 응용프로그램의 
	// '동작' 을 설계하는 것이 인터페이스다.
	// 이 인터페이스는  View 와 Controller 의 연결고리 역할을 하여.  모듈단위 유지관리를 용이하게 해준다. 
	
	// [동작 설계]
	// 1.(생성) 이름(name) 과 전화번호(phoneNum) 과 (memo) 값이 주어지면 전화번호 데이터(PhonebookModel) 를 생성하여 저장,  
	//		날짜(regDate) 는 생성한 날짜로, uid 값은 자동 증가 값으로
	//		성공하면 1, 실패하면 0 리턴
	// 2.(읽음) 현재 전화번호부에 저장된 전화번호 데이터(PhonebookModel) 들을 전부 불러들여서 리턴 (PhonebookModel 배열로)
	// 3. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴
	//		없으면 null 리턴
	// 4.(수정) 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 
	//		주어진 이름(name) 과 전화번호(phoneNum) 과 (memo) 값 으로 변경.  성공하면 1, 실패하면 0 리턴
	// 5. (삭제)특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 삭제.  성공하면 1, 실패하면 0 리턴
	// 6. 최대 uid 값 찾기
	// C에서는 boolean 타입이 없음. 	
	// memo 는 조금 긴 데이터, email 은 긴 데이터
	/*
	 * ~~ 이러이러한 동작이 필요해요.  나열해보고, 설계를 한다.
	 * 이러한 동작들이 인터페이스에  설계.
	 */
	
	// 유지보수때문에 인터페이스로 만든다.  어떤 두 객체간의 가교 역할 을 하는 것을 인터페이스라고 

	// 추상메소드 와 추상멤버 변수 선언해줌
	public abstract int insert(String name, String phoneNum, String memo);  // 데이터 입력
	public abstract PhonebookModel[] selectAll();	// 데이터를 한꺼번에 불러들이고
	public abstract PhonebookModel selectByUid(int uid); // uid 값만 받아서 폰북 모델 타입으로 리턴 할 것
	public abstract int updateByUid(int uid, String namne, String phoneNum, String memo); // 데이터 변경할 것.(수정)
	public abstract int deleteByUid(int uid); // uid 값 받아서 해당 uid에 있는 데이터 지울 것.
	
	public static final int QUERY_FAIL = 0;
	
//	// 인터페이스 메소드 /*1*/
//	public abstract int insert(String name, String phoneNum, String memo); 
//	
//	// 폰북모델배열타입으로 리턴하는 추상메소드  /*2*/ 
//	public abstract PhonebookModel[] selectAll();
//	
//	// uid 를 받아서 찾고 그것을 폰북모델로 리턴할 것./*3*/
//	public abstract PhonebookModel selectByUid(int uid); 
//	
//	// 주어진 데이터를 이 매개변수 값으로 변경해라. /*4*/
//	public abstract int updateByUid(int uid, String name, String phoneNum, String memo);
//	
//	// 이러한 uid 값을 가진 데이ㅓ터를 삭제하겠다./*5*/
//	public abstract int deleteByuid(int uid);
//	
//	public static final int QUERY_FAIL = 0;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
