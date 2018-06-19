package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employer")
public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int eId;
	@Column(name="emp_name")
	private String eName;
	@Column(name="emp_telephone")
	private String eTele;
	@Column(name="type")
	private int type;
	@Column(name="salary")
	private double salary;
	@Column(name="address_id")
	private int aId;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String geteTele() {
		return eTele;
	}
	public void seteTele(String eTele) {
		this.eTele = eTele;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	
}
