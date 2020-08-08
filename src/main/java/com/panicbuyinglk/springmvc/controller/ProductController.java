package com.panicbuyinglk.springmvc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.logger.PanicbuyingLKLogger;
import com.panicbuyinglk.springmvc.pojo.ProductData;
import com.panicbuyinglk.springmvc.serviceimpl.ProductSeviceImpl;


@Controller
public class ProductController {	
	
	@Autowired
	ProductSeviceImpl productSeviceImpl;
	
	Boolean succsess = true;
	Boolean error = false;
	
	@RequestMapping(value = "/registerProduct", method = RequestMethod.POST)
	public String registerProduct(HttpServletRequest request, final @RequestParam("image") MultipartFile file, Model model) throws IOException {
		
		User user = (User) request.getSession().getAttribute("loggedUser");
		byte[] imgData = file.getBytes();
		
		ProductData productData = new ProductData();
		
		productData.setProductName(request.getParameter("pname"));
		productData.setUnitPrice(Double.parseDouble(request.getParameter("price")));
		productData.setQyt(Integer.parseInt(request.getParameter("qty")));
		productData.setDescription(request.getParameter("description"));
		productData.setImage(imgData);
		productData.setCategory(request.getParameter("category"));		
		productData.setStatus(0);
		productData.setRegisteredUser(user);
		productData.setRegisterDate(new Date());
	
		Product savedProduct = productSeviceImpl.saveProduct(productData);
		productSeviceImpl.loadIndexproducts(model);
		
		
		if (null != savedProduct) {			
			
			return "index";
		} else {
			return "index";
		}
	}	
	
	
	@RequestMapping(value = "/changeProductStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean changeProductStatus(@RequestBody ProductData product){
		
	System.out.println(product.getProductId());
	System.out.println(product.getStatus());
	
	 Product updatedProduct= productSeviceImpl.updateProductStatus(product);
	 
	 if(null != updatedProduct) {
		 return succsess;
	 }else {
		 return error;
	 }
		
	}
	
	
}
