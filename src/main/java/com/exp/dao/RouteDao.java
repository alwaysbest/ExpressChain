package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.Edge;
import com.exp.model.Route;

public interface RouteDao extends JpaRepository<Route, Integer>{
	public List<Route> findAll();
	@Query(value="select startName from Route r where r.id=?1")
	public String findStartNameById(int id);
	
}
