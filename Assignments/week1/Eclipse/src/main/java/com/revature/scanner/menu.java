package com.revature.scanner;

import java.util.Scanner;
import java.io.IOException;

public class menu {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		loginScreen();

		menu();

	}

	public static void loginScreen() {
		String username = "admin";
		String password = "pass";

		String inputUser;
		String inputPass;
		boolean correct = false;
		do {
			System.out.println("Please enter your username: ");
			inputUser = scan.nextLine();
			System.out.println("Please enter your password: ");
			inputPass = scan.nextLine();

			if (inputUser.equals(username) && inputPass.equals(password)) {
				correct = true;
			} else {
				System.out.println("Invalid username or password, please try again");
				correct = false;
			}

		} while (correct == false);

	}

	public static void menu() {
		System.out.println("Welcome to the Menu!");
		String choice = "";
		do {

			System.out.println("1: Print a random number");
			System.out.println("2: Reverse a string");
			System.out.println("3: Exit");
			System.out.println("Please select an option");
			choice = scan.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Your Random number is: " + (int) (Math.random() * 500));
				System.out.println();
				break;
			case "2":
				String toBeReversed;
				System.out.println("Please enter a string to be reversed");
				toBeReversed = scan.nextLine();
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

		scan.close();
	}

}
