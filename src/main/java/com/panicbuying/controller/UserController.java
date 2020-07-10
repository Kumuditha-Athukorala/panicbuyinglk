package com.panicbuying.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.panicbuying.pojo.RegisterData;


@RestController
public class UserController {

	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewRegisterPage(@RequestBody RegisterData regData) {	
			
		
		System.out.println(regData.getEmail());
		System.out.println("registerUser");
		return "index";
	}

}
