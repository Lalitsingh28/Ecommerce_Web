package com.masai.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;
import com.masai.model.AdminCurrentUserSessionDTO;
import com.masai.model.AdminDTO;
import com.masai.service.AdminLogInImpl;


@RestController
public class AdminLoginController {

	
	@Autowired
	private AdminLogInImpl adminLogIn;


	@PostMapping("/login")
	public ResponseEntity<AdminCurrentUserSessionDTO> logInAdminHandler(@Valid @RequestBody AdminDTO adminDTO) throws AdminException {
		
		AdminCurrentUserSessionDTO at =adminLogIn.logIntoAccount(adminDTO);
		return new ResponseEntity<>(at,HttpStatus.ACCEPTED);
	}
	

	@PatchMapping("/logout")
	public ResponseEntity<String> logOutAdminHandler(@RequestParam(required = false) String key) throws AdminException {
		String message =adminLogIn.logOutFromAccount(key);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}

	
}
