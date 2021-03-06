package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Login;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class Driver {

	static Scanner scan;
	static AuthService as;
	static UserService us;

	private static Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
		String choice = "";
		System.out.println("Welcome to Dylan's PC Hardware!");
			System.out.println();
			System.out.println("Do you have an account with us?");
			System.out.println("Please select an option:"
					+ "\n1: yes, 2: no 3: Exit");
			choice = scan.nextLine();
			if (choice.equals("1")) {
				Login.userLogin();	
				
			} else if (choice.equals("2")) {
				System.out.println("What is your first name?");
				String fname = scan.nextLine();
				System.out.println("What is your last name?");
				String lname = scan.nextLine();
				System.out.println("Create, username:");
				String uname = scan.nextLine();
				System.out.println("Create, password:");
				String pass = scan.nextLine();
				User userTBC = new User();
				userTBC.setFirstName(fname);
				userTBC.setLastName(lname);
				userTBC.setUsername(uname);
				userTBC.setPassword(pass);
				log.info(us.createUser(userTBC));
				
				Login.userLogin();
				
			} else if (choice.equals("3")) {
				System.out.println("Goodbye! Please come again!");
			}

		scan.close();
	}

}