package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement insertReimbursement(Reimbursement r);
	List<Reimbursement> getReimbursements();
	Reimbursement getReimbursementByUsername(String username);
	Reimbursement getReimbursementByType(String type);
	Reimbursement getReimbursementByStatus(String status);
	Reimbursement updateReimbursement(Reimbursement r);
	Reimbursement getReimbursementById(int reimb_id);
}
