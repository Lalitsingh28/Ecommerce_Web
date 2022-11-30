package com.masai.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;
import com.masai.model.Admin;
import com.masai.model.User;
import com.masai.repository.AdminDao;
import com.masai.repository.UserDao;

@Service
public class AdminServiceImpl  implements AdminService{
	
	@Autowired
	private AdminDao adminDAO;
	
	@Autowired
	private UserDao customerDAO;
	
	@Autowired
	private GetCurrentLoginAdminSessionDetailsImpl getCurrentLoginUser;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Admin oldAdmin = adminDAO.findByMobile(admin.getMobile());
		
		if(oldAdmin==null){
			return adminDAO.save(admin);
		}
		 throw new AdminException("Admin already exist");
		
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		Admin customer2 = getCurrentLoginUser.getCurrentAdmin(key);	
		
		if(customer2.getMobile().equals(admin.getMobile())){
			adminDAO.save(admin);
			return admin;
		}
		else{
			throw new AdminException("No user found..");
		}
	}

	@Override
	public Admin deleteAdmin(String key) throws AdminException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);		
		adminDAO.delete(admin);
		return admin;
	}

	@Override
	public Admin getAdminDetails(String key) throws AdminException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);	
		return admin;
	}
	

	@Override
	public List<User> getUser(String key) throws AdminException, UserException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);	
		if(admin!=null){
			List<User> users = customerDAO.findAll();
			if(!users.isEmpty()){
				return users;
			}
			throw new UserException("No User exists.");	
		}else{
			throw new AdminException("The admin is not logged in");
		}
	}

	@Override
	public User getUserByMobile(String mobile, String key) throws UserException, AdminException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);	
		if(admin!=null){
			User user = customerDAO.findByMobile(mobile);
			if(user!=null){
				return user;
			}
			throw new UserException("No customer exists with mobile number: " + mobile);	
		}else{
			throw new AdminException("The admin is not logged in");
		}
	}



	

}
