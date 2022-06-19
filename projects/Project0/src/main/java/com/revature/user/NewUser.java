package com.revature.user;

import java.util.Objects;
import java.util.Scanner;

public class NewUser{
	
	public static String firstName = null;
	public static String lastName = null;
	public static String userName = null;
	public static String passWord = null;
	public static NewUser nu = new NewUser();
	
	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)){
			
			System.out.println("Enter your first name: ");
			String firstName = scan.nextLine();
			nu.setFirstName(firstName);
			
			System.out.println("Enter your last name: ");
			String lastName = scan.nextLine();
			nu.setLastName(lastName);
			
			System.out.println("Choose a username: ");
			String userName = scan.nextLine();
			nu.setUserName(userName);
			
			System.out.println("Create a password: ");
			String passWord = scan.nextLine();
			nu.setPassWord(passWord);
			
			scan.close();
			
			System.out.println(nu.toString());
		}
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		NewUser.firstName = firstName;
	}
	public String getLastName() {
		return lastName ;
	}
	public void setLastName(String lastName) {
		NewUser.lastName = lastName;
	}
	public static String getUserName() {
		return userName ;
	}
	public void setUserName(String userName) {
		NewUser.userName = userName;
	}
	public static String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		NewUser.passWord = passWord;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, userName, passWord);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return Objects.equals(firstName, NewUser.firstName)
				&& Objects.equals(lastName, NewUser.lastName) && Objects.equals(userName, NewUser.userName)
				&& Objects.equals(passWord, NewUser.passWord);
	}

	@Override
	public String toString() {
		return "New User Registerd: [First Name = " + firstName + ", Last Name = " + lastName
				+ ", Username = " + userName + ", Password = " + passWord + "]";
	}//fine tune this later to have the console print **** instead of pass, even better if i can get it t
	//hide the chars as they're entered to enter in as ****.
	
}