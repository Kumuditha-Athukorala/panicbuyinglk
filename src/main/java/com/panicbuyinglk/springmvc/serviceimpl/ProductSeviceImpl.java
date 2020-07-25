package com.panicbuyinglk.springmvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.Category;
import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.pojo.ProductData;
import com.panicbuyinglk.springmvc.service.ProductService;

@Service
public class ProductSeviceImpl {
	
	@Autowired
	ProductService productService;
	
	public Product saveProduct(ProductData productData) {
		
		
		Product product = new Product();
		Category category = new Category();
		
		product.setProductName(productData.getProductName());
		product.setQty(productData.getQyt());
		product.setUnitPrice(productData.getUnitPrice());
		product.setImage(productData.getImage());
		product.setDescription(productData.getDescription());
		product.setStatus(productData.getStatus());
		
		if ("AAA".equals(productData.getCategory())) {
			category.setCategoryId(1);
			category.setCategoryName(productData.getCategory());
		} else if ("BBB".equals(productData.getCategory())) {
			category.setCategoryId(2);
			category.setCategoryName(productData.getCategory());
		}
		
		product.setCategory(category);
		
		return productService.saveProduct(product);
		
	}

}
