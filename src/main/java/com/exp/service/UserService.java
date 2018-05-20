package com.exp.service;

import com.exp.model.User;

public interface UserService {
	public User getUserById(int id);
	public User saveUser(User user);
}
