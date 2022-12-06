package com.masai.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.exceptions.ProductException;
import com.masai.exceptions.UserException;
import com.masai.model.Product;
import com.masai.model.User;
import com.masai.service.UserService;


import com.masai.service.ProductService;


@RestController
public class UserController {
    
	@Autowired
	private UserService uService;
	
	@Autowired
	private ProductService prodService;
	
	
		@PostMapping("/users")
		public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user){
			
			User us =uService.registerUser(user);
			return new ResponseEntity<>(us,HttpStatus.ACCEPTED);	
		}	
	
	
	
		@PutMapping("/users/{key}")
		public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user, @RequestParam("key") Integer key) throws UserException {
			
			User us = uService.updateUser(user, key);
			return new ResponseEntity<>(us,HttpStatus.ACCEPTED);
		}
		
		
		
		@DeleteMapping("/users/{key}")
		public ResponseEntity<User> deleteUserHandler(@RequestParam("key")Integer key) throws UserException {
				User us =uService.deleteUser(key);
				return  new ResponseEntity<>(us,HttpStatus.OK);
		}
		
		
		@GetMapping("/user/{key}")
		public ResponseEntity<User> getUserDetailsHandler(@PathVariable Integer key)throws UserException {
			User us = uService.getUserDetails(key);
			return new ResponseEntity<>(us,HttpStatus.OK);
		}
		
		@GetMapping("/users/user/{email}")
		public ResponseEntity<User> getUserDetailByEmailHandler(@PathVariable String email)throws UserException {
			User us = uService.getUserByEmail(email);
			return new ResponseEntity<>(us,HttpStatus.OK);
		}
		
		@GetMapping("/users/{mobile}")
		public ResponseEntity<User> getUserDetailByMobileHandler(@PathVariable String mobile)throws UserException {
			User us = uService.getUserByMobile(mobile);
			return new ResponseEntity<>(us,HttpStatus.OK);
		}
		
		@GetMapping("/users/products/{proName}")
		public ResponseEntity<Product> getProductDetailsByNameHandler(@PathVariable("proName")String proName) throws ProductException{
			
			Product product = prodService.getPorductByName(proName);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		
		@GetMapping("/users/products")
		public ResponseEntity<List<Product>> getAllProductDetailsHandler() throws ProductException{
			
			List<Product> product = prodService.getAllProductDetails();
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		
		
		
	
	
}
