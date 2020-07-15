package com.panicbuyinglk.springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panicbuyinglk.springmvc.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer>{
	
	

}
