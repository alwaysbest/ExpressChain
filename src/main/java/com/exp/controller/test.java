package com.exp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.RouteDao;
import com.exp.model.Route;
import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;
import com.exp.service.RouteService;
import com.exp.service.WareService;

@RestController
public class test {
	
	@Autowired
	WareService wareService;
	@RequestMapping("/test")
	void  hello() {
		//UserDao userDao = null;
		
		wareService.buildShelf(2002,200203, "货架", 1000);
		
	}
	
}
