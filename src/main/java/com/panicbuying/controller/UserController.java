package com.panicbuying.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.panicbuying.entity.UserType;
import com.panicbuying.pojo.RegisterData;
import com.panicbuying.service.UserTypeService;


@RestController
public class UserController {
	
	Boolean succsess = true;
	Boolean error = false;

	@Autowired
	UserTypeService userTypeService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean viewRegisterPage(@RequestBody RegisterData regData) {

		System.out.println(regData.getEmail());
		System.out.println("registerUser");

		ArrayList<UserType> utlist = (ArrayList<UserType>) userTypeService.getAllUserTypes();
		
		System.out.println(utlist.get(0).getType());

		return error;
	}

}
