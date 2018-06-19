package com.exp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.BillDao;
import com.exp.model.Bill;
import com.exp.service.BillService;
@Service
public class BillImpl implements BillService{
	@Autowired
	BillDao billDao;

	@Override
	public List<Bill> getAll() {
		// TODO Auto-generated method stub
		return billDao.findAll();
	}

}
