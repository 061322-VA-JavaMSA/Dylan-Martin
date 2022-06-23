package com.revature.user;

import java.util.Objects;

import com.revature.user.NewUserRegistration;

public class NewUserRegistration {
	
	//recreate this project from scratch and copy and paste everything over when finished
	

	private int userId; // unique identifier for storing user data
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;

	public NewUserRegistration() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String userName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, firstName, lastName, userName, passWord);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserRegistration other = (NewUserRegistration) obj;
		return userId == other.userId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(userName, other.userName)
				&& Objects.equals(passWord, other.passWord);
	}

	@Override
	public String toString() {
		return "New User Registerd: [UserId = " + userId + ", First Name = " + firstName + ", Last Name = " + lastName
				+ ", Username = " + userName + ", Password = " + passWord + "]";
		// Maybe try to have this return ***** that match the length of the password
		// entered above
	}
}
