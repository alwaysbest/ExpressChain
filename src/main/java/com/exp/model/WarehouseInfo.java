package com.exp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="warehouseInfo")
public class WarehouseInfo {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="storage")
	private int storage;
	@ElementCollection(fetch = FetchType.LAZY,targetClass=WareShelf.class)
	@CollectionTable(name="shelf_Info")
		@OrderColumn(name="s_ID")
	private List<WareShelf> shelfs  =new ArrayList<WareShelf>();
	public List<WareShelf> getShelfs() {
		return shelfs;
	}
	public void setShelfs(List<WareShelf> shelfs) {
		this.shelfs = shelfs;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
