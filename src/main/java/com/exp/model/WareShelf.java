package com.exp.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class WareShelf {
	private int shelfId;
	private int shelfStore;
	
	
	public int getShelfStore() {
		return shelfStore;
	}
	public void setShelfStore(int shelfStore) {
		this.shelfStore = shelfStore;
	}
	private String shelfName;
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	
}
