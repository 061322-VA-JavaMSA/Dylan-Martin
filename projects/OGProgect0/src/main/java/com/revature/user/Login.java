package com.revature.user;

import java.util.Scanner;

public class Login extends NewUser {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		loginScreen();
		
		//menu()
	}

	public static void loginScreen() {

		String inputUser;
		String inputPass;
		boolean correct = false;

		do {
			System.out.println("Login to Dylan's PC Hardware Store");
			System.out.println();
			System.out.println("Please enter your username: ");
			inputUser = scan.nextLine();
			System.out.println("Please ener your password: ");
			inputPass = scan.nextLine();

				if (inputUser.equals(getUserName()) && inputPass.equals(getPassWord())) {
					correct = true;
				} else {
					System.out.println("Invalid credentials, Please try again.");
					correct = false;
				}
		} while (correct == false);
	}

}
 