package com.exp.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.exp.model.WareShelf;
import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;

public interface WareService {
	public WarehouseInfo getWarehouseInfoById(int id);
	public List<WarehouseInfo> getAll();
	public List<Warehouse> getWarehouseBywId(int wid);
	public List<Warehouse> getWarehouseByoId(String oid);
	Warehouse saveWarehouse(Warehouse warehouse);
	public void updateWoIntime(String woId,int wId,Date woIntime);
	public void updateWoOuttime(String woId,int wId,Date woOuttime);
	public void updateStatus(String woId,int wId,int status);
	public int getStatus(String woId,int wId);
	public void updateShelf(int wid,String oid,int sid);
	public void resetShelf(int wid,int sid);
	public List<WareShelf> checkShelf(int wid);
	public void changeShelf(int wId, int sId, int sTore);
	public void buildShelf(int wid,int sid,String sname,int store);
}
