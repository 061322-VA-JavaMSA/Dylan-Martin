package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.exceptions.ReimbursementNotCreatedException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDAO rd = new ReimbursementHibernate();
	
	public Reimbursement createReimbursement(Reimbursement r) throws ReimbursementNotCreatedException {
		//by default, created reimbursements will have a pending status update
		r.setReimb_status("pending");
		
		Reimbursement createdReimbursement = rd.insertReimbursement(r);
		if (createdReimbursement.getId() == -1) {
			throw new ReimbursementNotCreatedException();
		}
		return createdReimbursement;
	}

	public Reimbursement getReimbursementById(int reimb_id) throws ReimbursementNotFoundException {
		Reimbursement r = rd.getReimbursementById(reimb_id);
		if (r == null) {
			throw new ReimbursementNotFoundException();
		}
		return r;
	}
	
	public List<Reimbursement> getPendingReimbursements(String reimb_status) throws ReimbursementNotFoundException {
		List<Reimbursement> r = rd.getPendingReimbursements(reimb_status);
		if (r == null) {
			throw new ReimbursementNotFoundException();
		}
		return r;
	}

	public List<Reimbursement> getReimbursementsByStatus(String reimb_status) throws ReimbursementNotFoundException {
		List<Reimbursement> r = rd.getReimbursementsByStatus(reimb_status);
		if (r == null) {
			throw new ReimbursementNotFoundException();
		}
		return r;
	}
	
	public List<Reimbursement> getReimbursements(){
		List<Reimbursement> reimbursements = rd.getReimbursements();
		return reimbursements;
	}
	
	public Reimbursement updateReimbursement(Reimbursement r) {
		return rd.updateReimbursement(r);
	}
}
