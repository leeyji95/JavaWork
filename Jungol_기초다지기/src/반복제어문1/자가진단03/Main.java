package 반복제어문1.자가진단03;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
          
         while(true) {
             int num = sc.nextInt();
              
             if(num > 0) {
                 System.out.println("number?");
                 System.out.println("positive integer");
             } else if(num < 0) {
                 System.out.println("number?");
                 System.out.println("negative number");
             } else if(num == 0) {
                 System.out.println("number?");
                 break;
             }
              
         }
         
         
        sc.close();
    }
 
}