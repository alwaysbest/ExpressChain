package com.exp.service;

import com.exp.model.Order;

public interface OrderService {
	public Order getOrderById(int id);
	Order save(Order order);
	public String getOrderId();
	public Order getOrder(String product,String usName,String srName,String uSender,String uReceive,int eReceive,int eSender,int start,int end,int status);
}
