package com.revature.models;

import java.util.Objects;

/*
 * fields private
 * created a no-args constructor
 * generated setters/getters to interact with private fields
 * generate hashcode/equals - to compare User objects
 * generate toString()
 */
public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstname, lastname, username, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname) && Objects.equals(username, other.username) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + "]";
	}
	
}