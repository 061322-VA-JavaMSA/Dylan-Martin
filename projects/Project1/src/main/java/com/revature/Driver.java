package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.models.ERS_User;
import com.revature.models.ERS_User_Role;
import com.revature.services.AuthService;
import com.revature.services.ERS_UserService;
import com.revature.services.ERS_User_RoleService;

public class Driver {
	
	
	static Scanner scan;
	static AuthService as;
	static ERS_UserService us;
	static ERS_User_RoleService urs;
	
	public static Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new ERS_UserService();
		urs = new ERS_User_RoleService();
		
//		public init(AuthService as, ERS_UserService us) {
//			this.as = as;
//			this.us = us;
//		}

		String ers_username = null;
		String ers_password = null;		
		
		//Login and track role associated with login credentials
		//or sign up and set credential link to role
		
		String lors = "";
		
		System.out.println("Login (l) or Sign-Up (s)");
		lors = scan.nextLine();
		
		if (lors.equals("l")) {
			
//			should probably make a separate login class in models like in p0
			
			boolean loginOK = true;
			do {
				loginOK = true;
				System.out.println("Please enter you username: ");
				ers_username = scan.nextLine();
				System.out.println("Please enter your password: ");
				ers_password = scan.nextLine();	
				
				try {
					ERS_User currentUser = as.login(ers_username, ers_password);
					ERS_UserService.setCurrentUser(currentUser);
				} catch (LoginException e) {
					System.out.println("Invalid credentials, please try again.");
					log.error("Login exception was thrown: " + e.fillInStackTrace());
					loginOK = false;
				}
			} while (!loginOK);
			
		} else if (lors.equals("s")) {
			System.out.println("Are you an employee or manager?");
			String role = scan.nextLine();
			ERS_User_Role roleTBC = new ERS_User_Role();
			roleTBC.setRole(role);
			log.info(urs.createRole(roleTBC));
			System.out.println("What is your firstname?");
			String fname = scan.nextLine();
			System.out.println("What is your lastname?");
			String lname = scan.nextLine();
			System.out.println("What is your email?");
			String email = scan.nextLine();
			System.out.println("Create username:");
			String uname = scan.nextLine();
			System.out.println("Create password");
			String pass = scan.nextLine();
			ERS_User userTBC = new ERS_User();
			userTBC.setErs_firstname(fname);
			userTBC.setErs_lastname(lname);
			userTBC.setErs_email(email);
			userTBC.setErs_username(ers_username);
			userTBC.setErs_password(pass);
			log.info(us.createUser(userTBC));
			
			System.out.println("Hello, " + fname + " thank you for creating an account, "
					+ "\n\nPlease sign in.");			
		}
		
	}
}
