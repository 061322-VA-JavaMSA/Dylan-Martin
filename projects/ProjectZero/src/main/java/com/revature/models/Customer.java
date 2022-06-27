package com.revature.models;

import java.util.Objects;

public class Customer {
	
	private int customer_id;
	
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
	
	@Override
	public boolean equals(Objects obj) {
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
