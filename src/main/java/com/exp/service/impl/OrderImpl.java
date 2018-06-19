package com.exp.service.impl;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.exp.service.BusinessService;
import com.exp.service.MemberOrderService;
import com.exp.service.OrderService;
import com.exp.service.RouteService;
import com.exp.service.WareService;
@Service

@Transactional
public class OrderImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	RouteService routeService;
	@Autowired
	BusinessService businessService;
	@Autowired
	WareService wareService;
	@Autowired
	MemberOrderService memberOrderService;
	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private WareDao wareDao;
	@Autowired
	private BusinessInfoDao businessInfoDao;
	@Autowired
	private WarehouseInfodao warehouseInfoDao;
	@Override
	public Order getOrderById(String id) {
		// TODO Auto-generated method stub
		return orderDao.findByoId(id);
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		
		return orderDao.save(order);
	}

	@Override
	public Order getOrder(String product, String usName,String urName,String uSender, String uReceive,int eReceive, int start, int end,
			int status) {
		// TODO Auto-generated method stub
		String route = routeService.getShortestRoute(start, end);
		String[] routes=route.split("-");
		int size= routes.length;
		int[] address = new int[size];
		String reRoute  = "";
		for(int i=1;i<size;i++) {
			address[i]=Integer.parseInt(routes[i]);
			WarehouseInfo warehouseInfo = warehouseInfoDao.findById(address[i]);
			System.out.println(warehouseInfo);
			BusinessInfo businessInfo = businessInfoDao.findById(address[i]);
			if(businessInfo!=null) {
				reRoute=reRoute+"->"+businessInfo.getName();
			}else if (warehouseInfo!=null) {
				reRoute=reRoute+"->"+warehouseInfo.getName();
			}
		}
		String oId = getOrderId();
		Order order = new Order();
		order.setoId(oId);
		order.setOpName(product);
		order.setOusTele(uSender);
		order.setOurTele(uReceive);
		order.setOerId(eReceive);
		order.setOeId(end);
		order.setOsId(start);
		order.setoRoute(reRoute);
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
		
		System.out.println("size:"+size);
		if(address[1]==address[size-1]) {
			BusinessInfo businessInfo = businessInfoDao.findById(address[0]);
			if(businessInfo!=null) {
//				reRoute=reRoute+"->"+businessInfo.getName();
				String id=getwbId();
				business.setId(id);;
				business.setbId(address[0]);
				business.setbOrder(oId);
				business.setoStatus(0);
				businessDao.save(business);
				System.out.println("test111");
			}
		}else {
			
			
			for(int i=1;i<size;i++) {
				int point = address[i];
				WarehouseInfo warehouseInfo = warehouseInfoDao.findById(point);
				System.out.println(warehouseInfo);
				BusinessInfo businessInfo = businessInfoDao.findById(point);
				System.out.println(business);
				if(warehouseInfo!=null) {
					
					String id = getwbId();
					warehouse.setId(id);
					warehouse.setwId(point);
					warehouse.setWoId(oId);
					warehouse.setWostatus(0);
					warehouse.setsId(0);;
					wareDao.save(warehouse);
					int store=warehouseInfo.getStorage();
					System.out.println("store:"+store);
					store=store-1;
					System.out.println("store:"+store);
					System.out.println("ware:"+point);
					warehouseInfoDao.updatestorageById(point, store);
					System.out.println("test");
				}else if (businessInfo!=null) {
//					reRoute=reRoute+"->"+businessInfo.getName();
					String id=getwbId();
					business.setId(id);;
					business.setbId(point);
					business.setbOrder(oId);
					business.setoStatus(0);
					businessDao.save(business);
					System.out.println("test222");
				}
			}
			
		}
//		for(int i=0;i<size;i++) {
//			int point = address[i];
//			WarehouseInfo warehouseInfo = warehouseInfoDao.findById(point);
//			System.out.println(warehouseInfo);
//			BusinessInfo businessInfo = businessInfoDao.findById(point);
//			System.out.println(business);
//			if(warehouseInfo!=null) {
//				
//				String id = getwbId();
//				warehouse.setId(id);
//				warehouse.setwId(point);
//				warehouse.setWoId(oId);
//				warehouse.setWostatus(0);
//				warehouse.setsId(0);;
//				wareDao.save(warehouse);
//				int store=warehouseInfo.getStorage();
//				System.out.println("store:"+store);
//				store=store-1;
//				System.out.println("store:"+store);
//				System.out.println("ware:"+point);
//				warehouseInfoDao.updatestorageById(point, store);
//				System.out.println("test");
//			}else if (businessInfo!=null) {
////				reRoute=reRoute+"->"+businessInfo.getName();
//				String id=getwbId();
//				business.setId(id);;
//				business.setbId(point);
//				business.setbOrder(oId);
//				business.setoStatus(0);
//				businessDao.save(business);
//				System.out.println("test222");
//			}
//		}
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
	public String getwbId() {
		// TODO Auto-generated method stub
		Timestamp timestamp=new Timestamp(Calendar.getInstance().getTimeInMillis());
		DateFormat dFormat = new SimpleDateFormat("yyyMMddHHmmss");
	    String time = dFormat.format(timestamp);
		int nonce=(int)((Math.random()*9+1)+100);
		String res= time+Integer.toString(nonce);
		
		return res;
	}
	
	@Override
	public String getRoute(String Order) {
		// TODO Auto-generated method stub
		Order order2 = orderDao.findByoId(Order);
		String route =  order2.getoRoute();
		System.out.println(route);
		String[]tmp = route.split("->");
		System.out.println("oid"+Order);
		
		int size = tmp.length-1;
		List<String> wait0= new ArrayList<>();
		List<String> wait1= new ArrayList<>();
		List<String> wait2= new ArrayList<>();
		int tmp1=0;
		
		for(int i=1;i<tmp.length;i++) {
			
			WarehouseInfo warehouseInfo= warehouseInfoDao.findByname(tmp[i]);
			System.out.println(tmp[i]);
			BusinessInfo businessInfo = businessInfoDao.findByname(tmp[i]);
			if(businessInfo!=null) {
				tmp1=businessService.getStatus(Order, businessInfo.getId());
				System.out.println("bb1"+tmp1);
				switch (tmp1) {
				case 0:
					wait0.add(tmp[i]);
					break;
				case 1:
					wait1.add(tmp[i]);
				case 2:
					wait2.add(tmp[i]);
				}
			}else if (warehouseInfo!=null) {
				tmp1=wareService.getStatus(Order, warehouseInfo.getId());
				System.out.println("ware11"+tmp1);
				switch (tmp1) {
				case 0:
					wait0.add(tmp[i]);
					break;
				case 1:
					wait1.add(tmp[i]);
				case 2:
					wait2.add(tmp[i]);
				}
			}
			
			
		}
		System.out.println("w0:"+wait0);
		System.out.println("w1"+wait1);
		System.out.println("w2"+wait2);
		if(wait0.contains(tmp[1])) {
			return "等待入库";
		}else if (wait2.contains(tmp[size])) {
			
			return "已经签收";
		}else {
			if(wait1.size()==0) {
				
				String res = "正在从"+wait2.get(wait2.size()-1)+"前往下一个地点";
				return res;
			}else {
				String res = wait1.get(wait1.size()-1);
				return res;
			}

			
			
			
		}
		
	}

	@Override
	public String getNext(String route, String name) {
		// TODO Auto-generated method stub
		String[]tmp = route.split("->");
		int size = tmp.length;
		String reString="";
		for(int i = 1;i<size;i++) {
			if(tmp[i].equals(name)) {
				if(i!=(size-1)) {
					System.out.println(route);
					System.out.println(name);
					System.out.println(tmp[i+1]);
					reString = tmp[i+1];
				}else {
					reString="待签收";
				}
				
			}
		}
		return reString;
		
		
	}

}

