package com.lec.java.collection03studenttypearraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator

		
		ArrayList<Student> list = new ArrayList<Student>();  // 학생 정보를 담을 리스트 생성
		
//		for(int i = 0; i < 3; i++) {
//			Scanner sc = new Scanner(System.in);
//			int kor = sc.nextInt();
//			System.out.println("국어점수 : " + kor);
//			int math = sc.nextInt();
//			System.out.println("수학점수 : " + math);
//			int eng = sc.nextInt();
//			System.out.println("영어점수 : " + eng);
//			
//			Score s = new Score(kor, eng, math);  //  점수 입력 받음
//			
//			int id = sc.nextInt();
//			sc.nextLine();
//			String name = sc.nextLine();
//			Student stu = new Student(id, name, s);
//			
//			list.add(stu);
//			list.add(stu);
//			list.add(stu);
//	
//			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
//			}
//			
//			for(Student e : list) {
//				System.out.println(e);
//			}
//			
//			Iterator<Student> itr = list.iterator();
//			while(itr.hasNext()) {
//				System.out.println(itr.next());
//			}
//			sc.close();
//		}

		
		//------------------------------------------------------
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			System.out.println("id: ");
			System.out.println("name: ");
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("국어, 영어, 수학 : ");
			int kor = sc.nextInt(), eng = sc.nextInt(), math = sc.nextInt();
			
			Student stu = new Student(id, name, new Score(kor, eng, math));
			list.add(stu);
		}
		
		for(Student e : list) {
			System.out.println(e);
		}
		
		
		
		
		
		sc.close();
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









