package com.exp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.model.Employer;

public interface EmpDao extends JpaRepository<Employer, Integer>{
	public Employer findById(int id);
}
