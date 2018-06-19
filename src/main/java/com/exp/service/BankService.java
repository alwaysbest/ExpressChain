package com.exp.service;

import java.util.List;

import com.exp.model.Bank;

public interface BankService {
	public List<Bank> getAll();
	public void updateMoney(int account,double money);
}
