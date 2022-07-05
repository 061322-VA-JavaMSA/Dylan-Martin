package com.revature.models;

import com.revature.services.ERS_UserService;

public class IMenu {
	
	ERS_UserService us;
	
	public IMenu(ERS_UserService us) {
		this.us = us;
	}
	
	public ERS_User getCurrentUser() {
		return us.getCurrentUser();
	}
}
