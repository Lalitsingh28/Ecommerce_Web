package com.masai.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.UserException;
import com.masai.model.User;
import com.masai.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{
         
	@Autowired
	private UserRepo userRepo;

	@Override
	public User registerUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, Integer userId) throws UserException {
		Optional<User> optUser = userRepo.findById(userId);
		if(optUser.isPresent()) {
			return userRepo.save(user);
			 
		}else {
			throw new UserException("User Not Present with ID : "+userId);
		}
	}

	@Override
	public User deleteUser(Integer userId) throws UserException {
		Optional<User> optUser = userRepo.findById(userId);
		if(optUser.isPresent()) {
			userRepo.deleteById(userId);
			return optUser.get();
		}else {
			throw new UserException("User Not Present with ID : "+userId);
		}
	}

	@Override
	public User getUserDetails(Integer userId) throws UserException {
		Optional<User> optUser = userRepo.findById(userId);
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
			throw new UserException("User Not Present with ID : "+userId);
		}
	}

	@Override
	public User getUserByEmail(String email) throws UserException {
		User user = userRepo.findByEmail(email);
		if(user !=null) {
			return user;
		}else {
			throw new UserException("User Not Present with Email : "+email);
		}
	}

	@Override
	public User getUserByMobile(String mobile) throws UserException {
		User user = userRepo.findByMobile(mobile);
		if(user !=null) {
			return user;
		}else {
			throw new UserException("User Not Present with Mobile Number : "+mobile);
		}
	}
	
	
}
