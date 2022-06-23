package com.revature.services;

import java.util.List;

import com.revature.Daos.UserDao;
import com.revature.Daos.UserPostgres;
import com.revature.Models.User;

public class UserService {
		
		private UserDao ud = new UserPostgres();
		
		public List<User> getUsers(){
			return ud.retrieveUsers();
		}
		
		public User createUser(User u) {
			//logic to validate u
			//if ok
			u = ud.createUser(u);
			return ud.createUser(u);
		}
}
