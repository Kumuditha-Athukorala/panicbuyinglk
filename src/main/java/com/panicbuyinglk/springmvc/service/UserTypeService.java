package com.panicbuyinglk.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.UserType;
import com.panicbuyinglk.springmvc.repository.UserTypeRepository;

@Service
public class UserTypeService {
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	public List<UserType> getAllUserTypes(){
		return userTypeRepository.findAll();
	}

}
