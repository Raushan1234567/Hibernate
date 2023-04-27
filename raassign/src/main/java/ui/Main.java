package ui;


import java.util.Scanner;



import Dao.imple;
import Dao.inter;
import DtoEntity.Student;
import Exception.SomethingWentWrongException;

public class Main {
	
public static void main(String[] args) throws ClassNotFoundException {
Scanner sc = new Scanner(System.in);
	
	int choice = -1;
	do {
		System.out.println("0. Exit");
		System.out.println("1. Add Student");
		System.out.println("2. View Student by Id");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.print("Enter Selection ");
		choice = sc.nextInt();
		switch(choice) {
			case 0:
				System.out.print("Thanks for using our services");
				break;
			case 1:
				addStudentUI(sc);
				break;
			case 2:
				viewStudentUI(sc);
				break;
			case 3:
				updateStudentUI(sc);
				break;
			case 4:
				deleteStudentUI(sc);
				break;
			default:
				System.out.print("Invalid Selection, try again");
		}
	}while(choice != 0);
	sc.close();
}

static void deleteStudentUI(Scanner sc) {
	// TODO Auto-generated method stub
	
}

private static void updateStudentUI(Scanner sc) throws ClassNotFoundException {
	
	System.out.print("Enter Student id");
	int id= sc.nextInt();
	System.out.print("Enter eamil");
	String title = sc.next();
	System.out.print("Enter adress");
	String author = sc.next();
	
	System.out.print("Enter course");
	String price = sc.next();
	System.out.print("Enter level");
	int level= sc.nextInt();

	
	inter b = new imple();
	try {
		b.updateStudent(id,title,author,price,level);
		System.out.println("Student updated successfully");
	} catch (SomethingWentWrongException |ClassNotFoundException e) {
		System.out.println(e);
	}
	
}

private static void viewStudentUI(Scanner sc) {
	// TODO Auto-generated method stub
	
}

static void addStudentUI(Scanner sc) {
	System.out.print("Enter eamil");
	String title = sc.next();
	System.out.print("Enter adress");
	String author = sc.next();
	
	System.out.print("Enter course");
	String price = sc.next();
	System.out.print("Enter level");
	int level= sc.nextInt();
	Student stu = new Student(title, author, price, level);
	
	inter b = new imple();
	try {
		b.addStudent(stu);
		System.out.println("Student added successfully");
	} catch (SomethingWentWrongException e) {
		System.out.println(e);
	}
}

}
