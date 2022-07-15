package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;

public class UserService {

	private UserDAO ud = new UserHibernate();
	
	private static Logger log = LogManager.getLogger(UserService.class);
	
	public User createUser(User u) throws UserNotCreatedException {
		// by default, created account will be basic Users
		u.setRole(Role.BASIC_USER);
		
		User createdUser = ud.insertUser(u);
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
		}
		log.info("User: " + u.getUsername() + " was created.");
		return createdUser;
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		User u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<User> getUsers() {
		List<User> users = ud.getUsers();
		return users;
	}

}