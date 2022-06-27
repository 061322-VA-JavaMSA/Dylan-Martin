package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Login;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.CustomerService;
import com.revature.services.UserService;

public class Driver {

	static Scanner scan;
	static AuthService as;
	static UserService us;
	static CustomerService cs;

	private static Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		cs = new CustomerService();
		
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
				System.out.println("Create, username:");
				String uname = scan.nextLine();
				System.out.println("Create, password:");
				String pass = scan.nextLine();
				User userTBC = new User();
				userTBC.setUsername(uname);
				userTBC.setPassword(pass);
				log.info(us.createUser(userTBC));
				System.out.println("What is your first name?");
				String fname = scan.nextLine();
				System.out.println("What is your last name?");
				String lname = scan.nextLine();
				Customer customerTBC = new Customer();
				customerTBC.setFirstName(fname);
				customerTBC.setLastName(lname);
				log.info(cs.createCustomer(customerTBC));
				
				System.out.println();
				System.out.println("Hello, " + fname + " thank you for creating an account, "
						+ "\n\nPlease sign in.");
				System.out.println();
				
				Login.userLogin();
				
			} else if (choice.equals("3")) {
				System.out.println("Goodbye! Please come again!");
			}

		scan.close();
	}

}