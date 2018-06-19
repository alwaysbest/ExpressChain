package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.BusinessInfo;
//快递点信息
public interface BusinessInfoDao extends JpaRepository<BusinessInfo, Integer>{
	public BusinessInfo findById(int id);
	public List<BusinessInfo> findAll();
	public BusinessInfo findByname(String name);
}
