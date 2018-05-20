package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`order`")
public class Order {
	@Id
	@Column(name="order_id")
	private String oId;
	@Column(name="order_product")
	private String opName;
	@Column(name="order_user_send")
	private String ousTele;
	@Column(name="order_user_receive")
	private String ourTele;
	@Column(name="order_employer_receive")
	private int oerId;
	@Column(name="order_employer_send")
	private int oesId;
	@Column(name="order_start")
	private int osId;
	@Column(name="order_end")
	private int oeId;
	@Column(name="order_status")
	private int oStatus;
	@Column(name="order_route")
	private String oRoute;
	public String getoRoute() {
		return oRoute;
	}
	public void setoRoute(String oRoute) {
		this.oRoute = oRoute;
	}
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	
	public String getOusTele() {
		return ousTele;
	}
	public void setOusTele(String ousTele) {
		this.ousTele = ousTele;
	}
	public String getOurTele() {
		return ourTele;
	}
	public void setOurTele(String ourTele) {
		this.ourTele = ourTele;
	}
	public int getOerId() {
		return oerId;
	}
	public void setOerId(int oerId) {
		this.oerId = oerId;
	}
	public int getOesId() {
		return oesId;
	}
	public void setOesId(int oesId) {
		this.oesId = oesId;
	}
	public int getOsId() {
		return osId;
	}
	public void setOsId(int osId) {
		this.osId = osId;
	}
	public int getOeId() {
		return oeId;
	}
	public void setOeId(int oeId) {
		this.oeId = oeId;
	}
	public int getoStatus() {
		return oStatus;
	}
	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
	}
	
	
	
}
