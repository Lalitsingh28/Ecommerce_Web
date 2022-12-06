package com.masai.service;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ProductException;
import com.masai.exceptions.UserException;
import com.masai.model.Admin;
import com.masai.model.Product;
import com.masai.model.User;

public interface AdminService {
	
    public Admin registerAdmin(Admin admin) throws AdminException;
	
    public Admin updateAdmin(Admin admin,Integer adminId ) throws AdminException;
	
	public Admin deleteAdmin(Integer adminId) throws AdminException;
	
	public Admin getAdminDetails(Integer adminId) throws AdminException;
	
	public List<User> getUser(Integer adminId) throws AdminException, UserException;
	
	
}
