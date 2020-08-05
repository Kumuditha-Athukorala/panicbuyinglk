package com.panicbuyinglk.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.service.ProductService;
import com.panicbuyinglk.springmvc.service.UserTypeService;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class.getName());
	
	@Autowired
	UserTypeService userTypeService;
	
	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
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
		
		return "index";
	}

	
	@RequestMapping("/register")
	public String viewRegisterPage(Model model) {
		ArrayList<UserType> list = (ArrayList<UserType>) userTypeService.getAllUserTypes();		
		list.remove(2);
		model.addAttribute("userTypes", list);
		return "register";
	}

	@RequestMapping("/login")
	public String viewLoginPage() {
		return "user-login";
	}

	@RequestMapping("/profile")
	public String viewProfilePage(HttpServletRequest request, Model model) {
		User loggeduser = (User) request.getSession().getAttribute("loggedUser");
		if(null == loggeduser) {
			return "user-login";
		}else {
			
			int ut_id = loggeduser.getUserType().getUsertype_id();
			String page =  "";
			
			switch (ut_id) {
			case 1:
				page = "profile-customer";
				break;

			case 2:
				page = "profile-seller";
				ArrayList<Product> prdList = (ArrayList<Product>) productService.getProductsByUser(loggeduser);
				model.addAttribute("userProductList", prdList);
				break;
			
			case 3:
				page = "profile-admin";
				ArrayList<Product> allProducts = (ArrayList<Product>) productService.getAllProducts();
				model.addAttribute("productList", allProducts);
				break;
			}
			return page;
		}
		
		
	}
}
