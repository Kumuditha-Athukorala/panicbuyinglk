package com.panicbuying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public String welcome() {
		System.out.println("index page");
		return "index.jsp";
	}
	
	@RequestMapping("/register")
	public String add() {
		System.out.println("register page");
		return "register.jsp";
	}
	 
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	@ResponseBody
	public String checkEmail() {
		System.out.println("email checker..!!");		
		return "0";
	}
	
	
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	@ResponseBody
	public String registerCustomer() {
		System.out.println("customer registered..!!");		
		return "0";
	}

}
