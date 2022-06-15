package com.revature.scanner;

import java.util.Scanner;

public class menu {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome!");
		
		System.out.println("Inputting 1 will give you a random number");
		
		System.out.println("Inputting 2 will ask you to enter a word or phrase");
		
		System.out.println("Inputting 3 will close the program");
		
		System.out.println("Please select an option...");
		
		int string = scan.nextInt();
		
		if(string.equals(1)) {
			string rand = (string)(Math.random()*Integer.parseInt(args[0])) + 5;
			System.out.println(rand);
		}
			

	}

}
