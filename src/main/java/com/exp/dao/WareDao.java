package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.Warehouse;

public interface WareDao extends JpaRepository<Warehouse, Integer>{
	public Warehouse findById(int id);
	public List<Warehouse> findBywoId(int woId);
	Warehouse save(Warehouse warehouse);
}
