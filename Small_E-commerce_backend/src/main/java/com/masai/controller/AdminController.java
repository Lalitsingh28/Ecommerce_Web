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
import com.masai.exceptions.ProductException;
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
	
	@Autowired
	private ProductService prodService;

	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdminHandler(@RequestBody Admin admin) throws AdminException{
		
		Admin ad = aService.registerAdmin(admin);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/admin/{adminId}")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin,@PathVariable Integer adminId) throws AdminException{
		
		Admin ad = aService.updateAdmin(admin, adminId);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable Integer adminId) throws AdminException{
		
		Admin ad = aService.deleteAdmin(adminId);
		return new ResponseEntity<>(ad,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<Admin> getAdminDetailsHandler(@PathVariable Integer adminId) throws AdminException{
		
		Admin ad = aService.deleteAdmin(adminId);
		return new ResponseEntity<>(ad,HttpStatus.OK);
	}
	
	@GetMapping("/admin/{adminId}")
	public ResponseEntity<List<User>> getUserHandler(@PathVariable Integer adminId) throws AdminException, UserException{
		
		List<User> uList = aService.getUser(adminId);
		return new ResponseEntity<>(uList,HttpStatus.OK);
	}
	
	@GetMapping("/admin/products")
	public ResponseEntity<List<Product>> getAllProductDetailsHandler() throws ProductException{
		
		List<Product> product = prodService.getAllProductDetails();
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	
	
}
