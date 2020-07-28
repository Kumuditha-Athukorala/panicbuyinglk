package com.panicbuyinglk.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panicbuyinglk.springmvc.entity.User;
import com.panicbuyinglk.springmvc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User u) {
		return userRepository.save(u);
	}
	
	public User getLoggedUser(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}

	public User getUserByEamil(String email) {
		return userRepository.findUserByEmail(email);
	}	
	
}
