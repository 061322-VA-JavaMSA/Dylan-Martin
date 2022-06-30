package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menus.EmployeeMenu;
import com.revature.menus.IMenu;
import com.revature.services.AuthService;
import com.revature.services.EmployeeService;
import com.revature.services.UserService;

public class EmployeeDriver {

	static Scanner scan;
	static AuthService as;
	static EmployeeService es;
	static UserService us;
	
	public static Logger log = LogManager.getLogger(EmployeeDriver.class);

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		es = new EmployeeService();
		us = new UserService();
		
		String e_name = null;
		String e_pass = null;
		boolean loginOk = true;
		do {
			loginOk = true;
			System.out.println("Please enter employee name:");
			e_name = scan.nextLine();
			System.out.println("Please enter employee password:");
			e_pass = scan.nextLine();
			
			try {
				log.info(as.elogin(e_name, e_pass));
			} catch (com.revature.exceptions.LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				loginOk = false;
			}
		} while (!loginOk);
		EmployeeMenu employeeMenu = new EmployeeMenu(us);
		employeeMenu.employeeMenu();
		
		scan.close();
	}

}
