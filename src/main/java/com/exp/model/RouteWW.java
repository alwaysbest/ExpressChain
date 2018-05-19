package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ware_ware")
public class RouteWW {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="ware_id")
	private int wId;
	@Column(name="ware_wareId")
	private int wwId;
	@Column(name="ware_wareDistance")
	private int wwDistance;
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
	public int getWwId() {
		return wwId;
	}
	public void setWwId(int wwId) {
		this.wwId = wwId;
	}
	public int getWwDistance() {
		return wwDistance;
	}
	public void setWwDistance(int wwDistance) {
		this.wwDistance = wwDistance;
	}
	
}
