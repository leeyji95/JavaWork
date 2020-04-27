package phonebook05.file;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
//내가 만든 객체를 리스트에 저장하고,   uid 값과 인덱스 번호가 다르다는 것을 알기.
// 뷰에서는 인터페이스만 쓰고 있음. 내부 구조만 바뀌게 되면, 내부 구조를 관리하고 있는 곳만 바꾸면 된다.
// 두 개의 단이 독립적으로 운영되고 있음.
// 어떠한 동작이 필요한가를 세부적으로 나열하는 설계작업이 매우 중요함.
import java.util.ArrayList;
import java.util.Arrays;

// 폰북의 데이터를 리스트로 만드세요

// CONTROLLER 객체
// 어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)  ..  
// 컨트롤러는 출력 안함. 사용자 입력도 안받음. 주어진 인터페이스와 데이터를 주고 받음 뷰와.     추상메소드를 잡아놓구, 뷰로부터 입력값을 받고  입력받은 값을  처리해서 뷰단에 돌려주는 그런 4역할하는 것이 -> 컨트롤러 역할.
public class PhonebookManager implements Pb, Closeable {
	
	public static final String PB_DATA_DIR = "data";
	public static final String PB_DATA_FILE = "phonebook.dat";  // 데이터 폴더 만들기 
	private File pbDir;
	private File pbFile;
	
	// 폰북 모델을 담는 배열리스트를 만들 것
	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();  // 데이터 구조를 어레이리스트로 바꿀거임
	
// 컨트롤러에서 유지보수건 들어와서 여기서 자료구조만 바꿀 것. ---------------------------------------------------------------------
	
	
	
	// singleton 적용
	private PhonebookManager() {
		
		// TODO
		// 파일이 존재하면 파일 읽어 들이고 --> pbList 로 저장; 
		// FileNotFoundException 여부로 확인~ (패키지01에)
		
		pbDir = new File(PB_DATA_DIR);
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더생성 성공!");
			}else {
				System.out.println("폴더 생성 실패..");
			}
		}else {
			System.out.println("폴더 존재: " + pbDir.getAbsolutePath());
		}
		// 어차피 싱글톤 패턴이므로  한번밖에 호출되지 않을 것! 
		// 싱글톤 패턴 디자인 시험문제에 나옴..!!
		
		pbFile = new File(pbDir, PB_DATA_FILE);
		
		if(pbFile.exists()) {
			System.out.println("파일에서 데이터 읽습니다...");
			// 파일이 존재할 때만 이 try 문 수행!
			try (
					InputStream in = new FileInputStream(pbFile);
					ObjectInputStream oin = new ObjectInputStream(in);
					){
				pbList = null;
				pbList = (ArrayList<PhonebookModel>)oin.readObject();
				
				System.out.println(pbList.size() + " 개의 데이터를 읽었습니다");
//				for(PhonebookModel e : pbList) {
//					e.toString();
//				}
			} catch (FileNotFoundException e1) {
				System.out.println("파일 써주세요");
			} catch(EOFException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("읽어올 파일이 없습니다..");
		}
		
		
		
		
		// 다른 사람은 write 객체 썼음. 이것도 뭐 동작은 함.코드가 좀 김.  파일 자체를 txt텍스트로 저장함. 바로 읽을 수 있는 형태로 저장한 것임. 
	}
	
	
	
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
		
		
		PhonebookModel pbM = new PhonebookModel(name, phoneNum, memo);  // 폰북 모델의 인스턴스 생성 
		pbM.setUid(getMaxUid() + 1);  // ->  insert() 호출 될때마다  고유한 id 값 출력됨--> 즉 입력할 떄마다 uid 부여. 이 uid 는 가장 끝 번호(최대 uid값) + 1  값임. 왜? 중간에 삭제 되었을때 삭제된 것만큼 당겨짐.    uid 값 받고 
		pbList.add(pbM); // size 만큼 데이터 저장
		
//		pbList.get().setUid(getMaxUid() + 1);
		// for 문 아님!!
//		System.out.println(pbList.size() + "개");
		// uid 값 받는 변수가 없는데  이 코드 작성한 이유는? 
		
		return 1;
	}

	
