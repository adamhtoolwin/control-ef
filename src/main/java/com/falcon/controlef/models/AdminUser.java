package com.falcon.controlef.models;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AdminUser implements UserRole{

	private String id;
	private String name;
	
	public AdminUser() {
		super();
	}
	
	@Override
	public void setName(String name) {
		this.name=name;
		
	}

	@Override
	public void setId(String id) {
		this.id=id;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "User-ADMIN";
	}
	
	@Override
	public void checkAccess() {
		System.out.println("Granted Access: Administrative Privileges");
	
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id", referencedColumnName = "id") 
	@JsonIgnore
	@MapsId
	private User user;

}
