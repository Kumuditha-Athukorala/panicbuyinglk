package com.panicbuyinglk.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	} 
	
	@RequestMapping("/register")
	public String viewRegisterPage() {
		return "register";
	} 
	
	
}
