package com.example.demo.models;

public interface UserRole {
	void setName (String name);
	void setId(String id);
	String getName();
	String getId();
	String getRole();
	void checkAccess();
}
