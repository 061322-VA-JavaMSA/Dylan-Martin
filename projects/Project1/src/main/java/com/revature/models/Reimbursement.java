package com.revature.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reimbursements")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="reimb_amount", nullable=false)
	private int amt;
	@Column(name="reimb_submitted", nullable=false)
	private Date submitted;
	@Column(name="reimb_resolved", nullable=false)
	private Date resolved;
	@Column(name="reimb_description", nullable=false)
	private String description;
	@Column(name="reimb_author", nullable=false)
	private int author_id;
	@Column(name="reimb_resolver", nullable=false)
	private int resolver_id;
	@Column(name="reimb_status_id", nullable=false)
	private int status_id;
	@Column(name="reimb_type_id", nullable=false)
	private int type_id;
	
	public Reimbursement() {
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
		Reimbursement other = (Reimbursement) obj;
		return amt == other.amt && author_id == other.author_id && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(resolved, other.resolved) && resolver_id == other.resolver_id
				&& status_id == other.status_id && Objects.equals(submitted, other.submitted)
				&& type_id == other.type_id;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amt=" + amt + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author_id=" + author_id + ", resolver_id=" + resolver_id
				+ ", status_id=" + status_id + ", type_id=" + type_id + "]";
	}	
}