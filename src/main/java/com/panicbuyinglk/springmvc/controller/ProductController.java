package com.panicbuyinglk.springmvc.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.panicbuyinglk.springmvc.pojo.ProductData;
import com.panicbuyinglk.springmvc.serviceimpl.ProductSeviceImpl;



@Controller
public class ProductController {	

	@Autowired
	ProductSeviceImpl productSeviceImpl;
	
	Boolean succsess = true;
	Boolean error = false;
	
	@RequestMapping(value = "/registerProduct", method = RequestMethod.POST)
	public @ResponseBody Boolean registerProduct(HttpServletRequest request, final @RequestParam("image") MultipartFile file) throws IOException {
		
				
		byte[] imgData = file.getBytes();
		
		ProductData productData = new ProductData();
		
		productData.setProductName(request.getParameter("pname"));
		productData.setUnitPrice(Double.parseDouble(request.getParameter("price")));
		productData.setQyt(Integer.parseInt(request.getParameter("qty")));
		productData.setDescription(request.getParameter("description"));
		productData.setImage(imgData);
		productData.setCategory(request.getParameter("category"));		
		productData.setStatus(0);
	
		productSeviceImpl.saveProduct(productData);
		
		
		
		return true;
	}
}
