package com.revature.daos;

import com.revature.models.ERS_User;

public interface ERS_UserDao {
	
	ERS_User createUser(ERS_User u);
	ERS_User retrieveUserByUsername(String ers_username);
}
