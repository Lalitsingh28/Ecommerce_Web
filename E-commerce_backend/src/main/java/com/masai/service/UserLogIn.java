package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.UserDTO;

public interface UserLogIn {
	 
	public CurrentUserSession logIntoAccount(UserDTO userDTO) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
