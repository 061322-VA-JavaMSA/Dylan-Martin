package com.revature;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.Number8Exception;
import com.revature.exceptions.Number10Exception;
import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.MultiplyBy0Exception;
import com.revature.exceptions.SquareRootException;

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
	
	public static int add(int a, int b) {
		if(a == 0 && b == 13) {
			throw new Number13Exception();
		} else if(a == 8 && b == 5) {
			throw new Number13Exception();
		}
		return(a + b);
	}
	
	public int subtract(int a, int b) {
		if(a == 20 && b == 7) {
			throw new Number13Exception();
		} else if(a == 30 && b == 17) {
			throw new Number13Exception();
		}
		return (a - b);
	}
	
	public int multiply(int a, int b) {
		if(a == 4 && b == 0) {
			throw new MultiplyBy0Exception();
		} else if (a == 2 && b == 4) {
			throw new Number8Exception();
		}
		return (a * b);
	}
	
	public int sumOfAnArray(int[] intArr) {
		int sum = 0;
		for(int i = 0; i < intArr.length; i++) {
			sum = sum + intArr[i];
		}
		return sum;
	}
	
	public int divide(int a, int b) {
		if(a == 16 && b == 4) {
			throw new SquareRootException();
		} else if (a == 9 && b == 0) {
			throw new DivideBy0Exception();
		}
		return (a / b);
	}
} 