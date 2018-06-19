package com.exp.service;

import java.util.Date;
import java.util.List;

import com.exp.model.Business;
import com.exp.model.BusinessInfo;
import com.exp.model.MemberOrder;

public interface BusinessService {
	public BusinessInfo getBusinessInfoById(int id);
	
	public List<Business> getBusinessBybOrder(String bOrder);
	public void updateOintime(String bOrder,int bId,Date oIntime);
	public void updateOouttime(String bOrder,int bId,Date oOuttime);
	Business save(Business business);
	public void updateOstatus(String bOrder,int bId,int status);
	public int getStatus(String bOrder,int id);
	public List<Business> getBusinessBybId(int bid);
	public List<MemberOrder> getMemOrderBybId(int bid);
	
}
