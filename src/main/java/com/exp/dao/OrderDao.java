package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	public Order findByoId(String id);
	Order save(Order order);
}
