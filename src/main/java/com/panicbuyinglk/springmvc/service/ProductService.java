package com.panicbuyinglk.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	public Product saveProduct(Product p) {
		return productRepository.save(p);
	}
	
	public List<Product> getProductsByUser(User u) {
		return productRepository.getProductsByUser(u.getUserId());
	}
	
	public Product getProdutById(int productId) {
		return productRepository.getProductById(productId);
	}
}
