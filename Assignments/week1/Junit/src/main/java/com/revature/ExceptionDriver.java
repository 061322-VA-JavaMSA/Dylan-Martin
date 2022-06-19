package com.revature;

public class ExceptionDriver {

	public static void main(String[] args) throws Exception{

		System.out.println("Beginning of Exception Handling");

		try {// risky code that is at risk of throwing an exception
			throw new Exception();// checked exceptions have to be handled for the compiler to allow compilation.
		} catch (Exception Number13Exception) {
			System.out.println("The sum cannot be 13!");
			//Number13Exception.printStackTrace();
		} catch (Exception LessThan0Exception) {
			System.out.println("The Difference cannot be less than 0!");
			//LessThan0Exception.printStackTrace();
		} catch (Exception MultiplyExeption) {
			System.out.println("Please don't multiply thos numbers");
			//MultiplyExeption.printStackTrace();
		} catch (Exception IncorrectSum) {
			System.out.println("IncorrectSum exception has been thrown");
			//IncorrectSum.printStackTrace();
		} catch (Exception DivideByZeroException) {
			System.out.println("Nothing may be divided by 0");
			//DivideByZeroException.printStackTrace();
		}

		System.out.println("End of Exception Handling!.");
	}
}