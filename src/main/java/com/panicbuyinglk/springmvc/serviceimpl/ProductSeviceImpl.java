package com.panicbuyinglk.springmvc.serviceimpl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.panicbuyinglk.springmvc.entity.Category;
import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.logger.PanicbuyingLKLogger;
import com.panicbuyinglk.springmvc.pojo.ProductData;
import com.panicbuyinglk.springmvc.service.CategoryService;
import com.panicbuyinglk.springmvc.service.ProductService;

@Service
public class ProductSeviceImpl {
	
	PanicbuyingLKLogger  lkLogger = new PanicbuyingLKLogger();
	
	final static Logger logger = LogManager.getLogger(ProductSeviceImpl.class);
	
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
		
		Product savedProduct = productService.saveProduct(product);
		String message = lkLogger.writeProductLogRecord(savedProduct,productData).toString();
		logger.debug(message);			
		
		return 	savedProduct;
	}

	public Product updateProductStatus(ProductData prData) {
		
		Product p = productService.getProdutById(prData.getProductId());		
		
		if(0 == prData.getStatus()) {
			p.setStatus(1);			
		}else if (1 == prData.getStatus()) {
			p.setStatus(0);
		}
		
		Product updatedProduct= productService.saveProduct(p);		
		return updatedProduct;		
	}
	
	public void loadIndexproducts(Model model) {
		
		ArrayList<Product> allProducts = (ArrayList<Product>) productService.getActiveProducts();		
		
		ArrayList<Product> listOfFruits = new ArrayList<Product>();
		ArrayList<Product> listOfVegitables = new ArrayList<Product>();
		ArrayList<Product> listofDiaryProducts = new ArrayList<Product>();
		
		for(Product p : allProducts) {
			if(1 == p.getCategory().getCategoryId()) {
				listOfFruits.add(p);
			}else if(2 == p.getCategory().getCategoryId()) {
				listOfVegitables.add(p);
			}else if(3 == p.getCategory().getCategoryId()) {
				listofDiaryProducts.add(p);
			}			
		}
		
		model.addAttribute("productList", allProducts);
		model.addAttribute("listOfFruits",listOfFruits);
		model.addAttribute("listOfVegitables",listOfVegitables);
		model.addAttribute("listofDiaryProducts",listofDiaryProducts);
	}

}
