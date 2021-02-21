package com.falcon.controlef.dao;

import com.falcon.controlef.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    
}
