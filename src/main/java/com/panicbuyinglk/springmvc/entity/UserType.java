package com.panicbuyinglk.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserType {

	@Id
	@GeneratedValue
	@Column(name="usertype_id")
	private int usertype_id;
	
	@Column(name="type")
	private String type;
	
	public UserType() {
		
	}

	
	public String getType() {
		return type;
	}

	public int getUsertype_id() {
		return usertype_id;
	}

	public void setUsertype_id(int usertype_id) {
		this.usertype_id = usertype_id;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
