package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
	User findByuId(int id);
	User save(User user);
}
