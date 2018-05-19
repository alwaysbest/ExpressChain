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
	private int id;
	@Column(name="ware_id")
	private int wId;
	@Column(name="ware_store")
	private int wStore;
	@Column(name="ware_order")
	private String woId;
	@Column(name="ware_order_status")
	private int wostatus;
	@Column(name="ware_order_intime")
	private Date woIntime;
	@Column(name="ware_order_outtime")
	private Date woOuttime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
	public int getwStore() {
		return wStore;
	}
	public void setwStore(int wStore) {
		this.wStore = wStore;
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
