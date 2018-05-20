package com.exp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.RouteBBDao;
import com.exp.dao.UserDao;
import com.exp.model.User;
import com.exp.service.UserService;

@RestController
public class test {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/user")
	User hello() {
		//UserDao userDao = null;
		return userService.getUserById(1);
		
	}
	
}
