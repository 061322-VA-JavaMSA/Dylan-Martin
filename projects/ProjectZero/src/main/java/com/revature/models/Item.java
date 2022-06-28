package com.revature.models;

//import java.time.LocalDate;
import java.util.Objects;

public class Item {

	private int item_id;
	private String name;
	private String description;
	private int availability;
//	private int userAssignedId; -- not OOP
//	private User userAssigned;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return item_id;
	}
	public void setId(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String item_name) {
		this.name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String item_description) {
		this.description = item_description;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int item_availability) {
		this.availability = item_availability;
	}
	@Override
	public int hashCode() {
		return Objects.hash(item_id, description, item_id, availability);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return item_id == other.item_id && Objects.equals(name, other.name) && Objects.equals(description, other.description) && Objects.equals(availability, other.availability);
	}
	@Override
	public String toString() {
		return "Item [id=" + item_id + ", name=" + name + ", description=" + description + ", availability=" + availability + "]";
	}
}