package com.panicbuyinglk.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.pojo.Logindata;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.ProductService;
import com.panicbuyinglk.springmvc.service.UserService;
import com.panicbuyinglk.springmvc.serviceimpl.ProductSeviceImpl;
import com.panicbuyinglk.springmvc.serviceimpl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductSeviceImpl productSeviceImpl;

	Boolean succsess = true;
	Boolean error = false;

	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean checkUserEmail(@RequestBody RegisterData regData) {

		User user = userService.getUserByEamil(regData.getEmail());

		if (null != user) {
			return error;
		} else {
			return succsess;
		}

	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean viewRegisterPage(@RequestBody RegisterData regData) {

		User savedUser = userServiceImpl.saveUser(regData);

		if (null != savedUser) {
			return succsess;
		} else {
			return error;
		}	

	}

	@RequestMapping(value = "/logUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean loginUser(@RequestBody Logindata logindata, HttpServletRequest request) {

		User loggedUser = userServiceImpl.logUser(logindata);

		if (null != loggedUser) {
			request.getSession().setAttribute("loggedUser", loggedUser);
			return succsess;
		} else {
			return error;
		}

	}	
	
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean updateUserDetails(@RequestBody RegisterData updData, HttpServletRequest request) {

		User u = (User) request.getSession().getAttribute("loggedUser");
		
		User updatedUser = userServiceImpl.updateUser(u,updData);	
		
		if (null != updatedUser) {			
			return succsess;
		} else {
			return error;
		}
	}	
	
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean changePassword(@RequestBody Logindata logindata, HttpServletRequest request) {

		User u = (User) request.getSession().getAttribute("loggedUser");
		
		User updatedUser = userServiceImpl.updatePaasword(u,logindata);	
		
		if (null != updatedUser) {			
			return succsess;
		} else {
			return error;
		}
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String destroySession(HttpServletRequest request, Model model) {

		request.getSession().invalidate();
		productSeviceImpl.loadIndexproducts(model);
		return "index";
	}

}
