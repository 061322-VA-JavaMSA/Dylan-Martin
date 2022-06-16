package com.revature.oop.models;

import java.time.LocalDate;

public class Task {

	public String description;
	public boolean completed;
	public LocalDate dueDate;

	public Task() {
		dueDate = LocalDate.now().plusDays(5);
		description = "None provided";
	}

	public Task(String description) {
		this(); // example of constructor chaining, this one invokes the no-args constructor
				// before executing the constructor's logic
		this.description = description;
	}

}
