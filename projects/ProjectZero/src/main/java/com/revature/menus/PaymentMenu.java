package com.revature.menus;

import java.util.Scanner;

import com.revature.services.AuthService;
import com.revature.services.UserService;

public class PaymentMenu extends IMenu {
	
	public PaymentMenu(UserService us) {
		super(us);
	}

	static AuthService as;
	static Scanner scan;

	public void startPaymentsMenu() {

		scan = new Scanner(System.in);

		System.out.println("Welcome to the payments menu.");
		System.out.println();
		System.out.println("You are payed in full and have no upcoming payments!");
		System.out.println();
		System.out.println("Please enter 1 to return to the Main Menu.");
		System.out.println();
		String back = "";
		back = scan.nextLine();
		if (back.equals("1")) {
			MainMenu mainMenu = new MainMenu(us);
			mainMenu.mainStart();
		}

	}
}
