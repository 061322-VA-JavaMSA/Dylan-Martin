package com.revature.models;

import java.util.Objects;

public class ERS_User_Role {
	
	private int ers_user_role_id;
	private String user_role;
	
	public ERS_User_Role() {
		super();
	}
	
	public int getId() {
		return ers_user_role_id;
	}
	
	public void setId(int ers_user_role_id) {
		this.ers_user_role_id = ers_user_role_id;
	}
	
	public String getRole() {
		return user_role;
	}
	
	public void setRole(String r) {
		this.user_role = r;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ers_user_role_id, user_role);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERS_User_Role other = (ERS_User_Role) obj;
		return ers_user_role_id == other.ers_user_role_id && Objects.equals(user_role, other.user_role);
	}
	
	@Override
	public String toString() {
		return "ERS User Role [id= " + ers_user_role_id + ", user role= " + user_role + "]";
	}
}
