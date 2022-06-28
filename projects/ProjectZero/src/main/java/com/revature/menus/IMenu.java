package com.revature.menus;

import com.revature.models.User;
import com.revature.services.UserService;

public class IMenu {
	
	UserService us;
	
	public IMenu(UserService us) {
		this.us = us;
	}
	public User getCurrentUser(){
		return us.getCurrentUser();
	}
}
