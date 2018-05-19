package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.RouteWW;

public interface RouteWWDao extends JpaRepository<RouteWW, Integer>{
	public RouteWW findById(int id);
}
