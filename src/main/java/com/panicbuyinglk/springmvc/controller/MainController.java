package com.panicbuyinglk.springmvc.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.service.UserTypeService;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class.getName());

	@Autowired
	UserTypeService userTypeService;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping("/index")
	public String viewIndexPage() {
		return "index";
	}

	@RequestMapping("/register")
	public String viewRegisterPage(Model model) {
		ArrayList<UserType> list = (ArrayList<UserType>) userTypeService.getAllUserTypes();
		model.addAttribute("userTypes", list);
		return "register";
	}

	@RequestMapping("/login")
	public String viewLoginPage() {
		return "user-login";
	}

	@RequestMapping("/registerProductPage")
	public String viewProductRegistartionPage() {
		return "product-register";
	}

}
