package com.exp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="business")
public class Business {
	@Id
	@Column(name="id")
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "business_id")
	private int bId;
	@Column(name = "business_order")
	private String bOrder;
	@Column(name = "business_order_status")
	private int oStatus;
	@Column(name = "business_order_intime")
	private Date oIntime;
	@Column(name = "business_order_outtime")
	private Date oOuttime;
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId=bId;
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
	public Date getoIntime() {
		return oIntime;
	}
	public void setoIntime(Date oIntime) {
		this.oIntime = oIntime;
	}
	public Date getoOuttime() {
		return oOuttime;
	}
	public void setoOuttime(Date oOuttime) {
		this.oOuttime = oOuttime;
	}
	
	
	
}
