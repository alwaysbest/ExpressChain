package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ware_business")
public class RouteWB {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="ware_id")
	private int wId;
	@Column(name="ware_businessId")
	private int wbId;
	@Column(name="ware_businessDistance")
	private int wbDistance;
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
	public int getWbId() {
		return wbId;
	}
	public void setWbId(int wbId) {
		this.wbId = wbId;
	}
	public int getWbDistance() {
		return wbDistance;
	}
	public void setWbDistance(int wbDistance) {
		this.wbDistance = wbDistance;
	}
	
}
