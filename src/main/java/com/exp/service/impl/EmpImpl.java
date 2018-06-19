package com.exp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.EmpDao;
import com.exp.model.Employer;
import com.exp.service.EmpService;
@Service
public class EmpImpl implements EmpService{
@Autowired
private EmpDao empDao;
	@Override
	public Employer getEmpById(int id) {
		// TODO Auto-generated method stub
		return empDao.findByeId(id);
	}
	@Override
	public List<Employer> getAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}
	@Override
	public void updateType(int id, int type) {
		// TODO Auto-generated method stub
		empDao.updateType(id, type);
	}

}
