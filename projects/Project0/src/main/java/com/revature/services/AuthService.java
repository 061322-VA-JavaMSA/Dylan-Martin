package com.revature.services;

import com.revature.Daos.UserDao;
import com.revature.Daos.UserPostgres;
import com.revature.Exceptions.LoginException;
import com.revature.Models.User;

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
//			throw new LoginException();
		}
		return u;
	}
}