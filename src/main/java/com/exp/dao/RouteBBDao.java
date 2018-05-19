package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.RouteBB;

public interface RouteBBDao extends JpaRepository<RouteBB, Integer>{
	public RouteBB findById(int id);
}
