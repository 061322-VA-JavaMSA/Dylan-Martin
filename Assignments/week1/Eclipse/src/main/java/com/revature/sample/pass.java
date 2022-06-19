package com.revature.sample;

import java.util.Scanner;

public class pass {
	
	static Register r = new Register();
	
	public static void main(String[] args) {
		
		try(Scanner s = new Scanner(System.in)) {
			System.out.println("Create username: ");
			String username = s.nextLine();
			r.setUserName(username);
			
			System.out.println("Create password: ");
			String password = s.nextLine();
			r.setPassWord(password);
			
			System.out.println(r.toString());
		}
	}

}

class Register {
	private String username;
	private String password;
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassWord() {
		return password;
	}
	
	public void setPassWord(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Register [username = " + "'" + username + "'" + " & password = " + "'" + password + "']";
	}
}
