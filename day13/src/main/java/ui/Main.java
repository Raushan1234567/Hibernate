package ui;

import java.util.Scanner;

import dao.Implenter;
import dao.Inter;
import dto.Employee;
import exception.NorecordFoundException;
import exception.somethingwentwrong;

public class Main {
	private static void getaddressUI(Scanner sc) {
		System.out.println("enter name");
		int id = sc.nextInt();
		
		Inter empdao = new Implenter();
		String address;
		try {
			address = empdao.getAddressOfEmployee(id);
			System.out.println(address);
			
		} catch (somethingwentwrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NorecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addbonusUI(Scanner sc) {
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter bonus");
		double bonus = sc.nextDouble();
		Inter empdao = new Implenter();
		try {
			String res=empdao.giveBonusToEmployee(id, bonus);
			System.out.println(res);
			
		} catch (somethingwentwrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NorecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void deleteempUI(Scanner sc) {
		System.out.println("enter id");
		int id = sc.nextInt();
		Inter empdao = new Implenter();

		try {
			boolean res;
			try {
				res = empdao.deleteEmployee(id);
				System.out.println(res);
			} catch (NorecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (somethingwentwrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addempUI(Scanner sc) {

		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter address");
		String add = sc.next();
		System.out.println("enter slary");
		double slary = sc.nextDouble();

		Employee empp = new Employee(name, add, slary);

		Inter empdao = new Implenter();

		try {
			empdao.save(empp);
			System.out.println("added Succesfully");
		} catch (somethingwentwrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. add ");
			System.out.println("2. delete ");
			System.out.println("3. giveBonus");
			System.out.println("4. get address ");
			System.out.println("5. exit from system");
			System.out.println("chose your preferance");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addempUI(sc);
				break;
			case 2:
				deleteempUI(sc);
				break;
			case 3:
				addbonusUI(sc);
				break;
			case 4:
				getaddressUI(sc);
				break;

			case 5:
				System.out.println("thans you visit again");
				;
				break;
			default:
				System.out.println("invalid selection");

			}

		} while (choice != 0);
		sc.close();
	}
}
