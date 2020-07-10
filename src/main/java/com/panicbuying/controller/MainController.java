package com.panicbuying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public ModelAndView viewIndexPage() {
		
		System.out.println("index page");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView viewRegisterPage() {
		
		System.out.println("user register page");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		
		return mv;
	}

}
