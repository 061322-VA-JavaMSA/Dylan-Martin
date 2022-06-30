package com.revature.menus;

import java.util.Scanner;

import com.revature.services.UserService;

public class EPaymentMenu extends IMenu{
	
public EPaymentMenu(UserService us) {
		super(us);
		// TODO Auto-generated constructor stub
	}
	static Scanner scan;
	
	public void ePaymentMenu() {

		scan = new Scanner(System.in);

		System.out.println("Welcome to the payments menu.");
		System.out.println();
		System.out.println("Split payments will be an exciting new feature that is still a work in progress. Please stay tuned!");
		System.out.println();
		System.out.println("Please enter 1 to return to the Main Menu.");
		System.out.println();
		String back = "";
		back = scan.nextLine();
		if (back.equals("1")) {
			MainMenu mainMenu = new MainMenu(us);
			mainMenu.mainStart();
			scan.close();
		}
		
	}


}
