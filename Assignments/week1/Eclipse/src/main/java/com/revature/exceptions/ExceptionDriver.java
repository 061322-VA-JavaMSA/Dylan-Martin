package com.revature.exceptions;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.exceptions.exceptions.UserNotFoundException;

public class ExceptionDriver {

	public static void main(String[] args) {
		System.out.println("Beginning of the main method.");
		int a = 1;
		int b = 0;
		if (b != 0) { 
			System.out.println(a / b); // Example of an arithmetic exception, unchecked, can be avoided using a 0 check
		}
		
		int[] intArr = new int[3];
//		for(int i = 0; i < 10; i++) { <== results in IOOB Exception, could be prevented by writing better code
		for(int i = 0; i < intArr.length; i++) {
			System.out.println(intArr[i]);
		}
		
		
		try (Scanner sc = new Scanner(System.in);){
			System.out.println("Beginning of try.");
			ExceptionDriver.maybeException(); // risky code
//			System.exit(0); way to skip finally block 
			System.out.println("End of try.");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException was caught and handled!");
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("Exception was caught and handled!");
			e.printStackTrace();
		} finally {
//			sc.close();
			System.out.println("Finally always executes... almost...");
		}
		
//		OutOfMemoryError, do not try to handle
//		List<Integer> al = new ArrayList<>();
//		
//		for(int i = 0; i < 10; i--) {
//			al.add(i);
//		}
		
		System.out.println("End of the main method.");
	}
	
	public static void maybeException() throws FileNotFoundException  {
		// Math.random, if result in >.5 throws an exception
		double fileExists = Math.random();
		
		if(fileExists > .5) {
			throw new FileNotFoundException(); // Checked exception have to be handled for the compiler to allow for compilation
		}
		
//		throw new UserNotFoundException();

	}
}