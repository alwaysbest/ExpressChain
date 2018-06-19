package com.exp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.dao.BusinessInfoDao;
import com.exp.model.Business;
import com.exp.model.BusinessInfo;
import com.exp.model.MemberOrder;
import com.exp.model.Order;
import com.exp.service.BusinessService;
import com.exp.service.MemberOrderService;
import com.exp.service.OrderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="/business")
public class BussController {
	@Autowired
	private BusinessService businessService;
	@Autowired
	private MemberOrderService memberOrderService;
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="/bordercheckin")
	public JSONArray getAllbcheckin(@RequestParam("bid") String bid) {
		int id = Integer.parseInt(bid);
		List<Business> businesses=  businessService.getBusinessBybId(id);
		BusinessInfo businessesInfo = businessService.getBusinessInfoById(id);
		String name = businessesInfo.getName();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		if(businesses!=null) {
			for(Business business:businesses) {
				Date date = business.getoIntime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				if(date==null&&business.getoStatus()==0) {
					String intime="等待输入";
					jsonObject.put("bid",business.getbId());
					jsonObject.put("oid", business.getbOrder());
					jsonObject.put("status", business.getoStatus());
					jsonObject.put("intime", intime);
					String order = business.getbOrder();
					Order order2  = orderService.getOrderById(order);
					String route = order2.getoRoute();
					System.out.println(route);
					System.out.println(name);
					String next = orderService.getNext(route, name);
					System.out.println(next);
					jsonObject.put("next", next);
					jsonArray.add(jsonObject);
				}
			}
			return jsonArray;

		}else {
			return null;
		}
	}
	@RequestMapping(value="/bordercheckout")
	public JSONArray getAllbcheckout(@RequestParam("bid") String bid) {
		int id = Integer.parseInt(bid);
		List<Business> businesses=  businessService.getBusinessBybId(id);
		BusinessInfo businessesInfo = businessService.getBusinessInfoById(id);
		String name = businessesInfo.getName();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		if(businesses!=null) {
			for(Business business:businesses) {
				Date date1=business.getoIntime();
				Date date = business.getoOuttime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				if(date==null&&business.getoStatus()==1) {
					String intime = sdf.format(date1);
					String outtime="等待输入";
					jsonObject.put("bid", business.getbId());
					jsonObject.put("oid", business.getbOrder());
					jsonObject.put("status", business.getoStatus());
					jsonObject.put("intime", intime);
					jsonObject.put("outime", outtime);
					String order = business.getbOrder();
					Order order2  = orderService.getOrderById(order);
					String route = order2.getoRoute();
					System.out.println(route);
					System.out.println(name);
					String next = orderService.getNext(route, name);
					System.out.println(next);
					jsonObject.put("next", next);
					jsonArray.add(jsonObject);
				}
				
			}
			return jsonArray;

		}else {
			return null;
		}
	}
	@RequestMapping(value="/updatecheckin")
	public void updatecheckinTime(@RequestParam("bid") String bid,@RequestParam("oid") String oid,@RequestParam("time") String time) {
		int bId=Integer.parseInt(bid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date Intime=new Date();
		try {
			Intime = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memberOrderService.changeStatus(oid, 1);
		businessService.updateOintime(oid, bId, Intime);
		
	}
	@RequestMapping(value="/updatecheckout")
	public void updatecheckoutTime(@RequestParam("bid") String bid,@RequestParam("oid") String oid,@RequestParam("time") String time) {
		int bId=Integer.parseInt(bid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date Intime=new Date();
		try {
			Intime = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(orderService.getRoute(oid)=="已经签收") {
			memberOrderService.changeStatus(oid, 2);
		}
		businessService.updateOouttime(oid, bId, Intime);
		
	}
	@RequestMapping(value="/managepreorder")
	public JSONArray managePreOrder(@RequestParam("bid") String bid) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int busid = Integer.parseInt(bid);
		List<MemberOrder> memberOrders = memberOrderService.getPreOrder(busid);
		if(memberOrders!=null) {
			for(MemberOrder memberOrder:memberOrders) {
				if(memberOrder.getStatus()==0) {
					String empid="等待安排";
					jsonObject.put("preorder", memberOrder.getPreorder());
					jsonObject.put("readdress", memberOrder.getReaddress());
					jsonObject.put("empid", empid);
					
					jsonArray.add(jsonObject);
				}

			}
		}
		

		return jsonArray;
	}
	
	
}
