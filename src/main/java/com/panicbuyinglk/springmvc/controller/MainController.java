package com.panicbuyinglk.springmvc.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class.getName());


	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping("/index")
	public String viewIndexPage() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String viewRegisterPage() {
		return "register";
	}

	@RequestMapping("/login")
	public String viewLoginPage() {
		return "user_login";
	}

}
