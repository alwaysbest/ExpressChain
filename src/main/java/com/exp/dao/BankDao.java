package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.Bank;

public interface BankDao extends JpaRepository<Bank, Integer>{
	public List<Bank> findAll();
	@Modifying
	@Query(value="update Bank b set b.money=?2 where b.account=?1")
	public void updatemoneyByaccount(int account,double money);
}
