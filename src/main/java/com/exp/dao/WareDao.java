package com.exp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.WareShelf;
import com.exp.model.Warehouse;

public interface WareDao extends JpaRepository<Warehouse, Integer>{
	
	public List<Warehouse> findBywoId(String woId);
	public List<Warehouse> findBywId(int wId);
	public List<Warehouse> findBysId(int sId);
	Warehouse save(Warehouse warehouse);
	@Modifying
	@Query(value="update Warehouse w set w.woIntime=?3 where w.woId=?1 and w.wId=?2 ")
	public void updatewoIntimeBywoIdAndwId(String woId,int wId,Date woIntime);
	@Modifying
	@Query(value="update Warehouse w set w.woOuttime=?3 where w.woId=?1 and w.wId=?2 ")
	public void updatewoOuttimeBywoIdAndwId(String woId,int wId,Date woOuttime);
	@Modifying
	@Query(value="update Warehouse w set w.wostatus=?3 where w.woId=?1 and w.wId=?2")
	public void updatewostatusBywoIdAndwId(String woId,int wId,int woStatus);
	@Query(value="select wostatus from Warehouse w where w.woId=?1 and w.wId=?2")
	public int findwostatusBywoIdAndwId(String woId,int wId);
	@Modifying
	@Query(value="update Warehouse w set w.sId=?3 where w.woId=?1 and w.wId=?2")
	public void updatesIdBywoIdAndwId(String woId,int wId,int sId);
}
