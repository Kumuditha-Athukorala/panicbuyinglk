package com.panicbuyinglk.springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.panicbuyinglk.springmvc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM user u WHERE u.email = :email AND u.password= :password", nativeQuery = true)
	User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query(value = "SELECT * FROM user u WHERE u.email = :email", nativeQuery = true)
	User findUserByEmail(@Param("email") String email);	
	
}
