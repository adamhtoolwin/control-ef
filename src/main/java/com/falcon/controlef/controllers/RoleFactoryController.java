package com.falcon.controlef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.controlef.models.RoleFactory;
import com.falcon.controlef.models.UserRole;

@RestController
@RequestMapping("/")
public class RoleFactoryController {
	
	private RoleFactory factory;
	
	@Autowired
	public RoleFactoryController(RoleFactory factory) {
		this.factory=factory;
	}
	
	//Create a new role (type) for the given name and id 
	@PostMapping("addNewRole/{type}/{name}/{id}")
	public UserRole addNewRole(@PathVariable String type, @PathVariable String name, @PathVariable String id) {
		UserRole role = this.factory.createRole(type);
		role.setName(name);
		role.setId(id);
		role.checkAccess();
		return role;
	}
}

