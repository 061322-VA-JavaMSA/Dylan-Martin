package com.revature.models;

import java.util.Objects;

public class Employee {
	
	private int employee_id;
	private String e_name;
	private String e_pass;
	
	public Employee() {
		super();
	}
	
	public int getId() {
		return employee_id;
	}
	
	public void setId(int employee_id) {
		this.employee_id = employee_id;
	}
	
	public String getName() {
		return e_name;
	}
	public void setName(String e_name) {
		this.e_name = e_name;
	}
	public String getPass() {
		return e_pass;
	}
	public void setPass(String e_pass) {
		this.e_pass = e_pass;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employee_id, e_name, e_pass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employee_id == other.employee_id && Objects.equals(e_name, other.e_name) && Objects.equals(e_pass, other.e_pass);
	}
	@Override
	public String toString() {
		return "Task [id=" + employee_id + ", name=" + e_name + ", description=" + e_pass
				+  "]";
	}

}
