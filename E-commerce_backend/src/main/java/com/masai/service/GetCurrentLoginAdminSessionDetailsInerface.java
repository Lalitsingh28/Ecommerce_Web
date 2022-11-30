package com.masai.service;

import com.masai.exceptions.AdminException;
import com.masai.model.Admin;
import com.masai.model.AdminCurrentUserSession;

public interface GetCurrentLoginAdminSessionDetailsInerface {

public AdminCurrentUserSession getCurrentUserSession(String key) throws AdminException;
	
	public Integer getCurrentUserSessionAdminId(String key) throws AdminException;
	
	public Admin getCurrentAdmin(String key) throws AdminException;
	
	
}
