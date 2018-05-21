package com.exp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Edge {
	private int endName;
	private int distance;
	public int getEndName() {
		return endName;
	}
	public void setEndName(int endName) {
		this.endName = endName;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
