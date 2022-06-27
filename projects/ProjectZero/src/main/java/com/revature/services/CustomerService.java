package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerPostgres;
import com.revature.models.Customer;

public class CustomerService {

	private CustomerDao cd = new CustomerPostgres();
	private static Logger log = LogManager.getLogger(CustomerService.class);
	
	public List<Customer> getCustomers(){
		return cd.retrieveCustomers();
	}
	
	public Customer createCustomer(Customer cu) {
		Customer customer = cd.createCustomer(cu);
		log.info("customer: " + customer + " was created.");
		return customer;
	}
}
