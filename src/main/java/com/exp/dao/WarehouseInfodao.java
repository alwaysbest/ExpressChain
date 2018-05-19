package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.WarehouseInfo;

public interface WarehouseInfodao extends JpaRepository<WarehouseInfo, Integer> {
	public WarehouseInfo findById(int id);
}
