package com.panicbuyinglk.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.logger.PanicbuyingLKLogger;
import com.panicbuyinglk.springmvc.pojo.Logindata;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.UserService;
import com.panicbuyinglk.springmvc.serviceimpl.UserServiceImpl;

@Controller
public class UserController {

	final static Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserService userService;

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

			try {

				String logRecordType = "user_registraion_request";

				String userId = "<userid>" + savedUser.getUserId() + "</userid>";
				String userFirstName = "<userfirstname>" + savedUser.getFirstName() + "</userfirstname>";
				String userLastName = "<userlastname>" + savedUser.getLastName() + "</userlastname>";
				String userGender = "<usergender>" + savedUser.getGender() + "</usergender>";
				String userType = "<usertype>" + savedUser.getUserType().getType() + "</usertype>";
				String userPhone = "<userphone>" + savedUser.getPhone() + "</userphone>";
				String userAddress = "<useraddress>" + savedUser.getAddress() + "</useraddress>";
				String userEmail = "<useremail>" + savedUser.getEmail() + "</useremail>";

				StringBuffer buildLogRecord = new StringBuffer();
				buildLogRecord.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				buildLogRecord.append("<userregistrationrequest status=\"N\">");
				buildLogRecord.append(userId);
				buildLogRecord.append(userFirstName);
				buildLogRecord.append(userLastName);
				buildLogRecord.append(userGender);
				buildLogRecord.append(userType);
				buildLogRecord.append(userPhone);
				buildLogRecord.append(userAddress);
				buildLogRecord.append(userEmail);
				buildLogRecord.append("</userregistrationrequest>");

				PanicbuyingLKLogger lkLogger = new PanicbuyingLKLogger();
				String message = lkLogger.writeLogRecord(buildLogRecord, logRecordType, userId, userGender, userType)
						.toString();

				logger.debug(message);
				return succsess;

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return error;
		}
		return error;

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
	
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String destroySession(HttpServletRequest request) {

		request.getSession().invalidate();
		return "index";
	}

}
