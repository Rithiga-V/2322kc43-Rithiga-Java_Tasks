package Task4;

import java.util.Scanner;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        
        
        System.out.print("Enter marks for Subject 1: ");
        int m1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter marks for Subject 2: ");
        int m2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter marks for Subject 3: ");
        int m3 = sc.nextInt();
       sc.nextLine();

sc.nextLine();
 
 String result;
 if(m1>=35 && m2>=35 && m3>=35){
     result="pass";
 }
 else{
     result="fail";
 }
System.out.println("STUDENT MANAGEMENT SYSTEM");
System.out.println("________________________________");
System.out.println("Name:"+name);
System.out.println("RollNo:"+roll);
System.out.println("Mark for subject 1:"+m1);
System.out.println("Mark for subject 2:"+m2);
System.out.println("Mark for subject 3:"+m3);
System.out.println("result:"+result);

         
    }
}
