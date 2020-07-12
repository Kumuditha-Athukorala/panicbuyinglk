package com.panicbuying.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panicbuying.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
