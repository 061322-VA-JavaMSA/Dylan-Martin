package com.revature.models;

import java.util.Scanner;

public class MainMenu {
	
	static Scanner scan;
	
	public static void mainStart() {
		
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
			ItemsMenu.startItemMenu();
		} else if (choice.equals("2")) {
			OwnedItems.startOwnedItems();
		} else if (choice.equals("3")) {
			PaymentsMenu.startPaymentsMenu();
		} else if (choice.equals("4")) {
			System.out.println("Goodbye! Please come again!");
		}
	}

}
