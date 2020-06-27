package com.panicbuying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public String welcome() {
		System.out.println("indexxxxxxxxx");
		return "index.jsp";
	}
	
	@RequestMapping("/register")
	public String add() {
		System.out.println("register");
		return "register.jsp";
	}
	

}
