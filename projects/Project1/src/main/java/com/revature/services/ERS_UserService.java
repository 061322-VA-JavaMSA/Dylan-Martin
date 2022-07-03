package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ERS_UserDao;
import com.revature.daos.ERS_UserPostgres;
import com.revature.models.ERS_User;

public class ERS_UserService {
	
	private ERS_UserDao ud = new ERS_UserPostgres();
	private static ERS_User currentUser = new ERS_User();
	private static Logger log = LogManager.getLogger(ERS_UserService.class);
	
	public ERS_User createUser(ERS_User u) {
		ERS_User ers_user = ud.createUser(u);
		log.info("User created: " + ers_user);
		return ers_user;
	}
	
	public static ERS_User getCurrentUser() {
		return currentUser;
	}
	
	public static void setCurrentUser(ERS_User currentUser) {
		ERS_UserService.currentUser = currentUser;
	}
}