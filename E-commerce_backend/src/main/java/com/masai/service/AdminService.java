package com.masai.service;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;
import com.masai.model.Admin;
import com.masai.model.User;

public interface AdminService {
	
    public Admin registerAdmin(Admin admin) throws AdminException;
	
    public Admin updateAdmin(Admin admin, String key) throws AdminException;
	
	public Admin deleteAdmin(String key) throws AdminException;
	
	public Admin getAdminDetails(String key) throws AdminException;
	
	public List<User> getUser(String key) throws AdminException, UserException;
	
	public User getUserByMobile(String mobile, String key) throws UserException, AdminException;
	

}
