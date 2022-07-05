package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menus.EmployeeSignUp;
import com.revature.menus.ManagerSignUp;
import com.revature.models.ERS_User;
import com.revature.models.ERS_User_Role;
import com.revature.models.Login;
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

		// Login and track role associated with login credentials
		// or sign up and set credential link to role

		String lors = "";

		System.out.println("Login (l) or Sign-Up (s)");
		lors = scan.nextLine();

		if (lors.equals("l")) {

//			should probably make a separate login class in models like in p0

			Login login = new Login();
			login.userLogin();

		} else if (lors.equals("s")) {
			System.out.println("Are you an employee or manager?");
			String eorm = scan.nextLine();
			
			if(eorm.equals("employee")) {
				
				EmployeeSignUp employeeSignUp = new EmployeeSignUp();
				employeeSignUp.eSignUp();
				
			} else if (eorm.equals("manager")) {
				
				ManagerSignUp managerSignUp = new ManagerSignUp();
				managerSignUp.mSignUp();
				
			}
			
		}
		scan.close();
	}
}
