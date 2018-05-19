package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.RouteWB;

public interface RouteWBDao extends JpaRepository<RouteWB, Integer>{
	public RouteWB findById(int id);
}
