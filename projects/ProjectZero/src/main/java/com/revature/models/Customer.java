package com.revature.models;

import java.util.Objects;

public class Customer {
	
	private int customer_id;
	private String firstname;
	private String lastname;
	
	public Customer() {
		super();
	}
	
	public int getId() {
		return customer_id;
	}
	
	public void setId(int customer_id) {
		this.customer_id = customer_id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(customer_id);
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customer_id == other.customer_id;
	}
	
	@Override
	public String toString() {
		return "Customer [id= " + customer_id + "]";
	}

}
