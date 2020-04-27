package 선택제어문.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String gender = sc.next(); // token  입력
		int age = sc.nextInt();
		
		switch(gender) {
		case "F":
			if(age >= 18) {
				System.out.println("WOMAN");
			} else {
				System.out.println("GIRL");
			}
			break;
		case "M":
			if(age >= 18) {
				System.out.println("MAN");
			} else {
				System.out.println("BOY");
			}
			break;
		}
		
		
		sc.close();

	}

}
