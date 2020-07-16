package com.panicbuyinglk.springmvc.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class.getName());
	 

	@Value("${property.filename}")
	String lang;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping("/register")
	public String viewRegisterPage() {
		performSomeTask();
		return "register";
	}

	public void performSomeTask() {
		
		  logger.debug("This is a debug message");
		  logger.info("This is an info message");
		  logger.warn("This is a warn message");
		  logger.error("This is an error message");
		  logger.fatal("This is a fatal message");
		 
	}

}
