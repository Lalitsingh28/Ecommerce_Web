package com.masai.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.ProductException;
import com.masai.model.Admin;
import com.masai.model.Product;
import com.masai.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private GetCurrentLoginAdminSessionDetailsImpl getCurrentLoginUser;

	@Override
	public Product addProduct(Product product,String key) throws AdminException {
		
		
        Admin customer2 = getCurrentLoginUser.getCurrentAdmin(key);	
		
		if(customer2!=null){
			Product product1 =  prodDao.findByProductName(product.getProductName());
			if(product1 == null){
				return prodDao.save(product);
			}else{
				product1.setQuantity(product1.getQuantity()+product.getQuantity());

				return prodDao.save(product1);
			}
		}else{
			throw new AdminException("The admin is not logged in");
		}
		
	}
	
	@Override
	public Product updateProduct(Product product,String key) throws AdminException {
		
		 Admin admin = getCurrentLoginUser.getCurrentAdmin(key);
		 if(admin!=null){
			 Product product1 =  prodDao.findByProductName(product.getProductName());
				
			 if(product1 == null){
					return prodDao.save(product);
			 }else{
				 product1.setPrice(product.getPrice());
				 return prodDao.save(product1);
			 }
		 }else{
			 throw new AdminException("The admin is not logged in");
		 }
		 
	}

	
	@Override
	public Product deleteProductByName(String name,String key) throws ProductException, AdminException {
		
		 Admin admin = getCurrentLoginUser.getCurrentAdmin(key);
		 if(admin!=null){
			 Product product1 =  prodDao.findByProductName(name);
			 if(product1==null){
				 throw new ProductException("Product not found with name "+name);
			 }
			 prodDao.delete(product1);
			 return product1;
		 }else{
			 throw new AdminException("The admin is not logged in");
		 }
	}
	
	
	
	
	@Override
	public Product getProductDetailsByName(String productName) throws ProductException {
		
			 Product product =  prodDao.findByProductName(productName);
			 if(product == null){
				 throw new ProductException("Product not found with name "+ productName);
			 }
			 return product ;
			 
	}
		 

	

	@Override
	public List<Product> getAllProductDetails() throws ProductException {
		
			List<Product> productList = prodDao.findAll();

			if (productList.isEmpty()) {
				throw new ProductException("No products Found.");
			}
			return productList;
		} 
	


		
}

