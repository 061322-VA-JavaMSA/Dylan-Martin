package com.revature;

import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.DivideBy0Exception;

public class Calculator {
	/*
	 * - add(int a, int b)
	 * 		- if the result is 13
	 * 			- throw an exception
	 * 				- Number13Exception
	 * - subtract
	 * - multiply
	 * - sum of an array
	 * - divide
	 * 		- throw a custom exception if divided by 0
	 */
	
	public int add(int a, int b) {
		return(a + b);
	}
	
	public int subtract(int a, int b) {
		return 0;
	}
	
	public int sumOfAnArray(int[] intArr) {
		return 0;
	}
}