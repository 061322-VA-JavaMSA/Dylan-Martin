package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Role;
import com.revature.models.User;

/*-
 * Data Transfer Objects
 */
public class UserDTO {

	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private Role role;

	public UserDTO() {
		super();
	}

	public UserDTO(User u) {
		id = u.getId();
		firstname = u.getFirstname();
		lastname = u.getLastname();
		username = u.getUsername();
		email = u.getEmail();
		role = u.getRole();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && role == other.role
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", email=" + email + ", role=" + role + "]";
	}
}