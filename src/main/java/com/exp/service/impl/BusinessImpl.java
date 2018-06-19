package com.exp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exp.dao.BusinessDao;
import com.exp.dao.BusinessInfoDao;
import com.exp.dao.MemberOrderDao;
import com.exp.model.Business;
import com.exp.model.BusinessInfo;
import com.exp.model.MemberOrder;
import com.exp.service.BusinessService;
@Service
@Transactional
public class BusinessImpl implements BusinessService{
	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private BusinessInfoDao businessInfoDao;
	@Autowired
	private MemberOrderDao memOrderDao;
	@Override
	public BusinessInfo getBusinessInfoById(int id) {
		// TODO Auto-generated method stub
		return businessInfoDao.findById(id);
	}

	
	@Override
	public List<Business> getBusinessBybOrder(String bOrder) {
		// TODO Auto-generated method stub
		return businessDao.findBybOrder(bOrder);
	}

	@Override
	public void updateOintime(String bOrder, int bId, Date oIntime) {
		// TODO Auto-generated method stub
		int status = 1;
		businessDao.updateoIntimeBybOrderAndbId(bOrder, bId, oIntime);
		updateOstatus(bOrder, bId, status);
	}

	@Override
	public void updateOouttime(String bOrder, int bId, Date oOuttime) {
		// TODO Auto-generated method stub
		int status = 2;
		businessDao.updateoOutimeBybOrderAndbId(bOrder, bId, oOuttime);
		updateOstatus(bOrder, bId, status);
	}

	@Override
	public Business save(Business business) {
		// TODO Auto-generated method stub
		return businessDao.save(business);
	}

	@Override
	public void updateOstatus(String bOrder, int bId, int status) {
		// TODO Auto-generated method stub
		businessDao.updateoStatusBybOrderAndbId(bOrder, bId, status);
	}

	

	@Override
	public List<Business> getBusinessBybId(int bid) {
		// TODO Auto-generated method stub
		return businessDao.findBybId(bid);
	}


	@Override
	public int getStatus(String bOrder, int id) {
		// TODO Auto-generated method stub
		return businessDao.findoStatusBybOrderAndbId(bOrder, id);
	}


	@Override
	public List<MemberOrder> getMemOrderBybId(int bid) {
		// TODO Auto-generated method stub
		return memOrderDao.findBybusid(bid);
	}

	
}
