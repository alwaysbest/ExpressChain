package com.exp.model;

import java.util.List;

public class Graph {
	private List<Vertex> vertexs;
	private int[][]edges;
	public Graph(List<Vertex> vertexs,int[][]edges) {
		this.vertexs=vertexs;
		this.edges=edges;
	}
	public List<Vertex> getVertexs() {
		return vertexs;
	}
	public void setVertexs(List<Vertex> vertexs) {
		this.vertexs = vertexs;
	}
	public int[][] getEdges() {
		return edges;
	}
	public void setEdges(int[][] edges) {
		this.edges = edges;
	}
	
}
