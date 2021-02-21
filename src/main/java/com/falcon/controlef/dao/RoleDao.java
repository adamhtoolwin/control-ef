package com.falcon.controlef.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falcon.controlef.models.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
