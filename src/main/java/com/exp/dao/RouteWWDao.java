package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.RouteWW;

public interface RouteWWDao extends JpaRepository<RouteWW, Integer>{
	public RouteWW findById(int id);
	public List<RouteWW> findBywId(int wId);
	public List<RouteWW> findBywwId(int wwId);
}
