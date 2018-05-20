package com.exp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.BusinessDao;
import com.exp.dao.BusinessInfoDao;
import com.exp.model.Business;
import com.exp.model.BusinessInfo;
import com.exp.service.BusinessService;
@Service
public class BusinessImpl implements BusinessService{
	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private BusinessInfoDao businessInfoDao;
	@Override
	public BusinessInfo getBusinessInfoById(int id) {
		// TODO Auto-generated method stub
		return businessInfoDao.findById(id);
	}

	@Override
	public Business getBusinessById(int id) {
		// TODO Auto-generated method stub
		return businessDao.findById(id);
	}

	@Override
	public List<Business> getBusinessBybOrder(String bOrder) {
		// TODO Auto-generated method stub
		return businessDao.findBybOrder(bOrder);
	}

	@Override
	public void updateOintime(String bOrder, int bId, Date oIntime) {
		// TODO Auto-generated method stub
		businessDao.updateoIntimeBybOrderAndbId(bOrder, bId, oIntime);
	}

	@Override
	public void updateOouttime(String bOrder, int bId, Date oOuttime) {
		// TODO Auto-generated method stub
		businessDao.updateoOutimeBybOrderAndbId(bOrder, bId, oOuttime);
	}

	@Override
	public Business save(Business business) {
		// TODO Auto-generated method stub
		return businessDao.save(business);
	}

	
}
