package com.panicbuyinglk.springmvc.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.panicbuyinglk.springmvc.entity.Category;
import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.logger.PanicbuyingLKLogger;
import com.panicbuyinglk.springmvc.pojo.ProductData;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.serviceimpl.ProductSeviceImpl;



@Controller
public class ProductController {	

	final static Logger logger = LogManager.getLogger(UserController.class);
	
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

			try {
				
				String logRecordType = "product_registration_request";

				String productId = "<productid>" + savedProduct.getProductId() + "</productid>";
				String productName = "<productname>" + productData.getProductName() + "</productname>";
				String qty = "<quantity>" + productData.getQyt() + "</quantity>";
				String category = "<category>" + productData.getCategory() + "</category>";
				String seller = "<seller>" + productData.getRegisteredUser().getEmail() + "</seller>";
				

				StringBuffer buildLogRecord = new StringBuffer();
				buildLogRecord.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				buildLogRecord.append("<productregistrationrequest status=\"N\">");
				buildLogRecord.append(productId);
				buildLogRecord.append(productName);
				buildLogRecord.append(qty);
				buildLogRecord.append(category);
				buildLogRecord.append(seller);
				
				buildLogRecord.append("</productregistrationrequest>");

				PanicbuyingLKLogger lkLogger = new PanicbuyingLKLogger();
				String message = lkLogger.writeProductLogRecord(buildLogRecord, logRecordType, productId,productName, qty, category, seller)
						.toString();

				logger.debug(message);
				
				return "index";

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return "index";
		}
				
		return "index";
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
