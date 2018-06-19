package com.exp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.model.Business;
import com.exp.model.Order;
import com.exp.model.WareShelf;
import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;
import com.exp.service.OrderService;
import com.exp.service.WareService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="/ware")
public class WareController {
	@Autowired
	private WareService wareService;
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="/ordercheckin")
	public JSONArray getAllbcheckin(@RequestParam("wid") String wid) {
		int id = Integer.parseInt(wid);
		List<Warehouse> warehouses=  wareService.getWarehouseBywId(id);
		WarehouseInfo warehouseInfo = wareService.getWarehouseInfoById(id);
		String name = warehouseInfo.getName();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		if(warehouses!=null) {
			for(Warehouse warehouse:warehouses) {
				Date date = warehouse.getWoIntime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				if(date==null&&warehouse.getWostatus()==0) {
					String intime="等待输入";
					jsonObject.put("wid",warehouse.getwId());
					jsonObject.put("shelf", warehouse.getsId());
					jsonObject.put("oid", warehouse.getWoId());
					jsonObject.put("status", warehouse.getWostatus());
					jsonObject.put("intime", intime);
					String order = warehouse.getWoId();
					Order order2  = orderService.getOrderById(order);
					String route = order2.getoRoute();
					System.out.println(route);
					System.out.println(name);
					String next = orderService.getNext(route, name);
					System.out.println(next);
					jsonObject.put("next", next);
					jsonArray.add(jsonObject);
					System.out.println(jsonObject);
				}
			}
			return jsonArray;

		}else {
			return null;
		}
	}
	@RequestMapping(value="/ordercheckout")
	public JSONArray getAllbcheckout(@RequestParam("wid") String wid) {
		int id = Integer.parseInt(wid);
		List<Warehouse> warehouses=  wareService.getWarehouseBywId(id);
		WarehouseInfo warehouseInfo = wareService.getWarehouseInfoById(id);
		String name = warehouseInfo.getName();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		if(warehouses!=null) {
			for(Warehouse warehouse:warehouses) {
				Date date = warehouse.getWoOuttime();
				Date date2 = warehouse.getWoIntime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				if(date==null&&warehouse.getWostatus()==1) {
					String intime=sdf.format(date2);
					String outtime="等待输入";
					jsonObject.put("wid",warehouse.getwId());
					jsonObject.put("sid", warehouse.getsId());
					jsonObject.put("oid", warehouse.getWoId());
					jsonObject.put("status", warehouse.getWostatus());
					jsonObject.put("intime", intime);
					jsonObject.put("outtime", outtime);
					String order = warehouse.getWoId();
					Order order2  = orderService.getOrderById(order);
					String route = order2.getoRoute();
					System.out.println(route);
					System.out.println(name);
					String next = orderService.getNext(route, name);
					System.out.println(next);
					jsonObject.put("next", next);
					jsonArray.add(jsonObject);
					System.out.println(jsonObject);
				}
			}
			return jsonArray;

		}else {
			return null;
		}
	}
	
	
	
	@RequestMapping(value="/updatecheckin")
	public void updatecheckinTime(@RequestParam("wid") String wid,@RequestParam("oid") String oid,@RequestParam("time") String time) {
		int wId=Integer.parseInt(wid);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date Intime=new Date();
		try {
			Intime = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wareService.updateWoIntime(oid, wId, Intime);
		
	}
	@RequestMapping(value="/updatecheckout")
	public void updatecheckoutTime(@RequestParam("wid") String wid,@RequestParam("oid") String oid,@RequestParam("time") String time) {
		int wId=Integer.parseInt(wid);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date outtime=new Date();
		try {
			outtime = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wareService.updateWoOuttime(oid, wId, outtime);
		
	}
	@RequestMapping(value="/updateshelf")
	public void updateshelf(@RequestParam("wid") String wid,@RequestParam("oid") String oid,@RequestParam("sid") String sid) {
		int wId=Integer.parseInt(wid);
		int sId=Integer.parseInt(sid);
		wareService.updateShelf(wId,oid,sId);
	}
	@RequestMapping(value="/resetshelf")
	public void resetshelf(@RequestParam("wid") String wid,@RequestParam("sid") String sid) {
		int wId=Integer.parseInt(wid);
		int sId=Integer.parseInt(sid);
		wareService.resetShelf(wId,sId);
	}
	@RequestMapping(value="/changeshelf")
	public void changeshelf(@RequestParam("wid") String wid,@RequestParam("sid") String sid,@RequestParam("store") String store) {
		int wId=Integer.parseInt(wid);
		int sId=Integer.parseInt(sid);
		int sTore=Integer.parseInt(store);
		wareService.changeShelf(wId,sId,sTore);
	}
	
	@RequestMapping(value="/checkshelf")
	public JSONArray checkshelf(@RequestParam("wid") String wid) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int wId=Integer.parseInt(wid);
		List<WareShelf> wareShelfs = wareService.checkShelf(wId);
		for(WareShelf wareShelf:wareShelfs) {
			jsonObject.put("wid", wId);
			jsonObject.put("sid", wareShelf.getShelfId());
			jsonObject.put("sname", wareShelf.getShelfName());
			jsonObject.put("store", wareShelf.getShelfStore());
			jsonArray.add(jsonObject);
		}

		return jsonArray;
	}
	@RequestMapping(value="/buildshelf")
	public void buildshelf(@RequestParam("wid") String wid,@RequestParam("sid") String sid,@RequestParam("sname") String sname,@RequestParam("store") String store) {
		int wId=Integer.parseInt(wid);
		int sId=Integer.parseInt(sid);
		int sTore=Integer.parseInt(store);
		wareService.buildShelf(wId, sId, sname, sTore);
	}
	
}
