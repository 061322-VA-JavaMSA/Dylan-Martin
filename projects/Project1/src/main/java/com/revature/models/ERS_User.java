package com.revature.models;

import java.util.Objects;

public class ERS_User {
	
	private int ers_user_id;
	private String ers_firstname;
	private String ers_lastname;
	private String ers_username;
	private String ers_password;
	private String ers_email;
	
	public ERS_User(){
		super();
	}

	public int getErs_user_id() {
		return ers_user_id;
	}

	public void setErs_user_id(int ers_user_id) {
		this.ers_user_id = ers_user_id;
	}

	public String getErs_firstname() {
		return ers_firstname;
	}

	public void setErs_firstname(String ers_firstname) {
		this.ers_firstname = ers_firstname;
	}

	public String getErs_lastname() {
		return ers_lastname;
	}

	public void setErs_lastname(String ers_lastname) {
		this.ers_lastname = ers_lastname;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getErs_email() {
		return ers_email;
	}

	public void setErs_email(String ers_email) {
		this.ers_email = ers_email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ers_email, ers_firstname, ers_lastname, ers_password, ers_user_id, ers_username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERS_User other = (ERS_User) obj;
		return Objects.equals(ers_email, other.ers_email) && Objects.equals(ers_firstname, other.ers_firstname)
				&& Objects.equals(ers_lastname, other.ers_lastname) && Objects.equals(ers_password, other.ers_password)
				&& ers_user_id == other.ers_user_id && Objects.equals(ers_username, other.ers_username);
	}

	@Override
	public String toString() {
		return "ERS_User [ers_user_id=" + ers_user_id + ", ers_firstname=" + ers_firstname + ", ers_lastname="
				+ ers_lastname + ", ers_username=" + ers_username + ", ers_password=" + ers_password + ", ers_email="
				+ ers_email + "]";
	}
	
}