package com.exp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.RouteBBDao;
import com.exp.model.Order;
import com.exp.model.RouteBB;
import com.exp.service.OrderService;
@RestController
public class route {
	@Autowired
	OrderService orderService;
	@RequestMapping("/order")
	Order newOrder() {
		return orderService.getOrder("鞋子", "寄件者1", "收件者1", "18260019677", "18260029677", 1, 2, 1001, 1002, 0);
	}
}
