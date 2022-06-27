package com.revature.models;

import java.util.Objects;

public class Offer {
	
	private int offer_id;
	private int offer_amount;
	private String offer_status;
	
	public Offer() {
		super();
	}
	
	public int getId() {
		return offer_id;
	}
	
	public void setId(int offer_id) {
		this.offer_id = offer_id;
	}
	
	public int getAmt() {
		return offer_amount;
	}
	
	public void setAmt(int offer_amount) {
		this.offer_amount = offer_amount;
	}
	
	public String getStatus() {
		return offer_status;
	}
	
	public void setStatus(String offer_status) {
		this.offer_status = offer_status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(offer_id, offer_amount, offer_status);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return offer_id == other.offer_id && Objects.equals(offer_amount, other.offer_amount) && Objects.equals(offer_status, other.offer_status);
	}
	@Override
	public String toString() {
		return "Offer [id= " + offer_id + ", offer amount= $" + offer_amount + ", offer_status= " + offer_status + "]";
	}
}
