package com.revature.scanner;

// by default, everything in the java.lang package is imported
import java.util.Scanner;
//import java.util.*; // imports everything... but bad practice

public class ScannerDriver {

	// instead of being method scope, scan is now static scope
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Hello World!");
//		System.out.println("What is your name?");
//		
//		String name = scan.nextLine();
//		
//		System.out.println("Hello " + name + "!");
//		System.out.println("Please pick a number");
//		
//		//int num = scan.nextInt();
//		//scan.nextLine(); // flush leftover from the previous input capture
//		
//		String number1 = scan.nextLine();
//		// validation
//		int num = Integer.parseInt(number1);
//		
//		System.out.println("Your number is " + num);
//		System.out.println("Please pick a number from 1-2:");
//		String number = scan.nextLine();
//
//		
//		switch(number) {
//		case "1":
//			System.out.println("Hello");
//			break;
//		case "2":
//			System.out.println("Goodbye");
//			break;
//		default:
//			System.out.println("Not recognized");
//		}
		loginScreen();
		// make sure to close scanner at the end!
		scan.close();
	}

	/*
	 * A user is going to input a username and a password, if they match the hardcoded values return "welcome", otherwise "invalid credentials"
	 */
	public static void loginScreen() {
		String username = "admin";
		String password = "pass";
		
		System.out.println("Please enter your username");
		String usernameInput = scan.nextLine();
		System.out.println("Please enter your password");
		String passwordInput = scan.nextLine();
		
		if(username.equals(usernameInput) && password.equals(passwordInput)) {
			System.out.println("Welcome!");
		} else {
			System.out.println("Invalid credentials.");
		}
	}
	public static void menu() {
		/*
		 * Menu that gives a user multiple options:
		 * 	- 1: get a random number
		 *  - 2: reverse a String of the user's choice
		 *  - 3: exit the program
		 *  
		 *  this menu should repeat until the user decides to exit
		 */
		
		boolean run = true;
		while(run) {
			System.out.println("Please select an option:\n"
								+ "1: to retrieve a random number\n"
								+ "2: to reverse a word\n"
								+ "3: to exit the program");
			String input = scan.nextLine();
			switch(input) {
			case "1": 
				System.out.println("Here's a random number: " + Math.round(Math.random() * 100));
				break;
			case "2":
				System.out.println("Please enter a word:");
				StringBuffer sb = new StringBuffer(scan.nextLine());
				System.out.println("Here is your reversed word: " + sb.reverse());
				break;
			case "3":
				run = false;
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option.");
			}
			
		}
	}
}