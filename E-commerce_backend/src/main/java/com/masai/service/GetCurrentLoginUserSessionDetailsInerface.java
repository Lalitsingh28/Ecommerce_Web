package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;

public interface GetCurrentLoginUserSessionDetailsInerface {

    public CurrentUserSession getCurrentUserSession(String key) throws LoginException;
	
	public Integer getCurrentUserSessionId(String key) throws LoginException;
	
	public User getCurrentUser(String key) throws LoginException;
	
}
