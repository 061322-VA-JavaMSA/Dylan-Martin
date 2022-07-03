package com.revature.services;

import javax.security.auth.login.LoginException;

import com.revature.daos.ERS_UserDao;
import com.revature.daos.ERS_UserPostgres;
import com.revature.models.ERS_User;

public class AuthService {

	
	private ERS_UserDao ud = new ERS_UserPostgres();
	
	public ERS_User login(String ers_username, String ers_password) throws LoginException {
		if(ers_username == null || ers_password == null) {
			throw new LoginException();
		}
		
		ERS_User u = ud.retrieveUserByUsername(ers_username);
		if(u == null || !u.getErs_password().equals(ers_password)) {
			throw new LoginException();
		}
		return u;
	}
}