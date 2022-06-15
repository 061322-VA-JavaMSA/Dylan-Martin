package com.revature.scopes;

public Calculator {
	
	// [access modifier] [non-access modifiers] [returnType] [name] ([params if any]){}
	// Reverse a string, take in a string and return a reversed String
	public String reverseString(String stringToBeReversed) {
		//boa => aob
		//kevin => nivek
		String reversed = "";
		
		char[] letters = stringToBeReversed.toCharArray();
		
		for(int i = letters.length-1; i >= 0; i--) {
			String reverse = reversed + letters[i];
		}
			
			
		return reversed;
	}
}


