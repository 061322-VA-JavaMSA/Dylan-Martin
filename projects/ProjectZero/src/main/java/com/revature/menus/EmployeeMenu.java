package com.revature.menus;

import java.util.Scanner;

import com.revature.services.UserService;

public class EmployeeMenu extends IMenu {
	
	public EmployeeMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static Scanner scan;
	
	@SuppressWarnings("static-access")
	public void employeeMenu() {
		scan = new Scanner(System.in);
		
		String choice = "";
		
		System.out.println("Welcome to the employee menu");
		System.out.println();
		System.out.println("Please select and option:");
		System.out.println("1: View the employee items menu");
		System.out.println("2: View item offers");
		System.out.println("3: View all payments");
		System.out.println("4: Exit");
		
		choice = scan.nextLine();
		
		if (choice.equals("1")) {
			EItemMenu eItemMenu = new EItemMenu(us);
			eItemMenu.eItemMenu();
		} else if (choice.equals("2")) {
			EOfferMenu eOfferMenu = new EOfferMenu(us);
			eOfferMenu.eOfferMenu();
		} else if (choice.equals("3")) {
			EPaymentMenu ePaymentMenu = new EPaymentMenu(us);
			ePaymentMenu.ePaymentMenu();
		} else if (choice.equals("4")) {
			System.out.println("See you later.");
		}
	}

}
