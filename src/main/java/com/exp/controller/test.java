package com.exp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.RouteDao;
import com.exp.model.Route;
import com.exp.service.RouteService;

@RestController
public class test {
	
	@Autowired
	RouteService routeService;
	@RequestMapping("/user")
	String hello() {
		//UserDao userDao = null;
		
	return routeService.getShortestRoute(1001,1002);
		
	}
	
}
