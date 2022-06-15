package com.revature;

import java.util.Arrays;

public class HelloWorld { //class should use caps at start as well as each word
	
	public static void main(String[] args) {
		
		System.out.println("Hello from Eclipse!");
		
		boolean bool = true; //this boolean has 1bit of memory
		byte myByte = 127; //8bits (-128 to 127)
//		myByte = 128;
		short myShort = 128; //16bits or 2 bytes
		char myChar = 'a'; //also 16bits of memory
		
		int standardDataTypeForWholeNumber = 12345; // 32 bits
		float lessPreciseDouble = 92.3f; //32 bits
		
		double standardDecimal = 20.45; //64 bits
		long bigNumber = 16256375L; //64bits
		
//casting
		
		//implicit/auto
		byte a = 2;
		int b = a;
		
		//explicit
		double d = 35.5;
		float f = (float)d;
		
		//s and s2 are a reference type that references the String in the heap
		String s = "Hello";
		String s2 = new String("World");
		
//Wrapper classes
		
		Integer intWrap = new Integer(standardDataTypeForWholeNumber);
		//Integer intWrap = standardDataTypeForWholeNumber;
		
		//converts string "5" to int 5
		int i = Integer.parseInt("5");
		
		System.out.println("Max value for int: " + Integer.MAX_VALUE + ", min value for int: " + Integer.MIN_VALUE);
		
		//declaring an array
		int[] numbers;
		
		//creates an array of size 5 and assign it to the variable numbers
		numbers = new int[5];
		
		numbers[0] = 2;
		numbers[3] = 4;
		
		System.out.println(numbers[0]);
		
		for(int j = 0; j < numbers.length; j++) {
			System.out.println(numbers[j]);
		}
		// enhanced for-loop, however we don't have access to the index
		Arrays.sort(numbers);
		
		for(int in : numbers) {
			System.out.println(in);
		}
		
		String k = "kevin";
		char[] chars = k.toCharArray();
		
		for(char c : chars) {
			System.out.println(c);
		}
	}

}
