package com.panicbuyinglk.springmvc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.UserService;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserService userService;
	
	
	public User saveUser(RegisterData registerData) {
		
		User user = new User();
		user.setFirstName(registerData.getFirstName());
		user.setLastName(registerData.getFirstName());
		user.setGender(registerData.getGender());
		user.setPhone(registerData.getPhone());
		user.setAddress(registerData.getAddress());
		user.setEmail(registerData.getEmail());
		user.setPassword(registerData.getPassword());
		
		UserType ut = new UserType();
		ut.setUsertype_id(1);
		ut.setType(registerData.getUtype());
		user.setUserType(ut);
		
		return userService.saveUser(user);
		
	}

}
