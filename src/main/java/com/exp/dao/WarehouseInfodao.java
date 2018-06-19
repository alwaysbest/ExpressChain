package com.exp.dao;

import java.util.List;


import org.mockito.internal.matchers.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.WareShelf;
import com.exp.model.WarehouseInfo;

public interface WarehouseInfodao extends JpaRepository<WarehouseInfo, Integer> {
	public WarehouseInfo findById(int id);
	public List<WarehouseInfo> findAll();
	
	@Modifying
	@Query(value="update WarehouseInfo w set w.storage=?2 where w.id=?1")
	public void updatestorageById(int id,int storage);
	public WarehouseInfo findByname(String name);
	
}
