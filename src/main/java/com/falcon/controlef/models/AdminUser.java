package com.falcon.controlef.models;

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

	

}
