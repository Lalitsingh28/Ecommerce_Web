package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.AdminCurrentUserSession;



public interface AdminSessionDao extends JpaRepository<AdminCurrentUserSession, Integer>{

	
	public  AdminCurrentUserSession findByAdminId(Integer adminId);
	
	public AdminCurrentUserSession findByUuid(String uuid);
	
}
