package com.masai.service;

import com.masai.exceptions.AdminException;
import com.masai.model.AdminCurrentUserSessionDTO;
import com.masai.model.AdminDTO;

public interface AdminLogIn {

    public AdminCurrentUserSessionDTO logIntoAccount(AdminDTO adminDTO) throws AdminException;
	
	public String logOutFromAccount(String key) throws AdminException;
	
}
