package com.exp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.UserDao;
import com.exp.model.User;
import com.exp.service.UserService;
@Service
public  class UserImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findByuId(id);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
