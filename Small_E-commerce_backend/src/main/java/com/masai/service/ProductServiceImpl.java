package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.Product;
import com.masai.repository.AdminRepo;
import com.masai.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Product addProduct(Product product, Integer adminId) throws AdminException {
		Optional<Admin> optAdmin = adminRepo.findById(adminId);
		if(optAdmin.isPresent()) {
			return prodRepo.save(product);
		}else {
			throw new AdminException("Admin Not found with this ID : "+adminId);
		}
	}

	@Override
	public Product updateProduct(Product product, Integer adminInteger) throws AdminException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deletePorductByName(String Name, Integer adminId) throws AdminException, ProductException {
		Optional<Admin> optAdmin = adminRepo.findById(adminId);
		if(optAdmin.isPresent()) {
			 Product pro = prodRepo.deleteProductByName(Name);
			 if(pro==null) {
				 throw new ProductException("Product Not Found with the Name : "+Name);
			 }else {
				 return pro;
			 }
			 
		}else {
			throw new AdminException("Admin Not found with this ID : "+adminId);
		}
	}

	@Override
	public Product getPorductByName(String Name) throws ProductException {
			 Product pro = prodRepo.findByProductName(Name);
			 if(pro==null) {
				 throw new ProductException("Product Not Found with the Name : "+Name);
			 }else {
				 return pro;
			 }
	}

	@Override
	public List<Product> getAllProductDetails() throws ProductException {
			 List<Product> pro = prodRepo.findAll();
			 if(pro.size()==0) {
				 throw new ProductException("Products Not Found");
			 }else {
				 return pro;
			 }
			 
	}
	
	
}

