package com.revature.menus;

import java.util.Scanner;

public class EmployeeMenu {
	
	static Scanner scan;
	
	public static void employeeMenu() {
		scan = new Scanner(System.in);
		
		String choice = "";
		
		System.out.println("Welcome to the employee menu");
		System.out.println();
		System.out.println("Please select and option:");
		System.out.println("1: View the employee items menu");
		System.out.println("2: View all offers");
		System.out.println("3: View all payments");
		System.out.println("4: Exit");
		
		choice = scan.nextLine();
		
		if (choice.equals("1")) {
			EItemMenu.eItemMenu();
		} else if (choice.equals("2")) {
			EOfferMenu.eOfferMenu();
		} else if (choice.equals("3")) {
			EPaymentMenu.ePaymentMenu();
		} else if (choice.equals("4")) {
			System.out.println("See you later.");
		}
	}

}
