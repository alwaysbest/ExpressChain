package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.Bill;

public interface BillDao extends JpaRepository<Bill, Integer>{
	public List<Bill> findAll();
	
}
