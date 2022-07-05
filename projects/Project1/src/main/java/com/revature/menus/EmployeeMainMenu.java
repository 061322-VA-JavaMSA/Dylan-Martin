package com.revature.menus;

import java.util.Scanner;

import com.revature.services.AuthService;
import com.revature.services.ERS_UserService;

public class EmployeeMainMenu extends IMenu {

	public EmployeeMainMenu(ERS_UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}
	
	static AuthService as;
	static Scanner scan;
	
	public void employeeMenu() {
		
		scan = new Scanner(System.in);
		
		System.out.println("Welcome to the employee menu");
	}
}
