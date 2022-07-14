package com.revature.dtos;

import java.util.Date;
import java.util.Objects;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementDto {

	private int reimb_id;
	private int reimb_amount;
	private Date reimb_submitted;
	private Date reimb_resolved;
	private String reimb_description;
	private String reimb_status;
	private String reimb_type;
	private User reimb_author;
	private User reimb_resolver;
	
	public ReimbursementDto() {
		super();
	}

	public ReimbursementDto(Reimbursement r) {
		reimb_id = r.getId();
		reimb_amount = r.getAmt();
		reimb_submitted = r.getSubmitted();
		reimb_resolved = r.getResolved();
		reimb_description = r.getDescription();
		reimb_status = r.getReimb_status();
		reimb_type = r.getReimb_type();
		reimb_author = r.getAuthor_id();
		reimb_resolver = r.getResolver_id();
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

	public void setResolver_id(User reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public String getStatus() {
		return reimb_status;
	}

	public void setStatus(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public String getType() {
		return reimb_type;
	}

	public void setType(String reimb_type) {
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
		ReimbursementDto other = (ReimbursementDto) obj;
		return reimb_amount == other.reimb_amount && Objects.equals(reimb_author, other.reimb_author)
				&& Objects.equals(reimb_description, other.reimb_description) && reimb_id == other.reimb_id
				&& Objects.equals(reimb_resolved, other.reimb_resolved) && Objects.equals(reimb_resolver, other.reimb_resolver)
				&& Objects.equals(reimb_status, other.reimb_status) && Objects.equals(reimb_submitted, other.reimb_submitted)
				&& Objects.equals(reimb_type, other.reimb_type);
	}

	@Override
	public String toString() {
		return "ReimbursementDto [id=" + reimb_id + ", amt=" + reimb_amount + ", submitted=" + reimb_submitted + ", resolved=" + reimb_resolved
				+ ", description=" + reimb_description + ", author_id=" + reimb_author + ", resolver_id=" + reimb_resolver
				+ ", status=" + reimb_status + ", type=" + reimb_type + "]";
	}	
}