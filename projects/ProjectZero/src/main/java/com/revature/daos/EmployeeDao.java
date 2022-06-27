package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	Employee createEmployee(Employee em);
	Employee retrieveEmployeeById(int employee_id);
	List<Employee> retrieveEmployees();
	Employee retrieveEmployeeByName(String e_name);
	boolean updateEmployee(Employee em);
	boolean deleteEmployeeById(int employee_id);
}
