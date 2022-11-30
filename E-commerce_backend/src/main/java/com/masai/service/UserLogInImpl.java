package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.repository.UserDao;
import com.masai.repository.UserLoginSessionDAO;



@Service
public class UserLogInImpl implements UserLogIn {

	
	@Autowired
	private UserDao customerDAO;
	
	@Autowired
	private UserLoginSessionDAO sessionDAO;
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;
	
	
	@Override
	public CurrentUserSession logIntoAccount(UserDTO userDTO) throws LoginException {
		
		User opt = customerDAO.findByMobile(userDTO.getMobile());
		
		if(opt == null) {
			throw new LoginException("Please Enter Valid Mobile Number");
		}
		
		
		Integer UserId =opt.getUserId();
		
		CurrentUserSession currentUserOptional = sessionDAO.findByCustomerId(UserId);

		if(currentUserOptional ==null) {
			throw new LoginException("User already logged in with this number");
		}
		
		if(opt.getPassword().equals(userDTO.getPassword())){
			
			String key = RandomStringUtils.randomAlphabetic(8);
			CurrentUserSession currentUserSession = new CurrentUserSession(UserId, key,  LocalDateTime.now());
			sessionDAO.save(currentUserSession);
			return currentUserSession;
		}else {
			throw new LoginException("Please Enter Valid Password");
		}
	}
	
	
	
	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		CurrentUserSession currentUserOptional = sessionDAO.findByUuid(key);	
		if(currentUserOptional ==null) {
			throw new LoginException("User is not logged in with this number");
		}
		
		CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
		sessionDAO.delete(currentUserSession);
		return "Logged Out...";
	}
	
	
}
