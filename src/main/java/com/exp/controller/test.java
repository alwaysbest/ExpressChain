package com.exp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.UserDao;
import com.exp.model.User;

@RestController
public class test {
	
	@Autowired
	UserDao userDao;
	@RequestMapping("/user")
	User hello() {
		//UserDao userDao = null;
		User user=new User();
		user.setuId(1);
		user.setuName("刘银");
		user.setuTelephone("18260039677");
		userDao.save(user);
		System.out.println(userDao.findByuId(1));
		return userDao.findByuId(1);
		
	}
}
