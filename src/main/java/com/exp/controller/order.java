package com.exp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.service.OrderService;

@RestController
public class order {
	@Autowired
	OrderService orderService;
	@RequestMapping("/routetest")
	String printRoute() {
		return orderService.getRoute("20180523213956100007");
	}
}
