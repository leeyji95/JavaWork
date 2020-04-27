package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		ArrayList<MemberModel> list = new ArrayList<MemberModel>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			System.out.println("id: ");
			System.out.println("pw: ");
			String id = sc.nextLine();
			String pw = sc.nextLine();
			
			
			// 멤버모델 타입 인스턴스 만들어서 리스트에 추가 
			MemberModel memb = new MemberModel(id, pw);
			list.add(memb);
		}
		
		
		for(MemberModel e : list) {
//			memb.displayInfo()     --->  나는 계속 이렇게 하려고 헀음....   근데 e 자체가 멤버모델 타입이니까. 그걸로 접근해서 displayInfo() 호출하면 됨.
			e.displayInfo();
		}
		
		
		Iterator<MemberModel> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();   // itr.next() 이거 자체가 membermodel 타입으로 리턴되므로, 그거 쩜 displayInfo() 하면 됨. 꼭 인스턴스 쩜 접근 하지 않아도, 그 타입 리턴되는 값으로 접근해도 오케이 .
		}
		
		
		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












