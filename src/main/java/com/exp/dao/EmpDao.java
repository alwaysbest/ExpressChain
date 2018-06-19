package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.Employer;

public interface EmpDao extends JpaRepository<Employer, Integer>{
	public Employer findByeId(int eId);
	public List<Employer> findAll();
	@Modifying
	@Query(value="update Employer e set e.type=?2 where e.eId=?1")
	public void updateType(int eId,int type);
}
