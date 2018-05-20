package com.exp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.Warehouse;

public interface WareDao extends JpaRepository<Warehouse, Integer>{
	public Warehouse findById(int id);
	public List<Warehouse> findBywoId(String woId);
	Warehouse save(Warehouse warehouse);
	@Modifying
	@Query(value="update Warehouse w set w.woIntime=?3 where w.woId=?1 and w.wId=?2 ")
	public void updatewoIntimeBywoIdAndwId(String woId,int wId,Date woIntime);
	@Modifying
	@Query(value="update Warehouse w set w.woOuttime=?3 where w.woId=?1 and w.wId=?2 ")
	public void updatewoOuttimeBywoIdAndwId(String woId,int wId,Date woOuttime);
}
