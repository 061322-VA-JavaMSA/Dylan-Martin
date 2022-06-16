package com.revature.oop;

import com.revature.oop.models.Task;

public class Driver {

	public static void main(String[] args) {
		Task t = new Task();

		System.out.println(t.dueDate);
		System.out.println(t.completed);
		System.out.println(t.description);

		System.out.println();

		Task t1 = new Task("Do laundry");

		System.out.println(t1.dueDate);
		System.out.println(t1.completed);
		System.out.println(t1.description);
		
		

	}

}
