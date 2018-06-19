package com.exp.service;

import java.util.List;

import com.exp.model.User;

public interface UserService {
	public User getUserById(int id);
	public User saveUser(User user);
	public List<User> findAll();
}
