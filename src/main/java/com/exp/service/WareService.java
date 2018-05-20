package com.exp.service;

import java.util.Date;
import java.util.List;

import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;

public interface WareService {
	public WarehouseInfo getWarehouseInfoById(int id);
	public Warehouse getWarehouseById(int id);
	public List<Warehouse> getWarehouseByoId(String oid);
	Warehouse saveWarehouse(Warehouse warehouse);
	public void updateWoIntime(String woId,int wId,Date woIntime);
	public void updateWoOuttime(String woId,int wId,Date woOuttime);
}
