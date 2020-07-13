package com.panicbuyinglk.springmvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.UserService;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserService userService;
	
	
	public User saveUser(RegisterData registerData) {
		
		System.out.println(registerData.getEmail());		
		return null;
		
	}

}
