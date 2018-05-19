package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.RouteWB;

public interface RouteWBDao extends JpaRepository<RouteWB, Integer>{
	public RouteWB findById(int id);
	public List<RouteWB> findBywId(int wId);
	public List<RouteWB> findBywbId(int wbId);
}
