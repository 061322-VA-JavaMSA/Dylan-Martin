package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementHibernate implements ReimbursementDAO {

	@Override
	public Reimbursement insertReimbursement(Reimbursement r) {
		r.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int reimb_id = (int) s.save(r);
			r.setId(reimb_id);
			tx.commit();
		} catch(ConstraintViolationException e) {
			//log it
		}
		return r;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursements = s.createQuery("from Reimbursement", Reimbursement.class).list();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementByUsername(String username) {
		Reimbursement Reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			// define entity to be searched
			Root<Reimbursement> root = cq.from(Reimbursement.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("username"), username);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			Reimbursement = (Reimbursement) s.createQuery(cq).getSingleResult();
		}
		
		return Reimbursement;
	}

	@Override
	public Reimbursement getReimbursementByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursementByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	//update reimbursement status to accepted
	@Override 
	public Reimbursement updateReimbursement(Reimbursement r) {
	//update reimb_status = ? where reimb_id = ?;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update("Reimbursement", r);
			tx.commit();
		} catch (ConstraintViolationException e){
			//log it
		}
		return r;
	}

	@Override
	public Reimbursement getReimbursementById(int reimb_id) {
		Reimbursement r = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			r = s.get(Reimbursement.class, reimb_id);
		}
		return r;
	}
	
}
