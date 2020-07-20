package com.panicbuyinglk.springmvc.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.pojo.Logindata;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.UserService;

@Service
public class UserServiceImpl {

	@Autowired
	UserService userService;

	public User saveUser(RegisterData registerData) {

		try {
			User user = new User();
			UserType ut = new UserType();

			user.setFirstName(registerData.getFirstName());
			user.setLastName(registerData.getLastName());
			user.setGender(registerData.getGender());
			user.setPhone(registerData.getPhone());
			user.setAddress(registerData.getAddress());
			user.setEmail(registerData.getEmail());
			user.setPassword(registerData.getPassword());

			if ("Customer".equals(registerData.getUtype())) {
				ut.setUsertype_id(1);
				ut.setType(registerData.getUtype());
			} else if ("Seller".equals(registerData.getUtype())) {
				ut.setUsertype_id(2);
				ut.setType(registerData.getUtype());
			}
			user.setUserType(ut);
			return userService.saveUser(user);

		} catch (Exception e) {
			e.printStackTrace();
			return new User();
		}

	}

	public User logUser(Logindata logindata) {
		
		String username = logindata.getEmail();
		String password = logindata.getPassword();
		
		ArrayList<User> ulist = (ArrayList<User>) userService.getLoggedUser(username, password);
		
		System.out.println("loggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
		System.out.println(ulist.size() + " " + ulist.get(0).getFirstName());
		
		return ulist.get(0);
	}

}
