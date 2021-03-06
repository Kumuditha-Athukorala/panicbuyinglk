package com.panicbuyinglk.springmvc.serviceimpl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.logger.PanicbuyingLKLogger;
import com.panicbuyinglk.springmvc.pojo.Logindata;
import com.panicbuyinglk.springmvc.pojo.RegisterData;
import com.panicbuyinglk.springmvc.service.UserService;
import com.panicbuyinglk.springmvc.service.UserTypeService;

@Service
public class UserServiceImpl {
	
	PanicbuyingLKLogger  lkLogger = new PanicbuyingLKLogger();
	
	final static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserTypeService userTypeService;


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

			ArrayList<UserType> userTypes = (ArrayList<UserType>) userTypeService.getAllUserTypes();
			
			for (UserType uty : userTypes) {
				
				if(uty.getType().equals(registerData.getUtype())) {
					ut.setUsertype_id(uty.getUsertype_id());
					ut.setType(uty.getType());
					user.setUserType(ut);
					break;
				}
				
			}		
			
			User savedUser = userService.saveUser(user);
			
			String message = lkLogger.writeUserLogRecord(savedUser).toString();
			logger.debug(message);
			return savedUser;

		} catch (Exception e) {
			String error = lkLogger.writeErrorLogRecord(e).toString();			
			logger.debug(error);
			return null;
		}

	}

	public User logUser(Logindata logindata) {

		String username = logindata.getEmail();
		String password = logindata.getPassword();

		try {
			User loggedUser = userService.getLoggedUser(username, password);			
			return loggedUser;
		} catch (Exception e) {
			String error = lkLogger.writeErrorLogRecord(e).toString();			
			logger.debug(error);
			return null;
		}

	}

	public User updateUser(User u, RegisterData updData) {

		try {

			u.setAddress(updData.getAddress());
			u.setFirstName(updData.getFirstName());
			u.setLastName(updData.getLastName());
			u.setGender(updData.getGender());
			u.setPhone(updData.getPhone());

			return userService.saveUser(u);

		} catch (Exception e) {
			String error = lkLogger.writeErrorLogRecord(e).toString();			
			logger.debug(error);
			return null;
		}

	}

	public User updatePaasword(User u, Logindata logindata) {
		
		try {
			u.setPassword(logindata.getPassword());
			return userService.saveUser(u);
		} catch (Exception e) {
			String error = lkLogger.writeErrorLogRecord(e).toString();			
			logger.debug(error);
			return null;
		}
	}

	
}
