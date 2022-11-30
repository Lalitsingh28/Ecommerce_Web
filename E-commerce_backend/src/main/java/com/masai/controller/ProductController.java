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
		
		Product product = prodService.getProductDetailsByName(productName);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductDetailsHandler() throws ProductException{
		
		List<Product> productList = prodService.getAllProductDetails();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{name}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("name") String name,String key) throws ProductException, AdminException{
		
		Product product = prodService.deleteProductByName(name, key);
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product pro, String key) throws AdminException{
		
		Product product = prodService.updateProduct(pro, key);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product pro, String key) throws AdminException{
		Product product = prodService.addProduct(pro, key);
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}
	
}
