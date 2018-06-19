package com.exp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.BankDao;
import com.exp.model.Bank;
import com.exp.service.BankService;
@Service
public class BankImpl implements BankService {
	@Autowired
	private BankDao bankDao;
	@Override
	public List<Bank> getAll() {
		// TODO Auto-generated method stub
		return bankDao.findAll();
	}

	@Override
	public void updateMoney(int account, double money) {
		// TODO Auto-generated method stub
		bankDao.updatemoneyByaccount(account, money);
	}

}
