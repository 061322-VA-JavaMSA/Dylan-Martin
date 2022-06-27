package com.revature.services;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.Employee;
import com.revature.models.User;

public class AuthService {

	private UserDao ud = new UserPostgres();
	
	public User login(String username, String password) throws LoginException {
		// if username/password passed are null, throws an exception
		if(username == null || password == null) {
			throw new LoginException();
		}
		
		User u = ud.retrieveUserByUsername(username);
		// if no user of that name has been retrieved/if pass don't match, throw an exception
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	}
	
	private EmployeeDao ed = new EmployeePostgres();
	
	public Employee elogin(String e_name, String e_pass) throws LoginException {
		if(e_name == null || e_pass == null) {
			throw new LoginException();
		}
		
		Employee em = ed.retrieveEmployeeByName(e_name);
		if(em == null || !em.getPass().equals(e_pass)) {
			throw new LoginException();
		}
		return em;
	}
}