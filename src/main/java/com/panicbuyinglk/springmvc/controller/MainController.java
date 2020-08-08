package com.panicbuyinglk.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panicbuyinglk.springmvc.entity.Category;
import com.panicbuyinglk.springmvc.entity.Product;
import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.entity.UserType;

import com.panicbuyinglk.springmvc.service.CategoryService;
import com.panicbuyinglk.springmvc.service.ProductService;
import com.panicbuyinglk.springmvc.service.UserTypeService;

import com.panicbuyinglk.springmvc.serviceimpl.ProductSeviceImpl;

@Controller
public class MainController {
	
	@Autowired
	UserTypeService userTypeService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductSeviceImpl productSeviceImpl;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
				
		productSeviceImpl.loadIndexproducts(model);
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
	public String viewLoginPage(HttpServletRequest request,Model model) {
		
		User loggeduser = (User) request.getSession().getAttribute("loggedUser");
		
		if(null == loggeduser) {
			return "user-login";
		}else {
			productSeviceImpl.loadIndexproducts(model);
			return "index";
		}
		
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
				ArrayList<Category> catList = (ArrayList<Category>) categoryService.getAllproductCategories();
				model.addAttribute("userProductList", prdList);
				model.addAttribute("categoryList",catList);
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
