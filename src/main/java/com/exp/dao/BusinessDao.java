package com.exp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.Business;

public interface BusinessDao extends JpaRepository<Business, Integer>{
	public Business findById(int id);
	public List<Business> findBybOrder(String bOrder);
	Business save(Business business);
	@Modifying
	@Query(value="update Business b set b.oIntime=?3 where b.bOrder=?1 and b.bId=?2 ")
	public void updateoIntimeBybOrderAndbId(String bOrder,int bId,Date oIntime);
	@Modifying
	@Query(value="update Business b set b.oOuttime=?3 where b.bOrder=?1 and b.bId=?2 ")
	public void updateoOutimeBybOrderAndbId(String bOrder,int bId,Date oOuttime);
}
