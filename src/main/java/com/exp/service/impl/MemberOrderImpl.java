package com.exp.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.MemberOrderDao;
import com.exp.model.MemberOrder;
import com.exp.service.MemberOrderService;
@Service
public class MemberOrderImpl implements MemberOrderService {
	@Autowired
	private MemberOrderDao memberOrderDao;

	@Override
	public void buildpreOrder(int memid, String sename, String rename, String seaddress, String readdress,
			String setele, String retele, String goodinfo, int busid) {
		// TODO Auto-generated method stub
		MemberOrder memberOrder = new MemberOrder();
		String preorder = getPreOrderId();
		memberOrder.setPreorder(preorder);
		memberOrder.setMemid(memid);
		memberOrder.setSename(sename);
		memberOrder.setRename(rename);
		memberOrder.setSeaddress(seaddress);
		memberOrder.setReaddress(readdress);
		memberOrder.setSetele(setele);
		memberOrder.setRetele(retele);
		memberOrder.setGoodinfo(goodinfo);
		memberOrder.setBusid(busid);
		memberOrder.setStatus(0);
		memberOrderDao.save(memberOrder);
		
	}
	public String getPreOrderId() {
		
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}

	@Override
	public void changeStatus(String id, int status) {
		// TODO Auto-generated method stub
		MemberOrder memberOrder=memberOrderDao.findByorderid(id);
		if(memberOrder!=null) {
			memberOrder.setStatus(status);
			memberOrderDao.save(memberOrder);
		}
		
	}

	@Override
	public void addOrderid(String id, String orderid) {
		// TODO Auto-generated method stub
		MemberOrder memberOrder=memberOrderDao.findBypreorder(id);
		memberOrder.setOrderid(orderid);
		memberOrder.setStatus(1);
		memberOrderDao.save(memberOrder);
	}

	@Override
	public List<MemberOrder> getPreOrder(int busid) {
		// TODO Auto-generated method stub
		return memberOrderDao.findBybusid(busid);
	}

	@Override
	public List<MemberOrder> getMemOrder(int memid) {
		// TODO Auto-generated method stub
		return memberOrderDao.findBymemid(memid);
	}

	@Override
	public void deletepreOrder(String preorder) {
		// TODO Auto-generated method stub
		MemberOrder memberOrder = memberOrderDao.findBypreorder(preorder);
		
		memberOrderDao.delete(memberOrder);
	}
	@Override
	public void updatepreOrder(String preorder, String sename, String rename, String seaddress, String readdress,
			String setele, String retele, String goodinfo, int busid) {
		// TODO Auto-generated method stub
		MemberOrder memberOrder = memberOrderDao.findBypreorder(preorder);
		memberOrder.setSename(sename);
		memberOrder.setRename(rename);
		memberOrder.setSeaddress(seaddress);
		memberOrder.setReaddress(readdress);
		memberOrder.setSetele(setele);
		memberOrder.setRetele(retele);
		memberOrder.setGoodinfo(goodinfo);
		memberOrder.setBusid(busid);
		memberOrderDao.save(memberOrder);
	}
	@Override
	public MemberOrder getpreOrder(String preorder) {
		// TODO Auto-generated method stub
		return memberOrderDao.findBypreorder(preorder);
	}

}
