package com.revature.dtos;

import java.util.Date;
import java.util.Objects;

public class ReimbursementDto {

	private int id;
	private int amt;
	private Date submitted;
	private Date resolved;
	private String description;
	private int author_id;
	private int resolver_id;
	private int status_id;
	private int type_id;
	
	public ReimbursementDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getResolver_id() {
		return resolver_id;
	}

	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amt, author_id, description, id, resolved, resolver_id, status_id, submitted, type_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementDto other = (ReimbursementDto) obj;
		return amt == other.amt && author_id == other.author_id && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(resolved, other.resolved) && resolver_id == other.resolver_id
				&& status_id == other.status_id && Objects.equals(submitted, other.submitted)
				&& type_id == other.type_id;
	}

	@Override
	public String toString() {
		return "ReimbursementDto [id=" + id + ", amt=" + amt + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author_id=" + author_id + ", resolver_id=" + resolver_id
				+ ", status_id=" + status_id + ", type_id=" + type_id + "]";
	}	
}
