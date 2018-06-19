package com.exp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="ware_id")
	private int wId;
	@Column(name="shelf_id")
	private int sId;
	@Column(name="ware_order")
	private String woId;
	@Column(name="ware_order_status")
	private int wostatus;
	@Column(name="ware_order_intime")
	private Date woIntime;
	@Column(name="ware_order_outtime")
	private Date woOuttime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getWoId() {
		return woId;
	}
	public void setWoId(String woId) {
		this.woId = woId;
	}
	public int getWostatus() {
		return wostatus;
	}
	public void setWostatus(int wostatus) {
		this.wostatus = wostatus;
	}
	public Date getWoIntime() {
		return woIntime;
	}
	public void setWoIntime(Date woIntime) {
		this.woIntime = woIntime;
	}
	public Date getWoOuttime() {
		return woOuttime;
	}
	public void setWoOuttime(Date woOuttime) {
		this.woOuttime = woOuttime;
	}
}
