package com.revature.user;

import java.util.Objects;
import java.util.Scanner;

public abstract class Registration {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	public final Registration user = new User();
	
	Scanner scan = new Scanner(System.in);
	
	public Registration() {
		
		System.out.println("What is your first name?");
		String firstName = scan.nextLine();
		user.setFirstName(firstName);
		
		System.out.println("What is your last Name? ");
		String lastName = scan.nextLine();
		user.setLastName(lastName);
		
		System.out.println("Choose a username: ");
		String userName = scan.nextLine();
		user.setUserName(userName);
		
		System.out.println("Create a password: ");
		String passWord = scan.nextLine();
		user.setPassWord(passWord);
	}
}
