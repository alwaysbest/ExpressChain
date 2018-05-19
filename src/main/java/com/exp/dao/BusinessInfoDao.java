package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.BusinessInfo;

public interface BusinessInfoDao extends JpaRepository<BusinessInfo, Integer>{
	public BusinessInfo findById(int id);
}
