package phonebook01.class01;

import java.util.Scanner;

public class PhonebookMain {
	
	// 사용자 입력 받아서 전화번호부에 데이터 저장해 나갈것. 
	
	// 멤버변수
	Scanner sc;
	PhonebookModel [] bookData = new PhonebookModel[5];
	
	
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
		
	}
	
	
//--------------------------------------------------------	
	// 응용프로그램 구동 메소드
	public void run() {
		System.out.println("전화번호부 v1.0");
		
		while(true) {
			showMenu(); // 메뉴표시
			
			int menu = sc.nextInt(); // 메뉴 입력
			sc.nextLine();  // 버퍼 비우기 
			
			switch (menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다");
				insertPhoneBook();
				break;
			case 2:
				System.out.println("전화번호부 출격(열람)");
				showPhoneBook();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("잘못 입력하셨습니다");
			}
			
			
			
		} // end while
		
	}
	
//--------------------------------------------------------	
	// 응용프로그램 종료 메소드
	public void exit() {
		sc.close();
	}
	
	
//--------------------------------------------------------	
	// 전화번호부 입력 메소드
	public void insertPhoneBook() {
		// 배열 안에 저장된  전화번호부듣 출력 메소드
		
		// 이름, 전화번호, 이메일 입력 받기
		// --> PhonebookModel  인스턴스 생성하고
		
		// 입력할 때마다 배열에 데이터 저장. 
		int count = 0;  // 몇번째 데이터인지 
//		for (int i = 0; i < bookData.length; i++) {
			// 인스턴스 통해 입력받기
//			p1.setName(sc.nextLine()); 
//			p1.setPhoneNum(sc.nextLine()); 
//			p1.setEmail(sc.nextLine()); 
////			
//			PhonebookModel data;
//			
//			bookData[i] = data;  // 배열에 담기...   
//			
//			count++; // 데이터 저장할 때마다 1 증가 -> n 번째 전화번호부 
//		}
//		
		
		// 전화번호부가 다 찼는지 부터 체크
		int i;
		for (i = 0; i < bookData.length; i++) {
			if(bookData[i] == null) break;  // 비어있다는 뜻
		}
		
		// 다 찼으면 입력불가 처리
		if(i == bookData.length) {
			System.out.println("전화번호부가 다 찼습니다");
			return;
		}
		
		// 이름, 전화번호, 이메일 입력 받기
		System.out.println("이릅입력: ");
		String name = sc.nextLine();
		System.out.println("전화번호입력: ");
		String phoneNum = sc.nextLine();
		System.out.println("이메일입력: ");
		String email = sc.nextLine();
		
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email); // 폰북 모델 객체 생성
		pb.setUid(i); // i 번째 id 
		
		// 배열에 추가
		bookData[i] = pb;
		System.out.println((i + 1) + "번쩨 전화번호부 추가 성공");
		
	}
	
	
	
//--------------------------------------------------------	
	// 전화번호부 출력
	public void showPhoneBook() {
		// 배열 안에 저장된 전화번호부들 출력
		int i;
		for (i = 0; i < bookData.length; i++) {
			PhonebookModel p1 = bookData[i];
			if(p1 == null) break;
			
			System.out.println(p1);
		}
		System.out.println(i + " 개의 전화번호부 출력");
	}
	
	
	
//--------------------------------------------------------	
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	}


	
} // end class
