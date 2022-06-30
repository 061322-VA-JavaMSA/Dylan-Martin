package com.revature.menus;

import java.util.Scanner;

import com.revature.models.OwnedItems;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class MainMenu extends IMenu {
	
	public MainMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}

	static AuthService as;
	static Scanner scan;
	
	public void mainStart() {
		
		
		
		scan = new Scanner(System.in);
		
		String choice = "";
		
		System.out.println("Welcome to the main menu!");
		System.out.println();
		System.out.println("Please select and option:");
		System.out.println("1: View the Items for sale menu");
		System.out.println("2: View the Items you own");
		System.out.println("3: View your payments to make");
		System.out.println("4: Exit");
		
		choice = scan.nextLine();
		
		if (choice.equals("1")) {
			ItemMenu itemMenu = new ItemMenu(us);
			itemMenu.startItemMenu();
		} else if (choice.equals("2")) {
			OwnedMenu ownedMenu = new OwnedMenu(us);
			ownedMenu.startOwnedItems();
		} else if (choice.equals("3")) {
			PaymentMenu paymentMenu = new PaymentMenu(us);
			paymentMenu.startPaymentsMenu();
		} else if (choice.equals("4")) {
			System.out.println("Goodbye! Please come again!");
		}
	}

}
