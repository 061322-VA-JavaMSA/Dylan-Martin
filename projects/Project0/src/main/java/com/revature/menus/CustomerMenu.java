package com.revature.menus;

import java.util.Scanner;

public class CustomerMenu {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		CustomerMenu();
		
	}
	
	public static void CustomerMenu() {
		
		System.out.println("Welcome to the Main Menu!");
		String choice = "";
		
		do {			
			System.out.println("1: View items for sale");
			System.out.println("2: View your owned items");
			System.out.println("3: View your upcoming payments");
			System.out.println("4: Exit");
			
			choice = scan.nextLine();
			switch(choice) {
			
			case "1":
				System.out.println("Item Menu");
				System.out.println();
				break;
				
			case "2":
				System.out.println("Your Items");
				System.out.println();
				break;
				
			case "3":
				System.out.println("Your upcoming payments");
				System.out.println();
				break;
				
			case "4":
				System.out.println("Goodbye!");
				System.out.println();
				break;
				
			default:
				System.out.println("Invalid selection, please select a listed option");
				System.out.println();
				break;
				
			}
		} while(!choice.equals("4"));
		
		scan.close();
	}

}