//----------------------------------------------------------------------------------------------------------------
	// 데이터 출력 
	@Override
	public PhonebookModel[] selectAll() {
		// 어레이리스트 pbList 에 담은 것들을 하나씩 읽어서(pbList.get()) 폰북모델 타입의 배열(PhonebookModel[] read)에 저장 
		// pbList.size() 만큼 읽어야 함으로. read 배열 길이는 사이즈.
		
		
		PhonebookModel[] read = new PhonebookModel[pbList.size()];
		for(int i = 0; i < pbList.size(); i++) {
			read[i] = pbList.get(i);
		}
		return Arrays.copyOfRange(read, 0, pbList.size());
		
		// 아래와 같이 한줄로 가능! toArray() : ArrayList<> --> 배열로 볌환가능
//	배열을 리스트로 만드는 것 많이 쓰임.
//	return pbList.toArray(new PhonebookModel[pbList.size()]);
	}
	
	
	
//----------------------------------------------------------------------------------------------------------------
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		
		for(int i = 0; i < pbList.size(); i++) {  // for문으로 반복해서 같은 uid 값 찾아주기
			if(pbList.get(i).getUid() == uid)   
				return pbList.get(i);   //  pbList.get(i) -> PhonebookModel 타입 이므로, 이거의 getUid() 호출. 자기자신 uid 값과 입력받은 uid 값이 같은가?
		}
		return null; //  못 찾으면 null 리턴
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
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 값을 찾아내기  -> 아래 메소드 만들기
		int index = findIndexByUid(uid);  // i 리턴
		if(index < 0) 
			throw new PhonebookException("update() 없는 uid 오류: " + uid, Pb.ERR_UID);  
		
		
		// 이것도 for문 돌리는 거 아님.  추상메소드 호출될때마다 한번씩  출력됨(입력된 값으로 수정되어)
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);;
		pbList.get(index).setMemo(memo);
		// 안에 있는 내용만 바뀌는 것.
		
//		pbList.set(index, new PhonebookModel(name, phoneNum, memo));  -> 이렇게 되면 폰북모델 전체를 바꾸게 됨.
		
		return 1;
	}
	
//---------------------------------------------------------------------------------------------------------------
	@Override
	public int deleteByuid(int uid) {
		
		// 매개변수 검증
		if(uid < 1) 
			throw new PhonebookException("deleteByuid() uid 오류: " + uid, Pb.ERR_UID);  
		
		int index = findIndexByUid(uid);  // i 리턴
		if(index < 0)
			throw new PhonebookException("deleteByuid() 없는 uid 오류: " + uid, Pb.ERR_UID); 
		
		
		// ArrayList 의 삭제 메소드만 사용해주면 ok.  그냥 배열의 경우, 삭제하기 위해 해당 데이터의 값을 뒤의 데이터 값으로 덮어씀. 즉 하나씩 계속 당겨왔다.(for문으로 반복해가며...)
		pbList.remove(index);
		// pbList.set(index, pbList.get(index + 1)); // 인덱스 i번 위치에  인덱스 j번 대이터 쓰겠다.(수정 메소드 set())  
		// -> 해당 데이터가 삭제되는 것이 아니고 수정이 되기 때무네 No.
		return 1;
	}

	
	
//---------------------------------------------------------------------------------------------------------------
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		
		for(int i = 0; i < pbList.size(); i++) {
			if(maxUid < pbList.get(i).getUid()) {
				maxUid = pbList.get(i).getUid();
			}
		}
		return maxUid;
	}

//---------------------------------------------------------------------------------------------------------------

// 특정 uid 값을 가진 데이터의 배열 인덱스 값을 찾아내기
// 못 찾으면 -1 리턴
	private int findIndexByUid(int uid) {
		
		for(int i = 0; i < pbList.size(); i++) {
			if(pbList.get(i).getUid() == uid)
				return i;
		}
		return -1;
	}

//---------------------------------------------------------------------------------------------------------------
	
	@Override
	public void close() throws IOException {
		
		// TODO : 데이터 저장
		// pblist를 파일로 저장하면 된다.
		
		try (
			OutputStream out = new FileOutputStream(new File(pbDir, PB_DATA_FILE));
			ObjectOutputStream oout = new ObjectOutputStream(out);
			){
			oout.writeObject(pbList); // 리스트를 한번에 저장!
			System.out.println("파일 저장 완료!");
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

















