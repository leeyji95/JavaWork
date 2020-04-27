package practice.cardcompany;

public class Company {
//-------- ---------싱글톤 디자인 패턴---------------------------
		// 기본 생성자
		private Company() {} // 인스턴스 만들지 못하게 private
		
		// 클래스변수  instance
		private static Company instance = null;
		
		// 인스턴스 하나만 생성 메소드
		public static Company getInstance() {
			if(instance == null) {
				instance = new Company();  
			}
			return instance;
		}
//---------------------------------------------------------


		private static int num = 10000; // 10000 으로 초기화   // 어차피 인스턴스가 하나이기때문에 static 굳이 안해도 됐었다. 
		public Card createCard() {  // createCard() 호출할 때마다 카드 생성(new Card())
			num++;
			return new Card(num);
		}
		
	
		// 카드 번호 관리를 카드자체가 하도록 할 것인가, 외사에서 관리할 것인가.
	
} // end class
