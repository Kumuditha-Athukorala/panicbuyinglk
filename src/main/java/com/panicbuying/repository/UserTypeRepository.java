package com.panicbuying.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panicbuying.entity.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
