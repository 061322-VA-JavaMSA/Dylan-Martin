package com.revature.oop.models;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Task {
	private int id;
	private String description;
	private boolean completed;
	private LocalDate dueDate;
	private User userAssigned;
	public final User finalUser = new User(); // in this case, final refers the the location of the object in the heap, tso the fields of that object can be changed
//	private int userIdAssigned; not the "OOP way"

	public Task() {
		//super() => to the Object class constructor
		dueDate = LocalDate.now().plusDays(5);
		description = "None provided";
	}

	public Task(String description) {
		this(); // example of constructor chaining, this one invokes the no-args constructor
				// before executing this constructor's logic
		this.description = description;
	}

	public void doTask() {
		System.out.println("Doing a task.");
	}
	
	public void doTask(String speed) {
		System.out.println("Doing task at " + speed + " speed.");
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		if (dueDate.isBefore(LocalDate.now())) {
			System.out.println("Date cannot be before now.");
		} else {
			this.dueDate = dueDate;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserAssigned() {
		return userAssigned;
	}

	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}

	@Override // annotation just provided information to the compiler
	public int hashCode() {
		return Objects.hash(completed, description, dueDate, id, userAssigned);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return completed == other.completed && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate) && id == other.id
				&& Objects.equals(userAssigned, other.userAssigned);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", completed=" + completed + ", dueDate=" + dueDate
				+ ", userAssigned=" + userAssigned + "]";
	}

	public Task(String description, User userAssigned) {
		super();
		this.description = description;
		this.userAssigned = userAssigned;
	}
	
//	private abstract void doesThisWork(); cannot make abstract method private
}