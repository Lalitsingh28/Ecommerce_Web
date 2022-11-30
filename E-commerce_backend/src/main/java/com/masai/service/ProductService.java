package com.masai.service;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public Product addProduct(Product product,String key) throws AdminException;

	public Product updateProduct(Product product,String key) throws AdminException;

	public Product deleteProductByName(String name,String key) throws ProductException, AdminException;
	
	public Product getProductDetailsByName(String productName) throws ProductException;
		
	public List<Product> getAllProductDetails() throws ProductException;

	



}
