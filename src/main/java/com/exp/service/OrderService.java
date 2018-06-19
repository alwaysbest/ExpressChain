package com.exp.service;

import com.exp.model.Order;

public interface OrderService {
	public Order getOrderById(String id);
	Order save(Order order);
	public String getOrderId();
	
	public Order getOrder(String product,String usName,String srName,String uSender,String uReceive,int eReceive,int start,int end,int status);
	public String getRoute(String Order);
	public String getNext(String route,String name);
}
