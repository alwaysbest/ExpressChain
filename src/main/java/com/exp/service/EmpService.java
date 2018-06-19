package com.exp.service;

import java.util.List;

import com.exp.model.Employer;

public interface EmpService {
	public Employer getEmpById(int id);
	public List<Employer> getAll();
	public void updateType(int id,int type);
}
