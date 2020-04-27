package phonebook03.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

// VIEW 객체
// 사용자와의 입출력 담당(UI, ...)
public class PhonebookMain {
	// 사용자 입력 받아서 전화번호부에 데이터 저장해 나갈것. 
	// 멤버변수
	private Scanner sc;
	private PhonebookManager pbMg; // CONTROLLER 객체    (인터페이스 phonebookController 상속받음) 
	
	
	// 메인 메소드
	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init(); // 초기화
		app.run(); //  실행
		app.exit(); // 종료
	} // end main()

	
//--------------------------------------------------------	
	// 응용프로그램을 초기화 메소드
	public void init()	{
		sc = new Scanner(System.in);
		pbMg = PhonebookManager.getInstance();  
	}
	
	
//--------------------------------------------------------	
	// 응용프로그램 구동 메소드
	public void run() {
		System.out.println(PbControl.VERSION);
		
		while(true) {
			showMenu(); // 메뉴표시
			
			int menu;
			try {
				menu = sc.nextInt(); // 메뉴 입력  // 숫자말고 엉뚱한거 입력했을 시  처리위해 안으로 가져옴 -> catch(인풋미스매치)
				sc.nextLine();  // 버퍼 비우기 
				switch (menu) {
				case Menu.MENU_INSERT:  // 데이터 입력
					insertPhoneBook();
					break;
				case Menu.MENU_LIST:  // 데이터 저장
					listPhonebook();   
					break;
				case Menu.MENU_UPDATE:  // 데이터 수정
					updatePhonebook();          
					break;
				case Menu.MENU_DELETE:   // 데이터 삭제
					deletePhonebook();
					break;
				case Menu.MENU_QUIT:   // 종료
					System.out.println("프로그램을 종료합니다");
					return;
				default:
					System.out.println("잘못입력하셨습니다.");
				}
			} catch (PhonebookException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				sc.nextLine();
			}
			
			// 이 스위치문 안에서 익셉션 타고타고 올라간다.
			
		} // end while
		
	}
	
//--------------------------------------------------------	
	// 응용프로그램 종료 메소드
	public void exit() {
		sc.close();
	}
	
	
	
//--------------------------------------------------------	
	// 전화번호부 입력 메소드
	// 배열 안에 저장된  전화번호부듣 출력 메소드
	public void insertPhoneBook() {
		// VIEW 역할 : 사용자 입출력
		System.out.println("--- 입력 메뉴 ---");
		
		// 이름, 전화번호, 이메일 입력 받기
		System.out.println("이릅입력: ");
		String name = sc.nextLine();
		System.out.println("전화번호입력: ");
		String phoneNum = sc.nextLine();
		System.out.println("메모입력: ");
		String memo = sc.nextLine();
		
		
		// 입력 받고, 저장하는.  그 접점이 controller 
		// CONTROLLER  에 연결
		//ㅇ view 에서는 인터페이스에 있는 메소드를 사용한다. 그것만 사용한다. 
		// 가교역할하는 인터페이스.  컨트롤러와 뷰 사이의 가교 역할하는 인터페이스 
		int result = pbMg.insert(name, phoneNum, memo);
		System.out.println(result + "개의 전화번호 입력 성공");
		
	} // end insertPhoneBook()
	
	
	// 전화번호부 열람(전체)
	public void listPhonebook() {
		// CONTROLLER 연결
		PhonebookModel[] data = pbMg.selectAll();
		
		// VIEW 역할 : 사용자 입출력 --> 컨트롤러에서 데이터 끌고 와서 읽어들임
		System.out.println("총 " + data.length + " 명의 전화번호 출력");
		for(PhonebookModel e : data ) {
			System.out.println(e);
		}
	}
	
	
	// 전화번호부 수정
	public void updatePhonebook() {
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("---- 수정메뉴 ----");
		System.out.println("수정할 번호 입력:");
		int uid = sc.nextInt();  // uid 값 입력
		sc.nextLine();  // 버퍼 지우고
		
		if(pbMg.selectByUid(uid) == null) {
			System.out.println("존재하지 않는 uid : " + uid);
			return;
		}
		
		
		// 이름, 전화번호, 이메일 입력 받기  (insertPhonebook() 복사)
		System.out.println("이릅입력: ");
		String name = sc.nextLine();
		System.out.println("전화번호입력: ");
		String phoneNum = sc.nextLine();
		System.out.println("메모입력: ");
		String memo = sc.nextLine();
		//입력 끝 -----		
		
		
		// CONTROLLER 연결
		int result = pbMg.updateByUid(uid, name, phoneNum, memo); // 이 값을 정수값으로 결과 받고,
		System.out.println(result + "개의 전화번호 수정 성공");
		
		
	} // end updatePhonebook()
	
	// 전화번호부 삭제
	public void deletePhonebook() {
		// VIEW : 사용자 입출력
		System.out.println("---삭제 메뉴----");
		
		System.out.println("삭제할 번호 입력:");
		int uid = sc.nextInt();
		sc.nextLine();
		
		//CONTROLLER
		int result = pbMg.deleteByuid(uid);
		System.out.println(result + " 개의 전화번호 삭제 성공");
		
		
	} // end deletePhonebook()
	
	
	
	
//--------------------------------------------------------	
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[0] 종료");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 수정");
		System.out.println("[4] 삭제");
		System.out.println("------------------");
		System.out.print("선택: ");
	}


	
} // end class
