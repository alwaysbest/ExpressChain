package com.exp.service;


public interface RouteService {
	
//	public List<Route> getAllroute();
//	public List<BusinessInfo> getAllbusiness();
//	public List<WarehouseInfo> getAllwarehouse();
//	public List<Integer> getAllVertex();
//	public int[][] getAllEdges();
//	public List<Vertex> setVertex(int start);
//	public Graph setGraph();
//	public int[] getResRoute(int start,int end);
	
	public int[][] getAllroute();
	public String getShortestRoute(int start,int end);
}
