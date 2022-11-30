package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.UserDao;
import com.masai.repository.UserLoginSessionDAO;



@Service
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsInerface {

	
	
	@Autowired
	private UserLoginSessionDAO sessionDAO;

	@Autowired
	private UserDao customerDAO;
	
	
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException {
		CurrentUserSession optional = sessionDAO.findByUuid(key);
		
		if(optional==null) {
			throw new  LoginException("Unauthorized");
		}
		
		return optional;
	}
	
	public Integer getCurrentUserSessionId(String key) throws LoginException{
		CurrentUserSession optional = sessionDAO.findByUuid(key);
		
		if(optional==null) {
			throw new LoginException("Unauthorized");
		}
		
		return optional.getId();
	}
	
	public User getCurrentUser(String key) throws LoginException {
		CurrentUserSession optional = sessionDAO.findByUuid(key);
		
		if(optional==null) {
			throw new LoginException("Customer not logged in, login first...");
		}
		
		Integer customerId = optional.getUserId();
		
		return  customerDAO.findById(customerId).get();
	}
	
	
	
}
