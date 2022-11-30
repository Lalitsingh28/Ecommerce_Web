package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUserSession;


@Repository
public interface UserLoginSessionDAO extends JpaRepository<CurrentUserSession, Integer> {

    public CurrentUserSession findByCustomerId(Integer customberId);
	
	public CurrentUserSession findByUuid(String uuid);
	
	
}
