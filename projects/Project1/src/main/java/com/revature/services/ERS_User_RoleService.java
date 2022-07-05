package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ERS_User_RoleDao;
import com.revature.daos.ERS_User_RolePostgres;
import com.revature.models.ERS_User_Role;

public class ERS_User_RoleService {
	
	private ERS_User_RoleDao urd = new ERS_User_RolePostgres();
	private static Logger log = LogManager.getLogger(ERS_User_RoleService.class);
	
	public ERS_User_Role createRole(ERS_User_Role ur) {
		
		ERS_User_Role ers_user_role = urd.createRole(ur);
		log.info("ERS_User_Role created: " + ers_user_role + " was created.");
		return ers_user_role;
	}
	public ERS_User_Role getMostRecentRole(Object ers_user_role_id) {
		return urd.retrieveMostRecentRole(ers_user_role_id);
	}
}	