package com.masai.service;

import com.masai.exceptions.UserException;
import com.masai.model.User;


public interface UserService {
	
	public User registerUser(User user);
	
    public User updateUser(User user, Integer userId) throws UserException;
	
	public User deleteUser(Integer userId) throws UserException;
	
	public User getUserDetails(Integer userId)throws UserException;

	public User getUserByEmail(String email)throws UserException;
	
	public User getUserByMobile(String mobile)throws UserException;
	
}
