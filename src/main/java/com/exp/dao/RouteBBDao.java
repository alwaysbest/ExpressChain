package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.RouteBB;

public interface RouteBBDao extends JpaRepository<RouteBB, Integer>{
	public RouteBB findById(int id);
	public List<RouteBB> findBybId(int bId);
	public List<RouteBB> findBybbId(int bbId);
	public List<RouteBB> findAll();
}
