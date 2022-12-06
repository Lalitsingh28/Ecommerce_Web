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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ProductException;
import com.masai.model.Product;
import com.masai.service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService prodService;
	

	@GetMapping("/product/{productName}")
	public ResponseEntity<Product> getProductByNameHandler(@PathVariable("productName") String productName) throws ProductException{
		
		Product product = prodService.getPorductByName(productName);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductDetailsHandler() throws ProductException{
		
		List<Product> productList = prodService.getAllProductDetails();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{name}/{adminId}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("name") String name,@PathVariable Integer adminId) throws ProductException, AdminException{
		
		Product product = prodService.deletePorductByName(name, adminId);
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/products/{adminId}")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product pro, @PathVariable Integer adminId) throws AdminException, ProductException{
		
		Product product = prodService.updateProduct(pro, adminId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping("/products/{adminId}")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product pro,@PathVariable Integer adminId) throws AdminException{
		Product product = prodService.addProduct(pro, adminId);
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}
	
}
