package com.revature.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reimbursements")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int reimb_id;
	@Column(name="reimb_amount", nullable=false)
	private int reimb_amount;
	@Column(name="reimb_submitted", nullable=false)
	private Date reimb_submitted;
	@Column(name="reimb_resolved")
	private Date reimb_resolved;
	@Column(name="reimb_description", nullable=false)
	private String reimb_description;
	@Column(name="reimb_status", nullable=false)
	private String reimb_status;
	@Column(name="reimb_type", nullable=false)
	private String reimb_type;
	@ManyToOne
	@JoinColumn(name="reimb_author", nullable=false)
	private User reimb_author;
	@ManyToOne
	@JoinColumn(name="reimb_resolver")
	private User reimb_resolver;
	
	public Reimbursement() {
		super();
	}

	public int getId() {
		return reimb_id;
	}

	public void setId(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getAmt() {
		return reimb_amount;
	}

	public void setAmt(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Date getSubmitted() {
		return reimb_submitted;
	}

	public void setSubmitted(Date reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Date getResolved() {
		return reimb_resolved;
	}

	public void setResolved(Date reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getDescription() {
		return reimb_description;
	}

	public void setDescription(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public User getAuthor_id() {
		return reimb_author;
	}

	public void setAuthor_id(User reimb_author) {
		this.reimb_author = reimb_author;
	}

	public User getResolver_id() {
		return reimb_resolver;
	}

	public void setResolver_id(User resolver_id) {
		this.reimb_resolver = resolver_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimb_amount, reimb_author, reimb_description, reimb_id, reimb_resolved, reimb_resolver, reimb_status, reimb_submitted, reimb_type);
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
		return reimb_amount == other.reimb_amount && reimb_author == other.reimb_author && Objects.equals(reimb_description, other.reimb_description)
				&& reimb_id == other.reimb_id && Objects.equals(reimb_resolved, other.reimb_resolved) && reimb_resolver == other.reimb_resolver
				&& reimb_status == other.reimb_status && Objects.equals(reimb_submitted, other.reimb_submitted)
				&& reimb_type == other.reimb_type;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + reimb_id + ", amt=" + reimb_amount + ", submitted=" + reimb_submitted + ", resolved=" + reimb_resolved
				+ ", description=" + reimb_description + ", author_id=" + reimb_author + ", resolver_id=" + reimb_resolver
				+ ", status_id=" + reimb_status + ", type_id=" + reimb_type + "]";
	}	
}