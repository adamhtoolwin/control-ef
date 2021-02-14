package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class RoleFactory {

	public UserRole createRole(String role) {
		switch(role) {
		case "admin":
			return new AdminUser();
		case "member":
			return new RegisteredUser();
		default:
			throw new UnsupportedOperationException("Please Register");
		}
	}
}
