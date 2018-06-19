package com.exp.service.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.exp.dao.WareDao;
import com.exp.dao.WarehouseInfodao;
import com.exp.model.WareShelf;
import com.exp.model.Warehouse;
import com.exp.model.WarehouseInfo;
import com.exp.service.WareService;

@Service
@Transactional
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
		int status=1;
		wareDao.updatewoIntimeBywoIdAndwId(woId, wId, woIntime);
		
		updateStatus(woId, wId, status);
	}

	@Override
	public void updateWoOuttime(String woId, int wId, Date woOuttime) {
		// TODO Auto-generated method stub
		int status=2;
		wareDao.updatewoOuttimeBywoIdAndwId(woId, wId, woOuttime);
		updateStatus(woId, wId, status);
	}

	@Override
	public void updateStatus(String woId, int wId, int status) {
		// TODO Auto-generated method stub
		wareDao.updatewostatusBywoIdAndwId(woId, wId, status);
	}

	@Override
	public int getStatus(String woId, int wId) {
		// TODO Auto-generated method stub
		return wareDao.findwostatusBywoIdAndwId(woId, wId);
	}


	@Override
	public List<WarehouseInfo> getAll() {
		// TODO Auto-generated method stub
		return warehouseInfoDao.findAll();
	}


	@Override
	public List<Warehouse> getWarehouseBywId(int wid) {
		// TODO Auto-generated method stub
		return wareDao.findBywId(wid);
	}


	@Override
	public void updateShelf(int wid,String oid,int sid) {
		// TODO Auto-generated method stub
	   WarehouseInfo warehouseInfo= warehouseInfoDao.findById(wid);
	   List<WareShelf> shelfs = warehouseInfo.getShelfs();
	   for(WareShelf shelf:shelfs) {
		   if(shelf.getShelfId()==sid) {
			   wareDao.updatesIdBywoIdAndwId(oid, wid, sid);
			   int store=shelf.getShelfStore();
			   store=store-1;
			   shelf.setShelfStore(store);
		   }
	   }
	}


	@Override
	public void resetShelf(int wid, int sid) {
		// TODO Auto-generated method stub
		WarehouseInfo warehouseInfo= warehouseInfoDao.findById(wid);
		   List<WareShelf> shelfs = warehouseInfo.getShelfs();
		   for(WareShelf shelf:shelfs) {
			   if(shelf.getShelfId()==sid) {
				   int store=shelf.getShelfStore();
				   store=store+1;
				   shelf.setShelfStore(store);
				   
			   }
		   }
	}


	@Override
	public List<WareShelf> checkShelf(int wid) {
		// TODO Auto-generated method stub
		WarehouseInfo warehouseInfo= warehouseInfoDao.findById(wid);
		return warehouseInfo.getShelfs();
	}


	@Override
	public void changeShelf(int wId, int sId, int sTore) {
		// TODO Auto-generated method stub
		WarehouseInfo warehouseInfo= warehouseInfoDao.findById(wId);
		   List<WareShelf> shelfs = warehouseInfo.getShelfs();
		   for(WareShelf shelf:shelfs) {
			   if(shelf.getShelfId()==sId) {
				   int store=shelf.getShelfStore();
				   store=sTore;
				   shelf.setShelfStore(store);
			   }
		   }
	}


	@Override
	public void buildShelf(int wid, int sid, String sname, int store) {
		// TODO Auto-generated method stub
		WarehouseInfo warehouseInfo= warehouseInfoDao.findById(wid);
		List<WareShelf> shelfs = warehouseInfo.getShelfs();
		WareShelf wareShelf = new WareShelf();
		wareShelf.setShelfId(sid);
		wareShelf.setShelfName(sname);
		wareShelf.setShelfStore(store);
		shelfs.add(wareShelf);
	}

}
