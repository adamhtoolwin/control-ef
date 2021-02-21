package com.falcon.controlef.service;

import com.falcon.controlef.models.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
