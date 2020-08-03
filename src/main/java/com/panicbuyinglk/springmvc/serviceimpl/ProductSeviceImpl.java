package com.panicbuyinglk.springmvc.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.Category;
import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.pojo.ProductData;
import com.panicbuyinglk.springmvc.service.CategoryService;
import com.panicbuyinglk.springmvc.service.ProductService;

@Service
public class ProductSeviceImpl {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService  categoryService;
	
	public Product saveProduct(ProductData productData) {
		
		
		Product product = new Product();
		Category category = new Category();
		
		product.setProductName(productData.getProductName());
		product.setQty(productData.getQyt());
		product.setUnitPrice(productData.getUnitPrice());
		product.setImage(productData.getImage());
		product.setDescription(productData.getDescription());
		product.setStatus(productData.getStatus());
		product.setRegisteredDate(productData.getRegisterDate());
		product.setRegisterUser(productData.getRegisteredUser());
		
		
		ArrayList<Category>  productCategories =  (ArrayList<Category>) categoryService.getAllproductCategories();
		
		for(Category cat:productCategories) {
			if(cat.getCategoryName().equals(productData.getCategory())) {
				category.setCategoryId(cat.getCategoryId());
				category.setCategoryName(cat.getCategoryName());
				break;
			}
		}
						
		product.setCategory(category);
		
		return productService.saveProduct(product);
		
	}

}
