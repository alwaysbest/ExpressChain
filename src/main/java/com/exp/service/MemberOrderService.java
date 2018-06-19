package com.exp.service;

import java.util.List;


import com.exp.model.MemberOrder;

public interface MemberOrderService {
	public void  buildpreOrder(int memid,String sename,String rename,String seaddress,String readdress,String setele,String retele,String goodinfo,int busid);
	public void  changeStatus(String id,int status);
	public void  addOrderid(String id,String orderid);
	public List<MemberOrder> getPreOrder(int busid);//营业厅用来处理预约订单
	public List<MemberOrder> getMemOrder(int memid);//会员用来查看订单
	public void deletepreOrder(String preorder);
	public MemberOrder getpreOrder(String preorder);
	public void updatepreOrder(String preorder,String sename,String rename,String seaddress,String readdress,String setele,String retele,String goodinfo,int busid);
}
