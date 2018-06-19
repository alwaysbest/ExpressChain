package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="memOrder")
public class MemberOrder {
	@Id
	@Column(name="preOrderId")
	private String preorder;
	@Column(name="memId")
	private int memid;
	@Column(name="sename")
	private String sename;
	@Column(name="`rename`")
	private String rename;
	@Column(name="seaddress")
	private String seaddress;
	@Column(name="readdress")
	private String readdress;
	@Column(name="setele")
	private String setele;
	@Column(name="retele")
	private String retele;
	@Column(name="goodinfo")
	private String goodinfo;
	@Column(name="busid")
	private int busid;
	@Column(name="orderId")
	private String orderid;
	@Column(name="status")
	private int status;
	public String getPreorder() {
		return preorder;
	}
	public void setPreorder(String preorder) {
		this.preorder = preorder;
	}
	public int getMemid() {
		return memid;
	}
	public void setMemid(int memid) {
		this.memid = memid;
	}
	public String getSename() {
		return sename;
	}
	public void setSename(String sename) {
		this.sename = sename;
	}
	public String getRename() {
		return rename;
	}
	public void setRename(String rename) {
		this.rename = rename;
	}
	public String getSeaddress() {
		return seaddress;
	}
	public void setSeaddress(String seaddress) {
		this.seaddress = seaddress;
	}
	public String getReaddress() {
		return readdress;
	}
	public void setReaddress(String readdress) {
		this.readdress = readdress;
	}
	public String getSetele() {
		return setele;
	}
	public void setSetele(String setele) {
		this.setele = setele;
	}
	public String getGoodinfo() {
		return goodinfo;
	}
	public void setGoodinfo(String goodinfo) {
		this.goodinfo = goodinfo;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRetele() {
		return retele;
	}
	public void setRetele(String retele) {
		this.retele = retele;
	}
	
	
	
	
	
}
