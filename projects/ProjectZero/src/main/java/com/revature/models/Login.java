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
	
	public static Logger log = LogManager.getLogger(Login.class);	
	
	AuthService as;
	UserService us;
	
	public void init(AuthService as, UserService us) { 
		this.as = as;
		this.us = us;
	}
	
	public void userLogin() {
		
		scan = new Scanner(System.in);
		
		String username = null;
		String password = null;
		
		do {
			System.out.println("Please enter username:");
			username = scan.nextLine();
			System.out.println("Please enter password:");
			password = scan.nextLine();
		
			try {
				User currentUser = as.login(username, password);
				us.setCurrentUser(currentUser);
			} catch (LoginException e) {
				System.out.println("Invalid credentials, please try again.");
				log.error("Login exception was thrown: " + e.fillInStackTrace());
//				e.printStackTrace();					
			}					
		
		} while ((username != username) || (password != password));
		
		MainMenu mainMenu = new MainMenu(us);
		mainMenu.mainStart();
		scan.close();
	} 

}
