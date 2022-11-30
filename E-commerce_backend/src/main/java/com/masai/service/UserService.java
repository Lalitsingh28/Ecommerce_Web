package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.model.User;


public interface UserService {
	
	public User registerUser(User user) throws LoginException;
	
    public User updateUser(User user, String key) throws LoginException;
	
	public User deleteUser(String key) throws LoginException;
	
	public User getUserDetails(String key) throws LoginException;

	
	
}
