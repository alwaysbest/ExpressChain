package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.Business;

public interface BusniessDao extends JpaRepository<Business, Integer>{
	public Business findById(int id);
}
