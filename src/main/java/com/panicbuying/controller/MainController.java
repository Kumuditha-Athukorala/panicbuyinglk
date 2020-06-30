package com.panicbuying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panicbuying.dao.RegisterData;




@Controller
public class MainController {
		
	@RequestMapping("/index")
	public String welcome() {
		System.out.println("index page");
		return "index.jsp";
	}
	
	@RequestMapping(value = "/register", method  = RequestMethod.GET)
	public String add() {
		System.out.println("register page");
		return "register.jsp";
	}
	
	
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	@ResponseBody
	public String registerCustomer(@RequestBody RegisterData registerData) {
	
		System.out.println(registerData.getFirstName()+ " " + registerData.getLastName());
		System.out.println("customer registered..!!");		
		return "0";
	}

}
