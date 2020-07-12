package com.panicbuyinglk.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserType {

	private int usertype_Id;
	private String type;
	
	public UserType() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUsertype_Id() {
		return usertype_Id;
	}

	public void setUsertype_Id(int usertype_Id) {
		this.usertype_Id = usertype_Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
