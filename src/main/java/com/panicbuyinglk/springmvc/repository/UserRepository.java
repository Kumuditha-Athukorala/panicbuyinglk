package com.panicbuyinglk.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panicbuyinglk.springmvc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	
}
