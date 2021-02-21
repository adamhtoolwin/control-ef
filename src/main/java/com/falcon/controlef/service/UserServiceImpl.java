package com.falcon.controlef.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.falcon.controlef.dao.RoleDao;
import com.falcon.controlef.dao.UserDao;
import com.falcon.controlef.models.Role;
import com.falcon.controlef.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private EmailService emailService;

	@Override
	public void save(User user) {
		String hashedPassword = bcryptEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setActive(true);

		Optional<Role> role = roleDao.findById(2);
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role.get());
		
		user.setRoles(roleSet);
		userdao.save(user);
		// if registration is successful -> send email
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(user.getEmail());
		emailMsg.setText("You are registered!");
		emailMsg.setSubject("Registration successful!");
		emailMsg.setFrom("admin@random.asia");

		try {
			emailService.sendEmail(emailMsg);
			System.out.println("successful");

		} catch (MailException ex) {
			System.err.println(ex.getMessage());// console message on error
		}

	}

	@Override
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}

}
