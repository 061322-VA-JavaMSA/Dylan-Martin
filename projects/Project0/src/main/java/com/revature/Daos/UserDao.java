package com.revature.Daos;

import java.util.List;

import com.revature.Models.User;

public interface UserDao {
	User createUser(User u);
	User retrieveUserById(int id);
	List<User> retrieveUsers();
	User retrieveUserByUsername(String username);
	boolean updateUser(User u);
	boolean deleteUserById(int id);
}