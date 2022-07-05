package com.revature.menus;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ERS_User;
import com.revature.models.ERS_User_Role;
import com.revature.models.Login;
import com.revature.services.ERS_UserService;
import com.revature.services.ERS_User_RoleService;

public class EmployeeSignUp {
	
	static Scanner scan;
	static ERS_User_RoleService urs;
	static ERS_UserService us;
	
	public static Logger log = LogManager.getLogger(EmployeeSignUp.class);
	
	public void eSignUp() {
		
		scan = new Scanner(System.in);
		urs = new ERS_User_RoleService();
		us = new ERS_UserService();

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
		userTBC.setErs_username(uname);
		userTBC.setErs_password(pass);
		log.info(us.createUser(userTBC));
		ERS_User_Role roleTBC = new ERS_User_Role();
		roleTBC.setUser_role("employee");
		log.info(urs.createRole(roleTBC));

		System.out.println("Hello, " + fname + " thank you for creating an account, " + "\n\nPlease sign in.");
		System.out.println();

		Login login = new Login();
		login.userLogin();
	}
		
}
