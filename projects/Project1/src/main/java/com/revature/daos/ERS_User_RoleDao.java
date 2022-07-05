package com.revature.daos;

import com.revature.models.ERS_User_Role;

public interface ERS_User_RoleDao {
	ERS_User_Role createRole(ERS_User_Role r);
	public ERS_User_Role retrieveMostRecentRole(Object ers_user_role_id);
}
