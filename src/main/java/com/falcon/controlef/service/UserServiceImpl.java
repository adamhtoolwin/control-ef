package com.falcon.controlef.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.falcon.controlef.dao.UserDao;
import com.falcon.controlef.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private EmailService emailService;

	@Override
	public void save(User user) {
		System.out.println("here");
		String hashedPassword = bcryptEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setActive(true);
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
