package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bysuness_business")
public class RouteBB {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="business_id")
	private int bId;
	@Column(name="business_businessId")
	private int bbId;
	@Column(name="business_busDistance")
	private int bbDistance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getBbId() {
		return bbId;
	}
	public void setBbId(int bbId) {
		this.bbId = bbId;
	}
	public int getBbDistance() {
		return bbDistance;
	}
	public void setBbDistance(int bbDistance) {
		this.bbDistance = bbDistance;
	}
	
}
