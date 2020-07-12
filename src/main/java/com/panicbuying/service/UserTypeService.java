package com.panicbuying.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuying.entity.UserType;
import com.panicbuying.repository.UserTypeRepository;

@Service
public class UserTypeService {

	@Autowired
	private UserTypeRepository userTypeRepository;
	
	public List<UserType> getAllUserTypes(){
		return userTypeRepository.findAll();
	}
}
