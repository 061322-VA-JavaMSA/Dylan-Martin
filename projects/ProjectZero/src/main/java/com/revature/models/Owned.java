package com.revature.models;

import java.util.Objects;

public class Owned {
	
	private int owned_id;
	private int c_id;
	private int o_id;
	
	public Owned() {
		super();
	}
	
	public int getId() {
		return owned_id;
	}
	
	public void setId(int owned_id) {
		this.owned_id = owned_id;
	}
	
	public int getCid() {
		return c_id;
	}
	
	public void setCid(int c_id) {
		this.c_id = c_id;
	}
	
	public int getOid() {
		return o_id;
	}
	
	public void setOid(int o_id) {
		this.o_id = o_id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owned other = (Owned) obj;
		return owned_id == other.owned_id && Objects.equals(c_id, other.c_id) && Objects.equals(o_id, other.o_id);
	}
	@Override
	public String toString() {
		return "Owned item [id= " + owned_id + ", by customer id= " + c_id + ", associated with the offer id= " + o_id + "]";
	}
}
