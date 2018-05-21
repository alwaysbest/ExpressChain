package com.exp.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="vertex")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String startName;
	@ElementCollection(fetch = FetchType.LAZY,targetClass=Edge.class)
	@CollectionTable(name="edge_Info")
		@OrderColumn(name="e_ID")
	private List<Edge> edges  =new ArrayList<Edge>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartName() {
		return startName;
	}
	public void setStartName(String startName) {
		this.startName = startName;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	
	
	
//	@Column(name="stop1")
//	private int stop1;
//	@Column(name="stop2")
//	private int stop2;
//	@Column(name="stop3")
//	private int stop3;
//	@Column(name="stop4")
//	private int stop4;
//	@Column(name="ware1")
//	private int ware1;
//	@Column(name="ware2")
//	private int ware2;
	
//	
//	public int getId() {
//		return id;
//	}
//	
//
//	public int getStart() {
//		return start;
//	}
//
//	public void setStart(int start) {
//		this.start = start;
//	}
	
//
//	public int getStop1() {
//		return stop1;
//	}
//
//	public void setStop1(int stop1) {
//		this.stop1 = stop1;
//	}
//
//	public int getStop2() {
//		return stop2;
//	}
//
//	public void setStop2(int stop2) {
//		this.stop2 = stop2;
//	}
//
//	public int getStop3() {
//		return stop3;
//	}
//
//	public void setStop3(int stop3) {
//		this.stop3 = stop3;
//	}
//
//	public int getStop4() {
//		return stop4;
//	}
//
//	public void setStop4(int stop4) {
//		this.stop4 = stop4;
//	}
//
//	public int getWare1() {
//		return ware1;
//	}
//
//	public void setWare1(int ware1) {
//		this.ware1 = ware1;
//	}

//	public int getWare2() {
//		return ware2;
//	}
//
//	public void setWare2(int ware2) {
//		this.ware2 = ware2;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
	
	
	
}
