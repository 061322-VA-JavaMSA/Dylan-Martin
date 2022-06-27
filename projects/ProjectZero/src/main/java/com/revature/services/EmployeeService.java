package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Employee;

public class EmployeeService {
	
	private EmployeeDao ed = new EmployeePostgres();
	private static Logger log = LogManager.getLogger(EmployeeService.class);
	
	public List<Employee> getEmployees() {
		return ed.retrieveEmployees();
	}
	
	public Employee createEmployee(Employee em) {
		Employee employee = ed.createEmployee(em);
		log.info("Employee: " + employee + " was created.");
		return employee;
	}

}
