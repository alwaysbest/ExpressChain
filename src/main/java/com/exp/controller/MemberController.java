package com.exp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.model.BusinessInfo;
import com.exp.model.Member;
import com.exp.model.MemberOrder;
import com.exp.service.BusinessService;
import com.exp.service.MemberOrderService;
import com.exp.service.MemberService;
import com.exp.service.OrderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberOrderService memberOrderService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BusinessService businessService;
	//建立预约订单
	@RequestMapping(value="/checklogin")
	public int checklogin(@RequestParam("memid") String memid) {
		int memId=Integer.parseInt(memid);
		Member member= memberService.getMember(memId);
		if(member!=null) {
			return memId;
		}else {
			return 0;
		}
		
	}

	@RequestMapping(value="/buildpreorder")
	public void buildpreOrder(@RequestParam("memid") String memid,@RequestParam("sename") String sename,@RequestParam("rename") String rename,@RequestParam("seaddress") String seaddress,@RequestParam("readdress") String readdress,
			
			@RequestParam("setele") String setele,@RequestParam("retele") String retele,@RequestParam("goodinfo") String goodinfo,@RequestParam("busid") String busid) {
		int memId= Integer.parseInt(memid);
		int busId=Integer.parseInt(busid);
		
		memberOrderService.buildpreOrder(memId, sename, rename, seaddress, readdress, setele, retele, goodinfo, busId);
		
	}
	//查看订单
	@RequestMapping(value="/checkmempreorder")
	public JSONArray checkMemPreOrder(@RequestParam("memid") String memid) {
		int memId= Integer.parseInt(memid);
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject = new JSONObject();
		List<MemberOrder> memberOrders = memberOrderService.getMemOrder(memId);
		for(MemberOrder memberOrder:memberOrders) {
			if(memberOrder.getStatus()==0) {
				int busid=memberOrder.getBusid();
				BusinessInfo businessInfo=businessService.getBusinessInfoById(busid);
				String busname=businessInfo.getName();
				jsonObject.put("preorder", memberOrder.getPreorder());
				jsonObject.put("sename", memberOrder.getSename());
				jsonObject.put("rename", memberOrder.getRename());
				jsonObject.put("goodinfo", memberOrder.getGoodinfo());
				jsonObject.put("buname",busname );
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
		
	}
	
	
	@RequestMapping(value="/checkmemnoworder")
	public JSONArray checkMemNowOrder(@RequestParam("memid") String memid) {
		int memId= Integer.parseInt(memid);
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject = new JSONObject();
		List<MemberOrder> memberOrders = memberOrderService.getMemOrder(memId);
		for(MemberOrder memberOrder:memberOrders) {
			if(memberOrder.getStatus()==1) {
				int busid=memberOrder.getBusid();
				BusinessInfo businessInfo=businessService.getBusinessInfoById(busid);
				String busname=businessInfo.getName();
				jsonObject.put("orderid", memberOrder.getOrderid());
				jsonObject.put("sename", memberOrder.getSename());
				jsonObject.put("rename", memberOrder.getRename());
				jsonObject.put("goodinfo", memberOrder.getGoodinfo());
				jsonObject.put("buname",busname );
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
		
	}
	
	@RequestMapping(value="/checkmemhisorder")
	public JSONArray checkMemHisOrder(@RequestParam("memid") String memid) {
		int memId= Integer.parseInt(memid);
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject = new JSONObject();
		List<MemberOrder> memberOrders = memberOrderService.getMemOrder(memId);
		for(MemberOrder memberOrder:memberOrders) {
			if(memberOrder.getStatus()==2) {
				int busid=memberOrder.getBusid();
				BusinessInfo businessInfo=businessService.getBusinessInfoById(busid);
				String busname=businessInfo.getName();
				jsonObject.put("orderid", memberOrder.getOrderid());
				jsonObject.put("sename", memberOrder.getSename());
				jsonObject.put("rename", memberOrder.getRename());
				jsonObject.put("goodinfo", memberOrder.getGoodinfo());
				jsonObject.put("buname",busname );
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray;
		
	}
	//删除预约订单
	@RequestMapping(value="/deletememorder")
	public void deleteMemOrder(@RequestParam("preorder") String preorder) {
		memberOrderService.deletepreOrder(preorder);
		
	}
	//修改预约订单
	@RequestMapping(value="/updatememorder")
	public void updateMemOrder(@RequestParam("preorder") String preorder,@RequestParam("sename") String sename,@RequestParam("rename") String rename,
			@RequestParam("seaddress") String seaddress,@RequestParam("readdress") String readdress,@RequestParam("setele") String setele,
			@RequestParam("retele") String retele,@RequestParam("goodinfo") String goodinfo,@RequestParam("busid") String busid) {
		int busId= Integer.parseInt(busid);
		memberOrderService.updatepreOrder(preorder, sename, rename, seaddress, readdress, setele, retele, goodinfo, busId);
		
	}
	
	//获得预约订单信息
	@RequestMapping(value="/getmemorder")
	public JSONObject getMemOrder(@RequestParam("preorder") String preorder) {
		MemberOrder memberOrder = memberOrderService.getpreOrder(preorder);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pname", memberOrder.getGoodinfo());
		jsonObject.put("sender", memberOrder.getSename());
		jsonObject.put("receiver", memberOrder.getRename());
		jsonObject.put("send", memberOrder.getSetele());
		jsonObject.put("receive", memberOrder.getRetele());
		jsonObject.put("seaddress", memberOrder.getSeaddress());
		jsonObject.put("readdress", memberOrder.getReaddress());
		return jsonObject;
	}
	@RequestMapping(value="/addorderid")
	public void addOrderId(@RequestParam("preorder") String preorder,@RequestParam("orderid") String orderid) {
		memberOrderService.addOrderid(preorder, orderid);
	}

	

}
