package com.exp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.RouteBBDao;
import com.exp.model.RouteBB;
@RestController
public class route {
	@Autowired
	RouteBBDao routeBBDao;
	@RequestMapping("/route")
	List<RouteBB> getRoute(){
		return routeBBDao.findAll();
	}
}
