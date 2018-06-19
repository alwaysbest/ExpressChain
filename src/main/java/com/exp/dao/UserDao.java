package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
	public User findByuId(int id);
	User save(User user);
	public List<User> findAll();
	
}
