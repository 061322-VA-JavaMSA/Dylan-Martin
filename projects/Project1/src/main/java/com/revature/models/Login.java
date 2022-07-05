package com.revature.models;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.menus.EmployeeMainMenu;
import com.revature.services.AuthService;
import com.revature.services.ERS_UserService;

public class Login {
	
	static Scanner scan;
	
	public static Logger log = LogManager.getLogger(Login.class);
	
	AuthService as;
	ERS_UserService us;
	
	public void init(AuthService as, ERS_UserService us) {
		this.as = as;
		this.us = us;
	}
	
	public void userLogin() {
		scan = new Scanner(System.in);
		
		String ers_username = null;
		String ers_password = null;
		
		boolean loginOk = true;
		
		do {
			loginOk = true;
			System.out.println("Please enter you username: ");
			ers_username = scan.nextLine();
			System.out.println("Please enter your password: ");
			ers_password = scan.nextLine();	
			System.out.println("Login Successful");
			
			try {
				ERS_User currentUser = as.login(ers_username, ers_password);
				ERS_UserService.setCurrentUser(currentUser);
			} catch (LoginException e) {
				System.out.println("Invalid credentials, please try again.");
				log.error("Login exception was thrown: " + e.fillInStackTrace());
				loginOk = false;
			}
		} while (!loginOk);
		
		EmployeeMainMenu employeeMenu = new EmployeeMainMenu(us);
		employeeMenu.employeeMenu();
		scan.close();
	}
}
