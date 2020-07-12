package com.panicbuyinglk.springmvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.UserService;
import com.panicbuyinglk.springmvc.service.UserTypeService;

@Controller
public class UserController {

	@Autowired
	UserTypeService userTypeService;

	@Autowired
	UserService userService;

	Boolean succsess = true;
	Boolean error = false;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean viewRegisterPage(@RequestBody RegisterData regData) {

		System.out.println(regData.getEmail());
		System.out.println("registerUser");
		
		 ArrayList<UserType> typeList = (ArrayList<UserType>)
		 userTypeService.getAllUserTypes();
		 System.out.println(typeList.get(0).getType());
		 

		ArrayList<User> userList = (ArrayList<User>) userService.getAllUsers();

		System.out.println(userList.get(0).getFirstName());

		return error;
	}

}
