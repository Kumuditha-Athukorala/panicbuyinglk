package com.panicbuying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String welcome() {
		System.out.println("indexxxxxxxxx");
		return "index.jsp";
	}
	
	@RequestMapping("/addValues")
	public String add() {
		System.out.println("addition");
		return "display.jsp";
	}
	

}
