package com.exp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="business")
public class Business {
	@Id
	@Column(name = "business_id")
	private int bId;
	@Column(name = "business_name")
	private String bName;
	@Column(name = "business_order")
	private String bOrder;
	@Column(name = "business_order_status")
	private int oStatus;
	@Column(name = "business_order_intime")
	private Timestamp oIntime;
	@Column(name = "business_order_outtime")
	private Timestamp oOuttime;
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId=bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbOrder() {
		return bOrder;
	}
	public void setbOrder(String bOrder) {
		this.bOrder = bOrder;
	}
	public int getoStatus() {
		return oStatus;
	}
	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
	}
	public Timestamp getoIntime() {
		return oIntime;
	}
	public void setoIntime(Timestamp oIntime) {
		this.oIntime = oIntime;
	}
	public Timestamp getoOuttime() {
		return oOuttime;
	}
	public void setoOuttime(Timestamp oOuttime) {
		this.oOuttime = oOuttime;
	}
	
	
	
}
