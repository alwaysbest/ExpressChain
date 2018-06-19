package com.exp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.Business;

public interface BusinessDao extends JpaRepository<Business, Integer>{
	
	public List<Business> findBybOrder(String bOrder);
	public List<Business> findBybId(int bId);
	Business save(Business business);
	@Modifying
	@Query(value="update Business b set b.oIntime=?3 where b.bOrder=?1 and b.bId=?2 ")
	public void updateoIntimeBybOrderAndbId(String bOrder,int bId,Date oIntime);
	@Modifying
	@Query(value="update Business b set b.oOuttime=?3 where b.bOrder=?1 and b.bId=?2 ")
	public void updateoOutimeBybOrderAndbId(String bOrder,int bId,Date oOuttime);
	@Modifying
	@Query(value="update Business b set b.oStatus =?3 where b.bOrder=?1 and b.bId=?2")
	public void updateoStatusBybOrderAndbId(String bOrder,int bId,int oStatus);
	
	@Query(value="select oIntime from Business b where b.bOrder=?1 and b.bId=?2")
	public Date findoIntimeBybOrderAndbId(String bOrder,int bId);
	
	@Query(value="select oOuttime from Business b where b.bOrder=?1 and b.bId=?2")
	public Date findoOuttimeBybOrderAndbId(String bOrder,int bId);
	
	@Query(value="select oStatus from Business b where b.bOrder=?1 and b.bId=?2")
	public int findoStatusBybOrderAndbId(String bOrder,int bId);
	
}
