package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exp.model.Business;

public interface BusniessDao extends JpaRepository<Business, Integer>{
	public Business findById(int id);
	public List<Business> findBybOrder(String bOrder);
	Business save(Business business);
}
