package com.exp.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.exp.dao.BusinessDao;
import com.exp.dao.BusinessInfoDao;
import com.exp.dao.OrderDao;
import com.exp.dao.UserDao;
import com.exp.dao.WareDao;
import com.exp.dao.WarehouseInfodao;
import com.exp.model.Business;
import com.exp.model.BusinessInfo;
import com.exp.model.Order;
import com.exp.model.User;
import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;
import com.exp.service.OrderService;
import com.exp.service.RouteService;
@Service
public class OrderImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	RouteService routeService;
	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private WareDao wareDao;
	@Autowired
	private BusinessInfoDao businessInfoDao;
	@Autowired
	private WarehouseInfodao warehouseInfoDao;
	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return orderDao.findByoId(id);
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		
		return orderDao.save(order);
	}

	@Override
	public Order getOrder(String product, String usName,String urName,String uSender, String uReceive,int eReceive, int eSender, int start, int end,
			int status) {
		// TODO Auto-generated method stub
		String route = routeService.getShortestRoute(start, end);
		String[] routes=route.split("-");
		int size= routes.length;
		int[] address = new int[size];
		for(int i=0;i<size;i++) {
			address[i]=Integer.parseInt(routes[i]);
		}
		String oId = getOrderId();
		Order order = new Order();
		order.setoId(oId);
		order.setOpName(product);
		order.setOusTele(uSender);
		order.setOurTele(uReceive);
		order.setOerId(eReceive);
		order.setOesId(eSender);
		order.setOeId(end);
		order.setOsId(start);
		order.setoRoute(route);
		save(order);
		User user1 = new User();
		user1.setuName(usName);
		user1.setuTelephone(uSender);
		userDao.save(user1);
		User user2 = new User();
		user2.setuName(usName);
		user2.setuTelephone(uSender);
		userDao.save(user2);
		Business business = new Business();
		Warehouse warehouse = new Warehouse();
		
		for(int i=0;i<size;i++) {
			WarehouseInfo warehouseInfo = warehouseInfoDao.findById(address[i]);
			BusinessInfo businessInfo = businessInfoDao.findById(address[i]);
			if(warehouseInfo!=null) {
				warehouse.setwId(address[i]);
				warehouse.setWoId(oId);
				warehouse.setWostatus(0);
				warehouse.setwStore(1000);
				wareDao.save(warehouse);
				int store=warehouseInfo.getStorage();
				store=store-1;
				warehouseInfo.setStorage(store);
			}else if (businessInfo!=null) {
				business.setbId(address[i]);
				business.setbOrder(oId);
				business.setoStatus(0);
				businessDao.save(business);
			}
		}
		return order;
	}
	
	@Override
	public String getOrderId() {
		// TODO Auto-generated method stub
		Timestamp timestamp=new Timestamp(Calendar.getInstance().getTimeInMillis());
		DateFormat dFormat = new SimpleDateFormat("yyyMMddHHmmss");
	    String time = dFormat.format(timestamp);
		int nonce=(int)((Math.random()*9+1)+100000);
		String res= time+Integer.toString(nonce);
		return res;
	}

}

