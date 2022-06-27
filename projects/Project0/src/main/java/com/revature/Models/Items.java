package com.revature.models;

//import java.time.LocalDate;
import java.util.Objects;

public class Items {

	private int item_id;
	private String name;
	private String description;
	private String status;
//	private int userAssignedId; -- not OOP
//	private User userAssigned;
	public Items() {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String item_state) {
		this.status = item_state;
	}
	@Override
	public int hashCode() {
		return Objects.hash(item_id, description, item_id, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return item_id == other.item_id && Objects.equals(name, other.name) && Objects.equals(description, other.description) && Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Task [id=" + item_id + ", name=" + name + ", description=" + description + ", status=" + status
				+  "]";
	}
}