package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;
import com.masai.model.Admin;
import com.masai.model.User;
import com.masai.repository.AdminRepo;
import com.masai.repository.UserRepo;

@Service
public class AdminServiceImpl  implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Admin adm = adminRepo.save(admin);
		if(adm==null) {
			throw new AdminException("Admin not added. Please Check....!");
		}
		// TODO Auto-generated method stub
		return adm;
	}

	@Override
	public Admin updateAdmin(Admin admin, Integer adminId) throws AdminException {
		Optional<Admin> optAdmin = adminRepo.findById(adminId);
		if(optAdmin.isPresent()) {
			return adminRepo.save(admin);
		}else {
			throw new AdminException("Admin not present with ID : "+adminId);
		}
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		Optional<Admin> optAdmin = adminRepo.findById(adminId);
		if(optAdmin.isPresent()) {
			   adminRepo.deleteById(adminId);
			   return optAdmin.get();
		}else {
			throw new AdminException("Admin not present with ID : "+adminId);
		}
	}

	@Override
	public Admin getAdminDetails(Integer adminId) throws AdminException {
		Optional<Admin> optAdmin = adminRepo.findById(adminId);
		if(optAdmin.isPresent()) {
			   return optAdmin.get();
		}else {
			throw new AdminException("Admin not present with ID : "+adminId);
		}
	}

	@Override
	public List<User> getUser(Integer adminId) throws AdminException, UserException {
		Optional<Admin> optAdmin = adminRepo.findById(adminId);
		if(optAdmin.isPresent()) {
			   List<User> listUser = userRepo.findAll();
			   if(listUser.size()==0) {
				   throw new UserException("No Users Found");
			   }else {
				   return listUser;
			   }
		}else {
			throw new AdminException("Admin not present with ID : "+adminId);
		}
	}
	
	

}
