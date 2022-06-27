package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDao {
	Customer createCustomer(Customer cu);
	Customer retrieveCustomerById(int customer_id);
	List<Customer> retrieveCustomers();
	Customer retrieveCustomerByName(String firstname);
	boolean updateCustomer(Customer cu);
	boolean deleteCustomerById(int customer_id);
}
