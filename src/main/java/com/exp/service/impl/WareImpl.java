package com.exp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.WareDao;
import com.exp.dao.WarehouseInfodao;
import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;
import com.exp.service.WareService;

@Service
public class WareImpl implements WareService {
	@Autowired
	private WareDao wareDao;
	@Autowired
	private WarehouseInfodao warehouseInfoDao;

	@Override
	public WarehouseInfo getWarehouseInfoById(int id) {
		// TODO Auto-generated method stub
		return warehouseInfoDao.findById(id);
	}

	@Override
	public Warehouse getWarehouseById(int id) {
		// TODO Auto-generated method stub
		return wareDao.findById(id);
	}

	@Override
	public List<Warehouse> getWarehouseByoId(String oid) {
		// TODO Auto-generated method stub
		return wareDao.findBywoId(oid);
	}

	@Override
	public Warehouse saveWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return wareDao.save(warehouse);
	}

	@Override
	public void updateWoIntime(String woId, int wId, Date woIntime) {
		// TODO Auto-generated method stub
		wareDao.updatewoIntimeBywoIdAndwId(woId, wId, woIntime);
	}

	@Override
	public void updateWoOuttime(String woId, int wId, Date woOuttime) {
		// TODO Auto-generated method stub
		wareDao.updatewoOuttimeBywoIdAndwId(woId, wId, woOuttime);
	}

}
