package com.revature.models;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.menus.MainMenu;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class Login {
	
	static Scanner scan;
	static AuthService as;
	static UserService us;
	
	public static Logger log = LogManager.getLogger(Login.class);
	
	public static void userLogin() {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
		String username = null;
		String password = null;
		
		do {
			System.out.println("Please enter username:");
			username = scan.nextLine();
			System.out.println("Please enter password:");
			password = scan.nextLine();
		
			try {
				log.info(as.login(username, password));
			} catch (LoginException e) {
				System.out.println("Invalid credentials, please try again.");
				log.error("Login exception was thrown: " + e.fillInStackTrace());
//				e.printStackTrace();					
			}					
		
		} while ((username != username) || (password != password));
		MainMenu.mainStart();
		scan.close();
	} 

}
