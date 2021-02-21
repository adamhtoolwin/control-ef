package com.falcon.controlef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.falcon.controlef.dao.UserDao;
import com.falcon.controlef.models.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// This service simplifies the finding of the user by talking to dao
		User user = userDao.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("User 404");

		return new UserDetailsImpl(user);
	}

}
