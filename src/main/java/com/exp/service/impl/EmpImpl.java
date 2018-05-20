package com.exp.service.impl;

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

}
