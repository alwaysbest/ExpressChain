package com.exp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.model.Order;
import com.exp.service.OrderService;

import net.sf.json.JSONObject;


@RestController
@RequestMapping(value="/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="/ordercheck")
	public JSONObject checkOrder(@RequestParam("orderid") String orderId) {
		Order order  = orderService.getOrderById(orderId);
		JSONObject jsonObject = new JSONObject();
		
		if(order!=null) {
			String address  = orderService.getRoute(order.getoId());
			jsonObject.put("id", order.getoId());
			jsonObject.put("name",order.getOpName());
			jsonObject.put("route",order.getoRoute() );
			jsonObject.put("address", address);
			
			return jsonObject;
		}else {
			return null;
		}
		
	}
	@RequestMapping(value="/orderbuild")
	public JSONObject buildOrder(@RequestParam("pname") String pname,@RequestParam("sender") String sender,@RequestParam("receiver") String receiver,@RequestParam("send") String send,@RequestParam("receive") String receive,@RequestParam("empid") String empid,@RequestParam("start") String start,@RequestParam("end") String end) {
		System.out.println("pname:"+pname);
		int emp  =Integer.parseInt(empid);
		int startid = Integer.parseInt(start);
		int endid=Integer.parseInt(end);
		Order order = orderService.getOrder(pname, sender, receiver, send, receive, emp, startid, endid, 0);
		JSONObject res=new JSONObject();
		res.put("orderid", order.getoId());
		res.put("route",order.getoRoute() );
		System.out.println("testbuild");
		return res;
	}
}
