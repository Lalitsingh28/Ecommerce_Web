package com.masai.service;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ProductException;
import com.masai.model.Product;

public interface ProductService {

	public Product addProduct(Product product,Integer adminInteger) throws AdminException;

	public Product updateProduct(Product product,Integer adminInteger) throws AdminException,ProductException;

	public Product deletePorductByName(String Name,Integer adminId)throws AdminException,ProductException;
	
	public Product getPorductByName(String Name)throws ProductException;
		
	public List<Product> getAllProductDetails() throws ProductException;

	



}
