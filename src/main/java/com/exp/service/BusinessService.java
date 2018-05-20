package com.exp.service;

import java.util.Date;
import java.util.List;

import com.exp.model.Business;
import com.exp.model.BusinessInfo;

public interface BusinessService {
	public BusinessInfo getBusinessInfoById(int id);
	public Business getBusinessById(int id);
	public List<Business> getBusinessBybOrder(String bOrder);
	public void updateOintime(String bOrder,int bId,Date oIntime);
	public void updateOouttime(String bOrder,int bId,Date oOuttime);
	Business save(Business business);
}
