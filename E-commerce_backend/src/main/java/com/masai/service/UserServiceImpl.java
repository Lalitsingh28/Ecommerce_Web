package com.masai.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.model.User;
import com.masai.model.OrderItems;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.repository.UserDao;
import com.masai.repository.ProductDao;


@Service
public class UserServiceImpl implements UserService{
         
	@Autowired
	private UserDao usDao;
	
	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;


	
	
	@Override
	public User registerUser(User user) throws LoginException {
		
	 User opt =	 usDao.findByMobile(user.getMobile());
	 if(opt == null) {
		 return usDao.save(user);
	 }else {
		 throw new LoginException("User is already register");
	 }
	  
	}


	@Override
	public User updateUser(User user, String key) throws LoginException {
       User customer2 = getCurrentLoginUser.getCurrentUser(key);
		
		if(customer2 == null) {
			throw new LoginException("No user found..");
		}
		
		return usDao.save(user);
	}


	
	
	@Override
	public User deleteUser(String key) throws LoginException {
		User user = getCurrentLoginUser.getCurrentUser(key);		
		usDao.delete(user);
		return user;
	}


	@Override
	public User getUserDetails(String key) throws LoginException {
		User user = getCurrentLoginUser.getCurrentUser(key);	
		System.out.println(user);
		return user;
	}
		
	
}
