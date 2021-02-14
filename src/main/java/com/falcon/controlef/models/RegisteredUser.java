package com.example.demo.models;

public class RegisteredUser implements UserRole{

	private String id;
	private String name;
	
	public RegisteredUser() {
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
		return "User-REGISTERED";
	}
	
	@Override
	public void checkAccess() {
		System.out.println("Granted Access: Basic Level");
	
	}

}
