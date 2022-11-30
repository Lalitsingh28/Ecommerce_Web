package com.masai.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.UserDTO;
import com.masai.service.UserLogInImpl;


@RestController
public class UserLoginController {

	
	@Autowired
	private UserLogInImpl userLogIn;


//	@PostMapping("/users/login")
//	public ResponseEntity<CurrentUserSession> logInUserHandler(@Valid @RequestBody UserDTO userDTO) throws LoginException {
//		
//		CurrentUserSession cus = userLogIn.logIntoAccount(userDTO);
//		return new ResponseEntity<>(cus,HttpStatus.OK);
//	}
//	
//	@GetMapping("/users/logout")
//	public ResponseEntity<String> logOutUserHandler(@RequestParam(required = false) String key) throws LoginException {
//		
//		String masg = userLogIn.logOutFromAccount(key);
//		return new ResponseEntity<>(masg,HttpStatus.OK);
//	}
//	
}
