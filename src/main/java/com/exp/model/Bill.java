package com.exp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expense")
public class Bill {
	@Id
	@Column(name="address")
	private int address;
	@Column(name="expense")
	private double expense;
	@Column(name="receive")
	private double receive;
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public double getReceive() {
		return receive;
	}
	public void setReceive(double receive) {
		this.receive = receive;
	}
	
	
}
