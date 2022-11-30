package com.masai.controller;



import java.util.List;


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

import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;
import com.masai.model.Admin;
import com.masai.model.User;
import com.masai.model.Product;
import com.masai.service.AdminService;
import com.masai.service.ProductService;


@RestController
public class AdminController {
	
	@Autowired
	private AdminService aService;

	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdminHandler(@RequestBody Admin admin) throws AdminException{
		
		Admin ad = aService.registerAdmin(admin);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin,String key) throws AdminException{
		
		Admin ad = aService.updateAdmin(admin, key);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/admin")
	public ResponseEntity<Admin> deleteAdminHandler(String key) throws AdminException{
		
		Admin ad = aService.deleteAdmin(key);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admins/{key}")
	public ResponseEntity<Admin> getAdminDetailsHandler(@PathVariable("key") String key) throws AdminException{
		
		Admin ad = aService.deleteAdmin(key);
		return new ResponseEntity<>(ad,HttpStatus.OK);
	}
	
//	@GetMapping("/admin/{key}")
//	public ResponseEntity<List<User>> getUserHandler(@PathVariable("key") String key) throws AdminException, UserException{
//		
//		List<User> uList = aService.getUser(key);
//		return new ResponseEntity<>(uList,HttpStatus.OK);
//	}
//	
//	@GetMapping("/admin/{mobile}/{key}")
//	public ResponseEntity<User> getUserByMobileHandler(@PathVariable("mobile")String mobile, @PathVariable("key") String key) throws AdminException, UserException{
//		
//		User user = aService.getUserByMobile(mobile, key);
//		return new ResponseEntity<>(user,HttpStatus.OK);
//	}
	
	
	
	
}
