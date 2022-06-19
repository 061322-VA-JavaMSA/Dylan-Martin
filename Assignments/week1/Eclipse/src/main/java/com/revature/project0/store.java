package com.revature.project0;

import java.util.Scanner;

public class store {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		loginScreen();

		store();

	}

	public static void loginScreen() {
		String username = "admin";
		String password = "pass";

		String inputUser;
		String inputPass;
		boolean correct = false;
		do {
			System.out.println("Please enter your username: ");
			inputUser = s.nextLine();
			System.out.println("Please enter your password: ");
			inputPass = s.nextLine();

			if (inputUser.equals(username) && inputPass.equals(password)) {
				correct = true;
			} else {
				System.out.println("Invalid credentials, please try again");
				correct = false;
			}

		} while (correct == false);

	}
	
	public static void store() {
		System.out.println("Welcome to Dylan's PCHardware Store!");
		String choice = "";
		do {

			System.out.println("1: Print a random number");
			System.out.println("2: Reverse a string");
			System.out.println("3: Exit");
			System.out.println("Please select an option");
			choice = s.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Your Random number is: " + (int) (Math.random() * 500));
				System.out.println();
				break;
			case "2":
				String toBeReversed;
				System.out.println("Please enter a string to be reversed");
				toBeReversed = s.nextLine();
				StringBuilder sb = new StringBuilder(toBeReversed);
				System.out.println(sb.reverse());
				System.out.println();
				break;
			case "3":
				System.out.println("The Program has ended, goodbye!");
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
				break;
			}
		} while (!choice.equals("3"));

		s.close();
	}

}