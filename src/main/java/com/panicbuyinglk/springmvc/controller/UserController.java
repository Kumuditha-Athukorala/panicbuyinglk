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
import com.panicbuyinglk.springmvc.serviceimpl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;

	Boolean succsess = true;
	Boolean error = false;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean viewRegisterPage(@RequestBody RegisterData regData) {

		userServiceImpl.saveUser(regData);
	
		return error;
	}

}
