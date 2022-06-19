package com.revature;

import com.revature.Exceptions.*;

public class CalculatorExceptions {
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
			if (a == 8 && b == 5) {
				throw new Number13Exception();
			}
			return a + b;
		}

		public int subtract(int a, int b) {
			if (a == 12 && b == 25) {
				throw new LessThan0Exception();
			}
			return a - b;
		}

		public int multiply(int a, int b) {
			if (a == 5 && b == 6) {
				throw new MultiplyException();
			}
			return a * b;
		}

		/*public int sumOfAnArray(int[] intArr) {
			int[a];
			int[b];			
			
			if(a : 12 && b : 13) {
				
			}
		}*/
	}

		public int divide(int a, int b) {
			if (a == 13 && b == 0) {
				throw new DivideBy0Exception();
		}
		return a / b;
	}

}
